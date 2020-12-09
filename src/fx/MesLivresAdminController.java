/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import book_store.My_connexion;
import book_store.service.ServiceBook;
import bookstore.model.Book;

import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MesLivresAdminController implements Initializable {
	
    My_connexion cnx;

	 
    @FXML
    private Button back;
    @FXML
    private Button ajouterButton;
    @FXML
    private Button stats;
    @FXML
    private StackPane parent;
    @FXML
    private AnchorPane anchor;
    @FXML
    private TableView<Book> Table;
    @FXML
    private TableColumn<Book, String> Id;
    @FXML
    private TableColumn<Book, String> Genre;
    @FXML
    private TableColumn<Book, String>Titre;
    @FXML
    private TableColumn<Book, String>Auteur;
    @FXML
    private TableColumn<Book, String> Prix;
    @FXML
    private TableColumn<Book, String> Pages;
    @FXML
    private TableColumn<Book, String> Quantite;
   ObservableList<Book> Books = FXCollections.observableArrayList();
    @FXML
    private Label username;
    @FXML
    private Label id;
    
    @FXML
    private TextField chercher;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InitColumn();
        Books=loadData(Books);
        FilteredList<Book> filteredList= new FilteredList<Book>(Books,b->true);
        chercher.textProperty().addListener((Books,oldValue,newValue)->{
             filteredList.setPredicate((Book b) -> {
                 if (newValue==null||newValue.isEmpty())
                     return true;
                 String lowerCase = newValue.toLowerCase();
                 
                 if(b.getTitre().toLowerCase().indexOf(lowerCase)!= -1)
                     return true; 
                 else {
                     return false;}
             });
               
         });
        SortedList<Book> sortedList= new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(Table.comparatorProperty());
        Table.setItems(sortedList);
        addSuppToTableView();
        addModifierToTableView();
        
    }    
   public void InitColumn(){
           Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
           Genre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
           Titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
           Auteur.setCellValueFactory(new PropertyValueFactory<>("Auteur"));
           Prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
           Pages.setCellValueFactory(new PropertyValueFactory<>("nbrPages"));
           Quantite.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
           
    }
   public void setUsername(String user){
	      this.username.setText(user);
	   }
   public void setId(String id){
	      this.id.setText(id);
	   }
  
    public ObservableList<Book> loadData(ObservableList<Book> Books){
        try{
               My_connexion cnx = My_connexion.getIstance();
               String req ="select * from livre ";
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   Book b = new Book();

                   b.setId(rs.getInt("Id"));
                   b.setGenre(rs.getString("Genre"));
                   b.setTitre(rs.getString("Titre"));
                   b.setAuteur(rs.getString("Auteur"));
                   b.setPrix(rs.getFloat("Prix"));
                   b.setNbrPages(rs.getInt("nbrPages"));
                   b.setQuantite(rs.getInt("Quantite"));

                                               
                   Books.add(b);
               }
           }
           catch(Exception e){
               
           }
        return Books;
    }
    
 public void addSuppToTableView(){
        
        TableColumn<Book, Void> tableSupprimer = new TableColumn("Supprimer");
        Callback<TableColumn<Book, Void>, TableCell<Book, Void>> cellFactory = new Callback<TableColumn<Book, Void>, TableCell<Book, Void>>() {
            @Override
            public TableCell<Book, Void> call(final TableColumn<Book, Void> param) {
                final TableCell<Book, Void> cell = new TableCell<Book, Void>() {

                    private final Button btn = new Button("supprimer");

                    {
                        
                        
                        btn.setOnAction((ActionEvent event) -> {
                            int i = getTableView().getItems().get(getIndex()).getId();
                             String g = getTableView().getItems().get(getIndex()).getGenre();
                              String t = getTableView().getItems().get(getIndex()).getTitre();
                               String a = getTableView().getItems().get(getIndex()).getAuteur();
                               Float p = getTableView().getItems().get(getIndex()).getPrix();
                               int nP = getTableView().getItems().get(getIndex()).getNbrPages();

                            Book b = new Book();
                            System.out.println("selected Book : " + i);
                            b.setId(i);;
                            b.setGenre(g);
                            b.setTitre(t);
                            b.setAuteur(a);
                            b.setPrix(p);
                            b.setNbrPages(nP);
                            supprimerButton(b);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
       tableSupprimer.setCellFactory(cellFactory);
       Table.getColumns().add(tableSupprimer);
         
    }
    public void supprimerButton(Book b){
		  ServiceBook sb=new ServiceBook();
		  System.out.println("id :"+b.getId());
		  
		  sb.supprimerBook1(b);
		}
    
 public void addModifierToTableView(){
        
        TableColumn<Book, Void> tableModifier = new TableColumn("Modifier");
        Callback<TableColumn<Book, Void>, TableCell<Book, Void>> cellFactory = new Callback<TableColumn<Book, Void>, TableCell<Book, Void>>() {
            @Override
            public TableCell<Book, Void> call(final TableColumn<Book, Void> param) {
                final TableCell<Book, Void> cell = new TableCell<Book, Void>() {

                    private final Button btn = new Button("modifier");

                    {
                            btn.setOnAction((ActionEvent event) -> {
                            int i = getTableView().getItems().get(getIndex()).getId();
                            System.out.println("bbbbb:"+i);
                            ModifierButton(event,i);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
       tableModifier.setCellFactory(cellFactory);
       Table.getColumns().add(tableModifier);
         
    }
    public void ModifierButton(ActionEvent event,int i){
    	try { 
    	
            String user=username.getText();
           

            FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifierLivre.fxml"));
         Parent root1=(Parent) loader.load();
         ModifierLivreController rc = loader.getController();
         rc.setUsername(i+"");

         Stage stage=new Stage();
         stage.setScene(new Scene(root1));
         stage.show();
         System.out.println("button"+i);
         
    } catch (IOException ex) {
        System.err.println(ex);
    }
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
       FXMLLoader loader=new FXMLLoader(getClass().getResource("IU_Admin.fxml"));
             
             Parent root=(Parent) loader.load();  
             Scene scene = back.getScene();
             root.translateYProperty().set(scene.getHeight());
             
             parent.getChildren().add(root);
             
             Timeline t = new Timeline();
            KeyValue kv= new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            t.getKeyFrames().add(kf);
            t.play();
    }
    
    public void AjouterButton(ActionEvent event){
    	try { 
    	
            String user=username.getText();
    	 FXMLLoader loader=new FXMLLoader(getClass().getResource("AjouterLivre.fxml"));
         Parent root1=(Parent) loader.load();
         AjouterLivreController rc = loader.getController();
         rc.setUsername(user);
         Stage stage=new Stage();
         stage.setScene(new Scene(root1));
         stage.show();
         
    } catch (IOException ex) {
        System.err.println(ex);
    }
    }
    
    @FXML
    void voirStat(ActionEvent event) {
    	 try {

             FXMLLoader loader=new FXMLLoader(getClass().getResource("barchartAdminQuantite.fxml"));
              Parent root1=(Parent) loader.load();
             barchartAdminQuantiteController rc = loader.getController();
             
              Stage stage=new Stage();
              stage.setScene(new Scene(root1));
              stage.show();
         } catch (IOException ex) {
             System.err.println(ex);
         }
    }
    
 
             
     
    
}

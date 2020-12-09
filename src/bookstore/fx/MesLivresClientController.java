/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.connexion.My_connexion;
import bookstore.service.ServiceBook;
import bookstore.model.Book;

import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.sun.webkit.UIClient;

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
public class MesLivresClientController implements Initializable {
	
    My_connexion cnx;

	 
    @FXML
    private Button back;
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
        addDetailsToTableView();
        
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
    
 
    
 public void addDetailsToTableView(){
        
        TableColumn<Book, Void> tableDetails = new TableColumn("D�tails");
        Callback<TableColumn<Book, Void>, TableCell<Book, Void>> cellFactory = new Callback<TableColumn<Book, Void>, TableCell<Book, Void>>() {
            @Override
            public TableCell<Book, Void> call(final TableColumn<Book, Void> param) {
                final TableCell<Book, Void> cell = new TableCell<Book, Void>() {

                    private final Button btn = new Button("Voir plus..");

                    {
                            btn.setOnAction((ActionEvent event) -> {
                           String s1=getTableView().getItems().get(getIndex()).getGenre();
                           String s2=getTableView().getItems().get(getIndex()).getTitre();
                           String s3=getTableView().getItems().get(getIndex()).getAuteur();
                           float s4a=getTableView().getItems().get(getIndex()).getPrix();
                           int s5a=getTableView().getItems().get(getIndex()).getNbrPages();
                           String s4=String.valueOf(s4a);
                           String s5=String.valueOf(s5a);
                           
                            DetailsButton(event,s1,s2,s3,s4,s5);
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
       tableDetails.setCellFactory(cellFactory);
       Table.getColumns().add(tableDetails);
         
    }
    public void DetailsButton(ActionEvent event,String s1,String s2,String s3,String s4,String s5){
    	 try { 
    	
           String user=username.getText();
           
    	 FXMLLoader loader=new FXMLLoader(getClass().getResource("DetailsLivre.fxml"));
         Parent root1=(Parent) loader.load();
         DetailsLivreController rc = loader.getController();
         rc.setUsername(user);
         rc.setDetails(s1, s2, s3, s4, s5);
         Stage stage=new Stage();
         stage.setScene(new Scene(root1));
         stage.show();
         
    } catch (IOException ex) {
        System.err.println(ex);
    }
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
    	try { 
    	String user=username.getText();

          FXMLLoader loader=new FXMLLoader(getClass().getResource("IU_Client.fxml"));
           Parent root1=(Parent) loader.load();
           IU_ClientController rc = loader.getController();
           
           rc.setUsername(user);
           Stage stage=new Stage();
           stage.setScene(new Scene(root1));
           stage.show();
      } catch (IOException ex) {
          System.err.println(ex);
      }
      
    }
    
}

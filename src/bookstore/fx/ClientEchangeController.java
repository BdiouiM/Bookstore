/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.connexion.bookstoreConnexion;
import bookstore.exception.EchangeException;
import bookstore.model.Client;
import bookstore.model.Echange;
import bookstore.service.ServiceClient;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;
import javafx.util.Callback;


public class ClientEchangeController implements Initializable {

    @FXML
    private TableView<Echange> TableC;
    @FXML
    private TableColumn<Echange, String> tableIdentifiantechange;
    @FXML
    private TableColumn<Echange, String> tableCIN1;
    @FXML
    private TableColumn<Echange, String> tableCIN2;
    @FXML
    private TableColumn<Echange, String> tableTitre1;
    @FXML
    private TableColumn<Echange, String> tableTitre2;
    @FXML
    private TableColumn<Echange, String> tableStatutEchange;
    @FXML
    private Label username;
    @FXML
    private Label CIN;
    public String user="";
      ObservableList<Echange> echanges = FXCollections.observableArrayList();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           InitColumn();
           echanges=loadData(echanges);
    
           //addValiderToTableView();
           addAnnulerToTableView();
          //ajouter items dans le tableau
         
           TableC.setItems(echanges);
           
        //String user =username.getText();
        String cin =CIN.getText();
        //String cin=getCIN1();
        System.out.println("user:"+username.getText()+"  cin:"+cin);
    }
    
public void setUsername(String username){
        this.username.setText(username);
            this.user=username;       
            System.out.println(user);
            String CIN="";
            CIN=getCIN1(user); 
            
            TableColumn<Echange, Void> tableAnnuler = new TableColumn("Pointer Sur un Echange");
        Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>> cellFactory = new Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>>() {
            @Override
            public TableCell<Echange, Void> call(final TableColumn<Echange, Void> param) {
                final TableCell<Echange, Void> cell;
                cell = new TableCell<Echange, Void>() {
                    
                    private final Button btn = new Button("Pointer");

                    {
                                               
                        btn.setOnAction((ActionEvent event) -> {
                             String cinTest=getCIN1(user);
                            String cu = getTableView().getItems().get(getIndex()).getIdentifiantechange();
                         
                              try {
                 FXMLLoader loader=new FXMLLoader(getClass().getResource("PointerEchange.fxml"));
             Parent root1=(Parent)loader.load();
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
             PointerEchangeController iupointer = loader.getController();
             iupointer.setLabel(cu, cinTest);
            } catch(Exception e) {
            System.err.println("erreur dans iu admin :"+ e.getMessage());
            e.printStackTrace();
            }
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
       tableAnnuler.setCellFactory(cellFactory);
       TableC.getColumns().add(tableAnnuler);
    }    

    public void CIN(String CIN){
        this.CIN.setText(CIN);
    }    
    public void InitColumn(){
           tableIdentifiantechange.setCellValueFactory(new PropertyValueFactory<>("Identifiantechange"));
           tableCIN1.setCellValueFactory(new PropertyValueFactory<>("CIN1"));
           tableCIN2.setCellValueFactory(new PropertyValueFactory<>("CIN2"));
           tableTitre1.setCellValueFactory(new PropertyValueFactory<>("Titre1"));
           tableTitre2.setCellValueFactory(new PropertyValueFactory<>("Titre2"));
           tableStatutEchange.setCellValueFactory(new PropertyValueFactory<>("StatutEchange"));
           
    }
   
    public ObservableList<Echange> loadData(ObservableList<Echange> echanges){
        try{
               bookstoreConnexion cnx=bookstoreConnexion.getIstance();
                              //String CIN1=getCIN1();
               String req ="select * from echange";
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   Echange e = new Echange();
                   e.setIdentifiantechange(rs.getString("Identifiantechange"));
                   e.setCIN1(rs.getString("CIN1"));
                   e.setCIN2(rs.getString("CIN2"));
                   e.setTitre1(rs.getString("Titre1"));
                   e.setTitre2(rs.getString("Titre2"));
                   e.setStatutEchange(rs.getString("StatutEchange"));
                   
                   echanges.add(e);
               }
           }
           catch(Exception ee){
               System.out.println("Probleeeeeeeeme");
           }
        return echanges;
    }
    public String getCIN1(String user){
        String CIN1="";
        
        System.out.println("user:"+user);
        System.out.println(user);
          try{
               bookstoreConnexion cnx=bookstoreConnexion.getIstance();
               Client c = new Client();
               String req ="SELECT * FROM client";
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   //c.setCIN(Integer.valueOf(rs.getString("CIN")));
                   if(rs.getString("UsernameClient").equals(user))
                   {CIN1=rs.getString("CIN");}
               }
           }
           catch(Exception ee){
               System.out.println("Probleme :"+ee.getMessage());
               ee.printStackTrace();
           }
           System.out.println(CIN1);
          //System.out.println("CIN="+CIN1);
        return CIN1;
    }
    
    
    /* public void addValiderToTableView(){
    
    TableColumn<Echange, Void> tableAnnuler = new TableColumn("Pointer Sur un Echange");
    Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>> cellFactory = new Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>>() {
    @Override
    public TableCell<Echange, Void> call(final TableColumn<Echange, Void> param) {
    final TableCell<Echange, Void> cell = new TableCell<Echange, Void>() {
    
    private final Button btn = new Button("Pointer");
    
    {
    
    
    btn.setOnAction((ActionEvent event) -> {
    String cu = getTableView().getItems().get(getIndex()).getIdentifiantechange();
    String d = getTableView().getItems().get(getIndex()).getCIN1();
    String t = getTableView().getItems().get(getIndex()).getCIN2();
    String y = getTableView().getItems().get(getIndex()).getTitre1();
    String z = getTableView().getItems().get(getIndex()).getTitre2();
    String x = getTableView().getItems().get(getIndex()).getStatutEchange();
    
    Echange e = new Echange();
    System.out.println("selected echange : " + cu);
    e.setIdentifiantechange(cu);
    e.setCIN1(d);
    e.setCIN2(t);
    e.setTitre1(y);
    e.setTitre2(z);
    e.setStatutEchange(x);
    pointerEchangec(e);
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
    tableAnnuler.setCellFactory(cellFactory);
    TableC.getColumns().add(tableAnnuler);
};*/


      public void pointerEchangec(Echange e){
          System.out.println("echange test");
          ServiceClient sa=new ServiceClient();
          System.out.println("id :"+e.getIdentifiantechange());
          boolean test =sa.pointerEchangec(e);
          
    } 
    
    
public void addAnnulerToTableView(){
        
       TableColumn<Echange, Void> tableAnnuler = new TableColumn(" Free Echange");
        Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>> cellFactory = new Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>>() {
            @Override
            public TableCell<Echange, Void> call(final TableColumn<Echange, Void> param) {
                final TableCell<Echange, Void> cell = new TableCell<Echange, Void>() {

                    private final Button btn = new Button("Send Request to Book owner");

                    {
                        
                        
                        btn.setOnAction((ActionEvent event) -> {
                            String cu = getTableView().getItems().get(getIndex()).getIdentifiantechange();
                             String d = getTableView().getItems().get(getIndex()).getCIN1();
                              String t = getTableView().getItems().get(getIndex()).getCIN2();
                              String y = getTableView().getItems().get(getIndex()).getTitre1();
                              String z = getTableView().getItems().get(getIndex()).getTitre2();
                              String x = getTableView().getItems().get(getIndex()).getStatutEchange();
                              
                            Echange e = new Echange();
                            System.out.println("selected echange : " + cu);
                            e.setIdentifiantechange(cu);
                            e.setCIN1(d);
                            e.setCIN2(t);
                            e.setTitre1(y);
                            e.setTitre2(z);
                            e.setStatutEchange(x);
                            freeEchange(e);
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
       tableAnnuler.setCellFactory(cellFactory);
       TableC.getColumns().add(tableAnnuler);
        };    
    
    public void freeEchange(Echange e){
        System.out.println("echange test");
        ServiceClient sa=new ServiceClient();
        System.out.println("id :"+e.getIdentifiantechange());
        sa.freeEchange(e);
   
    }
    
    
    
    
    
    
    
    
}

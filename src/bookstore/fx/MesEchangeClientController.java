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
import bookstore.service.ServiceAdmin;
import bookstore.service.ServiceClient;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MesEchangeClientController implements Initializable {
  
    @FXML
    private TableColumn<Echange, String> identifiant;
    @FXML
    private TableColumn<Echange, String> cin1;
    @FXML
    private TableColumn<Echange, String> titre1;
    @FXML
    private TableColumn<Echange, String> titre2;
    @FXML
    private TableColumn<Echange, String> statutechange;
    @FXML
    private TableColumn<Echange, String>  cin2;
   
    @FXML
    private Label username;
    @FXML
    private TableView<Echange> tableMe;
  ObservableList<Echange> echanges = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InitColumn();
        //echanges=loadData(echanges);
        
        String user =username.getText().toString();
        //String cin=getCIN1();
        //System.out.println("user:"+user+"  cin:"+cin);
    }
public void setUsername(String username){
        this.username.setText(username);
        try{
               bookstoreConnexion cnx=bookstoreConnexion.getIstance();
               String CIN1=getCIN1(this.username.getText());
               System.out.println(this.username.getText()+"test username :");
               String req ="select * from echange where CIN1="+CIN1;
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
                   //e.setAnnuler(new Button("Pointer"));
                  // e.setValider(new Button("Valider"));
                   this.echanges.add(e);
               }
           }
           catch(Exception ee){
               System.out.println("Probleeeeme"+ee.getMessage());
           }
        this.tableMe.setItems(echanges);
        addValiderToTableView();
        addAnnulerToTableView();
        
    }    

      public void InitColumn(){
           identifiant.setCellValueFactory(new PropertyValueFactory<>("Identifiantechange"));
           cin1.setCellValueFactory(new PropertyValueFactory<>("CIN1"));
           cin2.setCellValueFactory(new PropertyValueFactory<>("CIN2"));
           titre1.setCellValueFactory(new PropertyValueFactory<>("Titre1"));
           titre2.setCellValueFactory(new PropertyValueFactory<>("Titre2"));
           statutechange.setCellValueFactory(new PropertyValueFactory<>("StatutEchange"));
        
    }
      /*public ObservableList<Echange> loadData(ObservableList<Echange> echanges){
      try{
      bookstoreConnexion cnx=bookstoreConnexion.getIstance();
      String CIN1=getCIN1();
      System.out.println("test username :"+username.getText());
      String req ="select * from echange where CIN1="+CIN1;
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
      //e.setAnnuler(new Button("Pointer"));
      // e.setValider(new Button("Valider"));
      echanges.add(e);
      }
      }
      catch(Exception ee){
      System.out.println("Probleeeeme"+ee.getMessage());
      }
      return echanges;
      }*/
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
                   if(rs.getString("Username").equals(user))
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
public void addValiderToTableView(){
        
       TableColumn<Echange, Void> tableAnnuler = new TableColumn("Valider Lechange");
        Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>> cellFactory = new Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>>() {
            @Override
            public TableCell<Echange, Void> call(final TableColumn<Echange, Void> param) {
                final TableCell<Echange, Void> cell = new TableCell<Echange, Void>() {

                    private final Button btn = new Button("valider");

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
                            validerEchangec(e);
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
       tableMe.getColumns().add(tableAnnuler);
        };


      public void validerEchangec(Echange e){
      try {
            System.out.println("echange test");
            ServiceClient sa=new ServiceClient();
            System.out.println("id :"+e.getIdentifiantechange());
            
            sa.validerEchangec(e);
        } catch (EchangeException ex) {
            System.err.println("erreur dans la validation  "+ex);      
        }
          
    }
      
      public void addAnnulerToTableView(){
        
       TableColumn<Echange, Void> tableAnnuler = new TableColumn("Anuuler Lechange");
        Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>> cellFactory = new Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>>() {
            @Override
            public TableCell<Echange, Void> call(final TableColumn<Echange, Void> param) {
                final TableCell<Echange, Void> cell = new TableCell<Echange, Void>() {

                    private final Button btn = new Button("Anuller");

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
                            AnnulerEchangec(e);
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
       tableMe.getColumns().add(tableAnnuler);
        };


      public void AnnulerEchangec(Echange e){
          System.out.println("echange test");
          ServiceClient sa=new ServiceClient();
          System.out.println("id :"+e.getIdentifiantechange());
          sa.AnnulerEchangec(e);
          
    }
   
}

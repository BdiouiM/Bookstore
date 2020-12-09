/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoree;

import java.io.IOException;
import connexion.connexion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import entity.livraison.livraison;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class IU_ClivraisonController implements Initializable {
    connexion cnx;
    /**
     * Initializes the controller class.
     */
  
  private Scene scene;
  MyBrowser myBrowser;
   @FXML
    private TableView<livraison> tbl;
    @FXML
    private TableColumn<livraison, String> id;
    @FXML
    private TableColumn<livraison, String> nom;
    @FXML
    private TableColumn <livraison, String> adr;
    @FXML
    private TableColumn <livraison, String> id_client;
    @FXML
    private TableColumn <livraison, String> id_livreur;
    @FXML
   ObservableList<livraison> livraison = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          InitColumn();
          livraison=loadData(livraison);
          tbl.setItems(livraison);
          
   
    }    
   public void InitColumn(){
        id.setCellValueFactory(new PropertyValueFactory<>("id_livraison"));
           nom.setCellValueFactory(new PropertyValueFactory<>("coords"));
           adr.setCellValueFactory(new PropertyValueFactory<>("adrclient"));
            id_client.setCellValueFactory(new PropertyValueFactory<>("id_client"));
             id_livreur.setCellValueFactory(new PropertyValueFactory<>("id_livreur"));
           
           
    } 
      public ObservableList<livraison> loadData(ObservableList<livraison> livraison){
         try{
                cnx=connexion.getIstance();
               String req ="select * from livraison";
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   livraison l = new livraison();
                   l.setId(rs.getInt("id_livraison"));
                   l.setCoords(rs.getString("coords"));
                   l.setAdrClient(rs.getString("adrclient"));
                   l.setId_client(rs.getInt("id_client"));
                   l.setId_livreur(rs.getInt("id_livreur"));
          
                   livraison.add(l);
               }
           }
           catch(Exception e){
               System.err.println(e);
           }
        return livraison;
    }
    @FXML
    private void afficherMap(ActionEvent event) {
        try{
             Stage stage = new Stage();
        stage.setTitle("Map");
    
      myBrowser = new MyBrowser();
      scene = new Scene(myBrowser);
    
      stage.setScene(scene);
      stage.show();
        }catch(Exception e ){
        System.out.println(e.getMessage());
        }
        } 
    class MyBrowser extends Region{
    
    
      WebView webView = new WebView();
      WebEngine webEngine = webView.getEngine();
    
      public MyBrowser(){
        
          final URL urlGoogleMaps = getClass().getResource("map.html");
          webEngine.load(urlGoogleMaps.toExternalForm());

          getChildren().add(webView);
        
      }
    
  }
   
    
    
}

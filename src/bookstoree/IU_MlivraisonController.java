/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoree;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import connexion.connexion;
import entity.livraison.livraison;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.service;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class IU_MlivraisonController implements Initializable {

    /**
     * Initializes the controller class.
     */ @FXML
    private TextField adr ;
     @FXML
    private ComboBox combo ;
     @FXML
   ObservableList<livraison> livraison = FXCollections.observableArrayList();
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // llenadocombobox();
        livraison=loadData(livraison);
          combo.setItems(livraison);
    }  
      public ObservableList<livraison> loadData(ObservableList<livraison> livraison){
         try{
               connexion cnx=connexion.getIstance();
               String req ="select id_livraison ,adrclient from livraison";
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   livraison l = new livraison();
                   l.setId(rs.getInt("id_livraison"));
                  
                   l.setAdrClient(rs.getString("adrclient"));
                  
          
                   livraison.add(l);
               }
           }
           catch(Exception e){
               System.err.println(e);
           }
        return livraison;
    }
   @FXML
    public void Meslivraisons(ActionEvent event) {
    	 try {
            
             FXMLLoader loader=new FXMLLoader(getClass().getResource("IU_Clivraison.fxml"));
              Parent root1=(Parent) loader.load();
              //IU_ClivraisonController rc = loader.getController();
            
              Stage stage=new Stage();
              stage.setScene(new Scene(root1));
              stage.show();
         } catch (IOException ex) {
             System.err.println(ex);
         }
         
    }

    @FXML
    public void modifier(ActionEvent event) {
    	service sl =new service();
		livraison l = new livraison();
                l.setAdrClient(adr.getText());
                sl.modifier_livraison(l);
		Meslivraisons(event);
    }
    
}

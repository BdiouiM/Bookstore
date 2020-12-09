/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoree;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import entity.livraison.livraison;
import javafx.scene.control.TextField;

import service.service;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class IU_NlivraisonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     @FXML
    private TextField nom ;
     @FXML
    private TextField tel ;
     @FXML
    private TextField adr ;

  

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
    public void ajouter(ActionEvent event) {
    	service sl =new service();
		livraison l = new livraison();
                
                l.setId(5);
		l.setCoords(nom.getText());
                l.setAdrClient(adr.getText());
                l.setId_client(7);
                l.setId_livreur(7);
                sl.ajouter_livraison(l);
		Meslivraisons(event);
    }
    
}

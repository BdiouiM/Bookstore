/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModeController implements Initializable {

    
    private double x,y;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void IUadmin(ActionEvent event) {
         System.out.println("Admin");
        try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("TraiterReclamation.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             //stage.initStyle(StageStyle.UNDECORATED);
             
             stage.show();

      } catch(Exception e) {
            System.err.println("erreur dans le bouton admin");
      }
    }

    @FXML
    private void IUclient(ActionEvent event) {
        System.out.println("Client");
        try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("EnvoyerReclamation.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             //stage.setTitle("second window");
             stage.setScene(new Scene(root1));
             stage.show();

      } catch(Exception e) {
            System.err.println("erreur dans le bouton client");
      }
    }

    @FXML
    private void IUBibliothecaire(ActionEvent event) {
        System.out.println("Bilibothécaire");
           try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("VerifierStock.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             //stage.setTitle("second window");
             stage.setScene(new Scene(root1));
             stage.show();

      } catch(Exception e) {
            System.err.println("erreur dans le bouton stock");
      }
    }
    
}

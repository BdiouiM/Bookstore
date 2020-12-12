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
 * @author oumaima
 */
public class AccueilAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
          try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("Ajouteradminn.fxml"));
             
             Parent root1=(Parent) loader.load();
      
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();

            } catch(Exception e) {
            System.err.println(e.getMessage());
            }
    }

    @FXML
    private void modifier(ActionEvent event) {
         try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifierAdmin.fxml"));
             
             Parent root1=(Parent) loader.load();
      
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();

            } catch(Exception e) {
            System.err.println(e.getMessage());
            }
    }

    @FXML
    private void supprimer(ActionEvent event) {
         try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("SupprimerAdmin.fxml"));
             
             Parent root1=(Parent) loader.load();
      
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();

            } catch(Exception e) {
            System.err.println(e.getMessage());
            }
    }

    @FXML
    private void consulter(ActionEvent event) {
         try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("Consulteradmin.fxml"));
             
             Parent root1=(Parent) loader.load();
      
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();

            } catch(Exception e) {
            System.err.println(e.getMessage());
            }
    }

    @FXML
    private void desactiver(ActionEvent event) {
         try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("DesactiverClient.fxml"));
             
             Parent root1=(Parent) loader.load();
      
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();

            } catch(Exception e) {
            System.err.println(e.getMessage());
            }
    }
    
}

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
public class AccueilClientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
         try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifierClient.fxml"));
             
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

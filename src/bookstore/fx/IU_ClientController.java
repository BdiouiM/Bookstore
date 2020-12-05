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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class IU_ClientController implements Initializable {
    @FXML
    private Label username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // setUsername(null);
    }    
    public void setUsername(String username)
    {
        this.username.setText(username);
    }
    @FXML
    private void IU_Reclamation(ActionEvent event) {
        
          try {
              String user=username.getText();
             FXMLLoader loader=new FXMLLoader(getClass().getResource("EnvoyerReclamation.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
             EnvoyerReclamationController iueR = loader.getController();
             iueR.setUsername(user);
            } catch(Exception e) {
            System.err.println("erreur dans reclamation client");
            }
    }

    @FXML
    private void IU_Livre(ActionEvent event) {
    }

    @FXML
    private void IU_Compte(ActionEvent event) {
    }

    @FXML
    private void IU_Echange(ActionEvent event) {
    }
    
    
}

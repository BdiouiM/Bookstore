/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import service.ServiceClient;
import model.Personnel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Client;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author oumaima
 */
public class ModifierClientController implements Initializable {

    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf5;
    @FXML
    private TextField tf6;
    @FXML
    private TextField tf7;
    @FXML
    private TextField tf8;
    @FXML
    private TextField tf9;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
          ServiceClient service= new ServiceClient(); 
     Client client= new Client();
   
       client.setCIN(Integer.parseInt(tf1.getText()));
     client.setNom(tf2.getText());
    client.setPrenom(tf3.getText());
       client.setAdresse(tf5.getText());
     client.setEmail(tf6.getText());
       client.setUsername(tf7.getText());
         client.setPassword(tf8.getText());
 client.setType(tf9.getText());
      service.modifierClient(client ,client.getCIN());
       Notifications notificationBuilder;
               notificationBuilder = Notifications.create()
                .title("Welcome")
                .text("La Modification a effectuée avec succès ")
                .graphic(null)
                 .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                System.out.println("");
                            }
                        });
        notificationBuilder.showConfirm();
    }
    
}

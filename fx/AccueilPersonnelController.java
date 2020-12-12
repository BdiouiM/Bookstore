/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.service.ServicePersonnel;
import bookstore.model.Personnel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author oumaima
 */
public class AccueilPersonnelController implements Initializable {

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
    @FXML
    private TextField tf10;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifier(ActionEvent event) {
          ServicePersonnel service= new ServicePersonnel(); 
     Personnel personnel= new Personnel();
     personnel.setPoste(tf1.getText());
       personnel.setCIN(Integer.parseInt(tf2.getText()));
     personnel.setNom(tf3.getText());
    personnel.setPrenom(tf5.getText());
       personnel.setAdresse(tf6.getText());
     personnel.setEmail(tf7.getText());
       personnel.setUsername(tf8.getText());
         personnel.setPassword(tf9.getText());
 personnel.setType(tf10.getText());
      service.modifierPersonnel(personnel, personnel.getCIN());
         Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("Welcome")
                .text("Succès ")
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

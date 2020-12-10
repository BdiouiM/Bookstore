package bookstore.fx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import bookstore.model.Personnel;
import org.controlsfx.control.Notifications;
import bookstore.service.ServicePersonnel;

/**
 * FXML Controller class
 *
 * @author oumaima
 */
public class PersonnelController implements Initializable {

    @FXML
    private TextField tposte;
    @FXML
    private TextField tcin;
    @FXML
    private TextField tnom;
    @FXML
    private TextField tprenom;
    @FXML
    private TextField tadresse;
    @FXML
    private TextField temail;
    @FXML
    private TextField tusername;
    @FXML
    private TextField tpassword;
    @FXML
    private TextField tusername1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierPer(ActionEvent event) {
        ServicePersonnel service= new ServicePersonnel(); 
     Personnel personnel= new Personnel();
   
       personnel.setCIN(Integer.parseInt(tposte.getText()));
     personnel.setNom(tnom.getText());
    personnel.setPrenom(tprenom.getText());
       personnel.setAdresse(tadresse.getText());
     personnel.setEmail(temail.getText());
       personnel.setUsername(tusername.getText());
         personnel.setPassword(tpassword.getText());
 personnel.setType(tusername1.getText());
      service.modifierPersonnel(personnel,personnel.getUsername());
       Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("Welcome")
                .text("Modification effectuée avec succès ")
                .graphic(null)
                 .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                System.out.println("");
                            }
                        });
    }
    
}

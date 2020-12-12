/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.fx.VisiteurController;
import bookstore.service.ServiceVisiteur;
import bookstore.model.Visiteur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author oumaima
 */
public class ValidationcodeController implements Initializable {

    @FXML
    private TextField tcode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void code(ActionEvent event) {
          ServiceVisiteur service= new ServiceVisiteur(); 
               Visiteur client= new Visiteur();
        
        VisiteurController ad=new VisiteurController();
        if (tcode.getText().equals(ad.randomNum)) {
             
            Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("Welcome")
                .text("Ajout effectué avec succès")
                .graphic(null)
                 .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                System.out.println("oui");
                            }
                        });
        notificationBuilder.showConfirm();
        }
        else{
                   
    Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("Echec")
                .text("Le code est incorrect")
                .graphic(null)
                 .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                System.out.println("oui");
                            }
                        });
        notificationBuilder.showWarning();
    }
    
}
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.exception.EchangeException;
import bookstore.model.Echange;
import bookstore.service.ServiceClient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mega pc
 */
public class EnvoyerEchangeController implements Initializable {

    @FXML
    private TextField Identifiantechange;
    @FXML
    private TextField CIN1;
    @FXML
    private TextField Titre1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyerEchange(ActionEvent event) {
        try {
            ServiceClient sc =new ServiceClient();
            Echange e = new Echange();
            
            
            e.setIdentifiantechange(Identifiantechange.getText());
            e.setCIN1(CIN1.getText());
            e.setCIN2("Null");
            e.setTitre1(Titre1.getText());
            e.setTitre2("Null");
            e.setStatutEchange("En cours..");
            
            System.out.println("cin1 :"+CIN1.getText()+" Titre1 : "+Titre1.getText());
            sc.envoyerEchange(e);
        } catch (EchangeException ex) {
            System.err.println("exception dans l'envoie");
        }
        
        
        
    }
    
}

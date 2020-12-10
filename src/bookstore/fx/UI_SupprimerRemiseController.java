/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.service.ServiceUser;
import bookstore.model.Remise;
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
 * @author omen
 */
public class UI_SupprimerRemiseController implements Initializable {

    @FXML
    private TextField tfidremise;
    @FXML
    private Label username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    public void setUser(String u){
        this.username.setText(u);
    }

    @FXML
    private void supprimerRemise(ActionEvent event) {
        ServiceUser s = new ServiceUser();
        Remise r = new Remise();
        String id =tfidremise.getText();
        int idint=Integer.parseInt(id);
        
        r.setId(idint);
        s.supprimerRemise(r);
        
    }

   
    
}

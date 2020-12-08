/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstorefx;

import bookstore.ServiceUser;
import bookstore1.entite.Remise;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author omen
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField tfidlivre;
    @FXML
    private TextField tfpourcentage;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterRemise(ActionEvent event) {
        ServiceUser s = new ServiceUser();
        Remise r = new Remise();
        String id =tfidlivre.getText();
        String pourcentag =tfpourcentage.getText();
        float floatval = Float.valueOf(pourcentag).floatValue();
        int idint=Integer.parseInt(id);
        r.setIdLivre(idint);
        r.setPourcentage(floatval);
        s.ajouterRemise(r);
    }
    
}

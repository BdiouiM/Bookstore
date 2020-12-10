/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.connexion.bookstoreConnexion;
import bookstore.exception.EchangeException;
import bookstore.model.Echange;
import bookstore.service.ServiceClient;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mega pc
 */
public class PointerEchangeController implements Initializable {
    bookstoreConnexion cnx;

    @FXML
    private Label Identifiantechange;
    private TextField CIN2;
    @FXML
    private TextField Titre2;
    @FXML
    private Button Envoyer;
    @FXML
    private Label idCIN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void setLabel(String id,String cin){
        this.idCIN.setText(cin);
        this.Identifiantechange.setText(id);
    }
    @FXML
    private void modifierEchange(ActionEvent event) {
        ServiceClient sc =new ServiceClient();
        Echange e = new Echange();
        e.setIdentifiantechange(Identifiantechange.getText());
        e.setCIN2(idCIN.getText());
        e.setTitre2(Titre2.getText());
        
        
        
        sc.modifierEchange(e);
        
        System.out.println(idCIN.getText());
        System.out.println(Identifiantechange.getText());
        
    }    
    /*public void modifierEchangee(Echange e,String CIN2,String Titre2) {
        
              
        try {
             String req5= "UPDATE echange SET CIN2=?, Titre2=? where Identifiantechange='"+e.getIdentifiantechange()+"'";
             PreparedStatement s5=cnx.getConnection().prepareCall(req5);
             s5.setString(1,CIN2);
             s5.setString(2,Titre2);
             System.out.println("Modifié");
        } catch (SQLException ex) {
            System.err.println("errrr");
            System.out.println("Modification erroné");
        }
        
}

    @FXML
    private void modifierEchangee(ActionEvent event,Echange e,String CIN2,String Titre2) {
        try {
             String req5= "UPDATE echange SET CIN2=?, Titre2=? where Identifiantechange='"+e.getIdentifiantechange()+"'";
             PreparedStatement s5=cnx.getConnection().prepareCall(req5);
             s5.setString(1,CIN2);
             s5.setString(2,Titre2);
             System.out.println("Modifié");
        } catch (SQLException ex) {
            System.err.println("errrr");
            System.out.println("Modification erroné");
        }
    }*/

    
}

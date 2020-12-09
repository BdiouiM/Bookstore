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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class IU_BibliothecaireController implements Initializable {
    @FXML
    private Label username;
    @FXML
    private HBox parentChildren;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setUsername(String username)
    {
        this.username.setText(username);
    }
    @FXML
    private void IU_Stock(ActionEvent event) {
         try {
              String user=username.getText();
             FXMLLoader loader=new FXMLLoader(getClass().getResource("VerifierStock.fxml"));
             Parent root1=(Parent) loader.load();
             loadPage(root1);
             VerifierStockController vs = loader.getController();
             vs.setUser(user);
            } catch(Exception e) {
            System.err.println("erreur dans stock biblio" + e);
            }
    }
 public void loadPage(Parent root){
       parentChildren.getChildren().removeAll();
       parentChildren.getChildren().setAll(root);
    }
    
}

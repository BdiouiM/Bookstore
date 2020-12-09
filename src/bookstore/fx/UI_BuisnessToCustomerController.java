/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import java.io.IOException;
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
 * @author omen
 */
public class UI_BuisnessToCustomerController implements Initializable {
    
    @FXML
    private Label username;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setUser(String u){
        this.username.setText(u);
    }

    @FXML
    private void UI_Ajouter_Remise(ActionEvent event) throws IOException {
        String u=username.getText();
        
        
        FXMLLoader loader=new FXMLLoader(getClass().getResource("UI_Ajouter_Remise.fxml"));
            Parent root1=(Parent) loader.load();
             UI_Ajouter_RemiseController ar = loader.getController();
            
             ar.setUser(u);
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
    }

    @FXML
    private void UI_SupprimerReise(ActionEvent event) throws IOException {
        String u=username.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("UI_SupprimerRemise.fxml"));
        Parent root1=(Parent) loader.load();
             UI_SupprimerRemiseController sr = loader.getController();
             sr.setUser(u);
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
        
    }

    @FXML
    private void UI_ConculterRemise(ActionEvent event) throws IOException {
        String u = username.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("UI_ConsulterRemise.fxml"));
             Parent root1=(Parent) loader.load();
             UI_ConsulterRemiseController cr = loader.getController();
             cr.setUser(u);
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
        
    }
    
}

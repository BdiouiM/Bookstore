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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mega pc
 */
public class ChoixClientController implements Initializable {

    @FXML
    private Button IUclient1;
    @FXML
    private Button IUclient2;
    @FXML
    private Button IUclient3;
    @FXML
    private Label username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setUsername(String username){
        this.username.setText(username);
    }
    
    @FXML
    private void IUclient1(ActionEvent event) {
        System.out.println("Client");
        try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("ClientEchange.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
            ClientEchangeController me =loader.getController();
            me.setUsername(username.getText());
             //loader.setController(new ClientEchangeController(username.getText()));
             //stage.setTitle("second window");
             stage.setScene(new Scene(root1));
             stage.show();

      } catch(Exception e) {
            System.err.println("erreur dans le bouton1" + e.getMessage());
      }
    }
    @FXML
    private void IUclient2(ActionEvent event) {
        System.out.println("Client");
        try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("EnvoyerEchange.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             //stage.setTitle("second window");
             stage.setScene(new Scene(root1));
             stage.show();

      } catch(Exception e) {
            System.err.println("erreur dans le bouton2");
      }
    }
    
    @FXML
    private void IUclient3(ActionEvent event) {
        System.out.println("Client");
        try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("MesEchangeClient.fxml"));
             Parent root1=(Parent) loader.load();
             Stage stage=new Stage();
             //stage.setTitle("second window");
             MesEchangeClientController me =loader.getController();
             me.setUsername(username.getText());
             stage.setScene(new Scene(root1));
             stage.show();

      } catch(Exception e) {
            System.err.println("erreur dans le bouton3");
      }
    }
    
}

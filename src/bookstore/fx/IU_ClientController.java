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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class IU_ClientController implements Initializable {
    @FXML
    private Label username;
    @FXML
    private HBox parentChildren;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void setUsername(String username)
    {
        this.username.setText(username);
    }
    @FXML
    private void IU_Reclamation(ActionEvent event) {
        
          try {
              String user=username.getText();
             FXMLLoader loader=new FXMLLoader(getClass().getResource("EnvoyerReclamation.fxml"));
             Parent root1=(Parent) loader.load();
             loadPage(root1);
             EnvoyerReclamationController iueR = loader.getController();
             iueR.setUsername(user);
            } catch(Exception e) {
            System.err.println("erreur dans reclamation client");
            }
    }
   public void loadPage(Parent root){
       parentChildren.getChildren().removeAll();
       parentChildren.getChildren().setAll(root);
    }
   
    @FXML
    private void IU_Livre(ActionEvent event) throws IOException {
         String user=username.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("MesLivresClient.fxml"));
        Parent root=(Parent) loader.load();
        MesLivresClientController cc = loader.getController();
        cc.setUsername(user);
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void IU_Compte(ActionEvent event) throws IOException {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("Welcome.fxml"));
        Parent root=(Parent) loader.load();
        
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void IU_Echange(ActionEvent event) throws IOException {
        String user=username.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ChoixClient.fxml"));
        Parent root=(Parent) loader.load();
        ChoixClientController cc = loader.getController();
        cc.setUsername(user);
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void IU_Panier(ActionEvent event) throws IOException {
        String user=username.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("GererPanier.fxml"));
        Parent root=(Parent) loader.load();
        GererPanierController cc = loader.getController();
        cc.setUsername(user);
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    
}

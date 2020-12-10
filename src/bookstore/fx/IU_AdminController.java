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
public class IU_AdminController implements Initializable {
    @FXML
    private Label username;
    @FXML
    private HBox parentChildren;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setUsername(String username)
    {
        this.username.setText(username);
    }
    @FXML
    private void IU_Reclamation(ActionEvent event) {
         try {
              String user=username.getText();
             FXMLLoader loader=new FXMLLoader(getClass().getResource("TraiterReclamation.fxml"));
             Parent root1=(Parent) loader.load();
             loadPage(root1);
             TraiterReclamationController iuTR = loader.getController();
             iuTR.setUsername(user);
            } catch(Exception e) {
            System.err.println("erreur dans reclamation admin");
            }
    }

    @FXML
    private void IU_Livre(ActionEvent event) throws IOException {
          String user=username.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("MesLivresAdmin.fxml"));
        Parent root=(Parent) loader.load();
        MesLivresAdminController cc = loader.getController();
        cc.setUsername(user);
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void IU_Compte(ActionEvent event) {
    }

    @FXML
    private void IU_Echange(ActionEvent event) throws IOException {
        String user=username.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("EchangeAdmin.fxml"));
        Parent root=(Parent) loader.load();
        //EchangeAdminController ea = loader.getController();
        
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void loadPage(Parent root){
       parentChildren.getChildren().removeAll();
       parentChildren.getChildren().setAll(root);
    }
}

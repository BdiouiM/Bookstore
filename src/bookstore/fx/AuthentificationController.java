/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.service.ServiceAuthentification;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AuthentificationController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Login(ActionEvent event) {
        String user=username.getText();
        String pass=password.getText();
        ServiceAuthentification sa = new ServiceAuthentification();
        if(sa.adminAuthentification(user, pass))
        {
              try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("EchangeAdmin.fxml"));
             Parent root1=(Parent)loader.load();
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
            // EchangeAdminController iuadmin = loader.getController();
             //iuadmin.setUsername(user);
            } catch(Exception e) {
            System.err.println("erreur dans iu admin :"+ e.getMessage());
            e.printStackTrace();
            }
        }
     
        else if (sa.clientAuthentification(user, pass))
        {
            
             try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("ChoixClient.fxml"));
             
             Parent root1=(Parent) loader.load();
             ChoixClientController iuclient = loader.getController();
             iuclient.setUsername(user);
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();

            } catch(Exception e) {
            System.err.println("erreur dans iu client" + e);
            }
        }
        else
        {System.out.println("n'existe pas");
            alert(event);
        }
    }
    
    public void alert(ActionEvent event)
    {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Authentification");
         a.setHeaderText("Utilisateur Invalid");
          a.setContentText("Vérifier votre compte");
          a.showAndWait();
    }
}

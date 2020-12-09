/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;


import static bookstore.fx.sendemail.sendFromGMail;
import service.ServiceVisiteur;
import model.Visiteur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author oumaima
 */
public class VisiteurController implements Initializable {

    @FXML
    public TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf5;
    @FXML
    public TextField tf6;
    @FXML
    public TextField tf7;
    @FXML
    private TextField tf8;
    @FXML
    private TextField tf9;
    
   public static String USER_NAME = "bookstorebookstore57";  // GMail user name (just the part before "@gmail.com")
    public static String PASSWORD = "bookstore8*"; // GMail password
     public String RECIPIENT;
        int randomNum = (int)(Math.random() * 90000000) + 100000;
   
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  @FXML

   
    private void Inscri(ActionEvent event) {
        
        //  ServiceVisiteur service= new ServiceVisiteur(); 
     Visiteur client= new Visiteur();
      ServiceVisiteur service= new ServiceVisiteur(); 
              
             
       client.setCIN(Integer.parseInt(tf1.getText()));
     client.setNom(tf2.getText());
    client.setPrenom(tf3.getText());
      client.setEmail(tf5.getText());
       client.setAdresse(tf6.getText());  
       client.setUsername(tf7.getText());
         client.setPassword(tf8.getText());
 client.setType(tf9.getText());
service.ajouterCom(client);
      String from = USER_NAME;
       String pass = PASSWORD;
         
        String subject = "Welcome, Complete registration!";
  
   String body ="Please enter this confirmation code to confirm your mail"
           +randomNum+ " Username : "+ tf7.getText()+" Password : "+tf8.getText();

        sendFromGMail(from, pass, tf5.getText(), subject, body);
        
        
   
     
    }
    }
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;


import static bookstore.fx.sendemail.PASSWORD;
import static bookstore.fx.sendemail.USER_NAME;
import static bookstore.fx.sendemail.sendFromGMail;
import bookstore.service.ServicePersonnel;
import bookstore.model.Personnel;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
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
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author oumaima
 */
public class AjouteradminnController implements Initializable {

    @FXML
    public TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf5;
    @FXML
    private TextField tf6;
    @FXML
    public TextField tf7;
    @FXML
    private TextField tf8;
    @FXML
    private TextField tf9;
    @FXML
    private TextField tf10;
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

   
    private void ajouter(ActionEvent event) {
        
          ServicePersonnel service= new ServicePersonnel(); 
     Personnel personnel= new Personnel();
     personnel.setPoste(tf1.getText());
       personnel.setCIN(Integer.parseInt(tf2.getText()));
     personnel.setNom(tf3.getText());
    personnel.setPrenom(tf5.getText());
       personnel.setAdresse(tf6.getText());
     personnel.setEmail(tf7.getText());
       personnel.setUsername(tf8.getText());
         personnel.setPassword(tf9.getText());
 personnel.setType(tf10.getText());
 service.ajouterPersonnel(personnel);
      String   from = USER_NAME;
       String pass = PASSWORD;
         
        String subject = "Welcome to bookstore ";
  
   String body = "Welcome to bookstore," 
           +" Username :  "+tf8.getText()
           +" Password :  "+tf9.getText();

        sendFromGMail(from, pass, tf7.getText(), subject, body);
      
    
   
      
    }
    }
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.model.Reclamation;
import bookstore.exception.ReclamationExisteException;
import bookstore.service.ServiceClient;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EnvoyerReclamationController {

     
    ObservableList <String> typeReclamation=FXCollections.observableArrayList("Type1","Type2","Type3");
    
    // Reclamation informations
    @FXML
    private TextField labelDescription;
    @FXML
    private DatePicker labelDateReclamation;
    @FXML
    private ChoiceBox <String> labelType;
    @FXML
    private TextField labelUsername;
    @FXML
    private Label username;
    @FXML
    private Button mesRec;
    @FXML
    private AnchorPane anchorPane;
    public void initialize() {
        labelDateReclamation.setValue(LocalDate.now());
        labelType.setValue("Type1");
        labelType.setItems(typeReclamation);
    }    

    @FXML
    private void EnvoyerReclamation(ActionEvent event) {
       if("".equals(labelDescription.getText())) 
          alertDescription(event);
      else    
      {  try {
            ServiceClient sc =new ServiceClient();
            Reclamation r = new Reclamation();
            
            String  dateR = labelDateReclamation.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            r.setClientUsername(labelUsername.getText());
            r.setType(labelType.getValue());
            r.setDateReclamation(dateR);
            r.setDescription(labelDescription.getText());
            r.setStatutReclamation("En cours..");
            sc.envoyerReclamation(r);
        } catch (ReclamationExisteException ex) {
            System.err.println("exception dans l'envoie");
        }
      }
        
    } 
    public void setUsername(String username)
    {
        this.labelUsername.setText(username);
        this.username.setText(username);
    }
    @FXML
    private void MesReclamation(ActionEvent event) {
        try {
             /*FXMLLoader loader=new FXMLLoader(getClass().getResource("MesReclamationClient.fxml"));
             
             Parent root=(Parent) loader.load();  
             Scene scene = mesRec.getScene();
             root.translateYProperty().set(scene.getHeight());
             
             anchorPane.getChildren().add(root);
             
             Timeline t = new Timeline();
            KeyValue kv= new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            t.getKeyFrames().add(kf);
            t.play();*/
            FXMLLoader loader=new FXMLLoader(getClass().getResource("MesReclamationClient.fxml"));
             
             Parent root1=(Parent) loader.load();
             MesReclamationClientController rc = loader.getController();
             rc.setUsername(username.getText());
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
    }
     
      public void alertDescription(ActionEvent event)
    {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Reclamation");
         a.setHeaderText("Reclamation Invalid");
          a.setContentText("Veuillez remplir la description");
          a.showAndWait();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MesReclamationClientController implements Initializable {
    @FXML
    private Button back;
    @FXML
    private StackPane parent;
    @FXML
    private AnchorPane anchor;
    @FXML
    private TableColumn<Reclamation, String> Identifiant;
    @FXML
    private TableColumn<Reclamation, String> Date;
    @FXML
    private TableColumn<Reclamation, String>Type;
    @FXML
    private TableColumn<Reclamation, String>Statut;
    @FXML
    private TableColumn<Reclamation, String> Description;
   ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();
    @FXML
    private Label username;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InitColumn();
    }    
   public void InitColumn(){
           Date.setCellValueFactory(new PropertyValueFactory<>("DateReclamation"));
           Type.setCellValueFactory(new PropertyValueFactory<>("Type"));
           Statut.setCellValueFactory(new PropertyValueFactory<>("StatutReclamation"));
           Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
           Identifiant.setCellValueFactory(new PropertyValueFactory<>("Identifiant"));
           
    }
   public void setUsername(String user){
      this.username.setText(user);
   }
    public ObservableList<Reclamation> loadData(ObservableList<Reclamation> reclamations){
        try{
               String userr = username.getText() ;
               bookstoreConnexion cnx=bookstoreConnexion.getIstance();
               String req ="select * from reclamation where Identifiant="+userr;
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   Reclamation r = new Reclamation();
                   r.setClientUsername(rs.getString("UsernameClient"));
                   r.setType(rs.getString("Type"));
                   r.setDateReclamation(rs.getString("DateReclamation"));
                   r.setStatutReclamation(rs.getString("StatutReclamation"));
                   r.setDescription(rs.getString("Description"));
                   r.setIdentifiant(rs.getInt("Identifiant"));
                   
                  /* Button annulerB= new Button("annuler"); 
                   r.setAnnuler(annulerB);
                   Button validerB= new Button("valider");
                   r.setValider(validerB);*/
                
                   reclamations.add(r);
               }
           }
           catch(Exception e){
               
           }
        return reclamations;
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
       FXMLLoader loader=new FXMLLoader(getClass().getResource("EnvoyerReclamation.fxml"));
             
             Parent root=(Parent) loader.load();  
             Scene scene = back.getScene();
             EnvoyerReclamationController er = loader.getController();
             er.setUsername(username.getText());
             root.translateYProperty().set(scene.getHeight());
             
             parent.getChildren().add(root);
             
             Timeline t = new Timeline();
            KeyValue kv= new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            t.getKeyFrames().add(kf);
            t.play();
    }
    
}

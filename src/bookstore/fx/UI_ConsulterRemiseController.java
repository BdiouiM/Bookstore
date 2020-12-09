/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.model.Remise;
import bookstore.connexion.Myconnexion;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author omen
 */
public class UI_ConsulterRemiseController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private TableView<Remise> tableremise;
    @FXML
    private TableColumn<Remise,String> id;
    @FXML
    private TableColumn<Remise,String> idLivre;
    @FXML
    private TableColumn<Remise,String>pourcentage;
    @FXML
    private TableColumn<Remise,String> ancienPrix;
    @FXML
    private TableColumn<Remise,String> nouveauPrix;
    
    
    ObservableList<Remise> remises = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InitColumn();
        remises=loadData(remises);
        tableremise.setItems(remises);
        
        
        
    } 
    public void setUser(String u){
        this.username.setText(u);
    }
     public void InitColumn(){
           id.setCellValueFactory(new PropertyValueFactory<>("id"));
           idLivre.setCellValueFactory(new PropertyValueFactory<>("idLivre"));
           pourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
           ancienPrix.setCellValueFactory(new PropertyValueFactory<>("ancienPrix"));
           nouveauPrix.setCellValueFactory(new PropertyValueFactory<>("nouveauPrix"));
           
           
    }
     public ObservableList<Remise> loadData(ObservableList<Remise> remises){
        try{
               Myconnexion cnx=Myconnexion.getInstance();
               String req ="select * from remise";
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   Remise r = new Remise();
                   r.setId(rs.getInt("id"));
                   r.setIdLivre(rs.getInt("idLivre"));
                   r.setPourcentage(rs.getFloat("pourcentage"));
                   r.setAncienPrix(rs.getFloat("ancienPrix"));
                   r.setNouveauPrix(rs.getFloat("nouveauPrix"));
                   
                   
                  /* Button annulerB= new Button("annuler"); 
                   r.setAnnuler(annulerB);
                   Button validerB= new Button("valider");
                   r.setValider(validerB);*/
                
                   remises.add(r);
               }
           }
           catch(Exception e){
               
           }
        return remises;
    }
     
    
}

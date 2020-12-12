/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.connexion.Myconnection;
import bookstore.model.Personnel;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.C;

/**
 * FXML Controller class
 *
 * @author oumaima
 */
public class ConsulteradminController implements Initializable {
 @FXML
    private TableView<Personnel> tab;
   
 
    @FXML
    private TableColumn<Personnel, String> tvPoste;
    @FXML
    private TableColumn<Personnel, String> tvCin;
    @FXML
    private TableColumn<Personnel, String> tvNom;
    @FXML
    private TableColumn<Personnel, String> tvPrenom;
    @FXML
    private TableColumn<Personnel, String> tvAdresse;
    @FXML
    private TableColumn<Personnel, String> tvEmail;
    @FXML
    private TableColumn<Personnel, String> tvUsername;
    @FXML
    private TableColumn<Personnel, String> tvPassword;
    @FXML
    private TableColumn<Personnel, String> tvType;   
     ObservableList<Personnel> personnels = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
     try {
          InitColumn();
         personnels=loadData(personnels);
          tab.setItems(personnels);
     } catch (Exception ex) {
         System.out.println(ex.getMessage()); 
     }
   
    }    
   
      public void InitColumn(){
           
             
           tvPoste.setCellValueFactory(new PropertyValueFactory<>("Poste"));
           tvCin.setCellValueFactory(new PropertyValueFactory<>("CIN"));
           tvNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
           tvPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
           tvAdresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
           tvEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
              tvUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
               tvPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));
                 tvType.setCellValueFactory(new PropertyValueFactory<>("Type"));
          
           }

   
  
  private ObservableList<Personnel> loadData(ObservableList<Personnel> personne) throws SQLException {
       
               Myconnection cnx=Myconnection.getInstance();
               String req ="select * from personnel";
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   Personnel p = new Personnel();
                   p.setPoste(rs.getString("poste"));
                   p.setCIN(rs.getInt("cin"));
                   p.setNom(rs.getString("nom"));
                   p.setPrenom(rs.getString("prenom"));
                   p.setAdresse(rs.getString("adresse"));
                  p.setEmail(rs.getString("email"));
                   p.setUsername(rs.getString("username"));
                    p.setUsername(rs.getString("password"));
                    p.setType(rs.getString("type"));
                    personnels.add(p);
               }
         
        return  personne;
    }
   
}

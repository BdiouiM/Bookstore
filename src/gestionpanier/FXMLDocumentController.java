/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpanier;
import Entities.Panier;
import Services.ServicePanier;
import Techniques.Connexion;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 *
 * @author Mariem Messaoudi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Text total_prix;
    @FXML
    private Text nbr_total;
    @FXML
    private TableColumn<Panier, String> livre;
    @FXML
    private TableColumn<Panier, Integer> quantite;
    @FXML
    private TableColumn<Panier, Float> prix_unit;
    @FXML
    private TableColumn<Panier, Float> prix_total;
    
    ObservableList<Panier> list_panier = FXCollections.observableArrayList();
    @FXML
    private Label total;
    @FXML
    private TableView<Panier> tab_panier;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//       InitColumn();
        list_panier = loadData(list_panier);
    }
    
// public void InitColumn(){
//           livre.setCellValueFactory(new PropertyValueFactory<>("titre"));
//           quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
//           prix_unit.setCellValueFactory(new PropertyValueFactory<>("prix"));
//           
//    }
 
 public ObservableList<Panier> loadData(ObservableList<Panier> panier){
       
        try {
            Connexion cnx= Connexion.getInstance();
            String req ="select * from panier";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req);
            while(rs.next()){
                Panier p = new Panier();
                p.setTitre(rs.getString("titre"));
                p.setQuantite(rs.getInt("quantite"));
                p.setPrix(rs.getFloat("prix"));
                
                
                /* Button annulerB= new Button("annuler");
                r.setAnnuler(annulerB);
                Button validerB= new Button("valider");
                r.setValider(validerB);*/
                
                panier.add(p);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return panier;
    }

public void Valider(Panier p){
    ServicePanier sp=new ServicePanier();
    sp.ValiderCommande();
}                
        
            
        
    }
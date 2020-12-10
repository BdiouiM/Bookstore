/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;
import bookstore.model.Client;
import bookstore.model.Livre;
import bookstore.model.Panier;
import bookstore.service.ServicePanier;
import bookstore.connexion.bookstoreConnexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 *
 * @author Mariem Messaoudi
 */
public class GererPanierController implements Initializable {

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
    @FXML
    private TableColumn<Panier, Button> supr;
    
    ObservableList<Panier> list_panier = FXCollections.observableArrayList();
   
    @FXML
    private Label total;
    @FXML
    private TableView<Panier> tab_panier;
    @FXML
    private Button vider_btn;
    @FXML
    private Button valider_btn;
    @FXML
    private Button update_btn;
    @FXML
    private Label username;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
              
       UpdatePanier();
        list_panier = loadData(list_panier);
        tab_panier.setItems(list_panier);
        nbr_total.setText(String.valueOf(UpdateNb()));
        total_prix.setText(String.valueOf(Updateprix()));
    }
    
 public void UpdatePanier(){
    
           livre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            prix_unit.setCellValueFactory(new PropertyValueFactory<>("prix"));
            prix_total.setCellValueFactory(new PropertyValueFactory<>("prix_total"));
            supr.setCellValueFactory(new PropertyValueFactory<> ("supr_btn"));
            
              }
 
 
 public ObservableList<Panier> loadData(ObservableList<Panier> list_panier){
       
        try {
            bookstoreConnexion cnx= bookstoreConnexion.getIstance();
            String req ="select * from panier";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req);
            while(rs.next()){
                Panier p = new Panier();
                p.setTitre(rs.getString("titre"));
                p.setQuantite(rs.getInt("quantite"));
                p.setPrix(rs.getFloat("prix"));
                p.setPrix_total(rs.getFloat("prix_total"));
                
                
                Button btn = new Button("Supprimer");
                p.setSupr_btn(btn);
                btn.setOnAction((ActionEvent)->{
                tab_panier.getItems().removeAll(tab_panier.getSelectionModel().getSelectedItem());
                ServicePanier sp = new ServicePanier();
                            Livre l = new Livre(); 
                            Client c = new Client();
                            sp.supprimerLivrePanier(l, c);
            });
                
                
                             
                                
                list_panier.add(p);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(GererPanierController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_panier;
    }              

    @FXML
    private void Vider(ActionEvent event) {
        ServicePanier sp= new ServicePanier();
        sp.ViderPanier();
    }

    @FXML
    private void Valider(ActionEvent event) {
        ServicePanier sp= new ServicePanier();
        sp.ValiderCommande();
    }
        
    public int UpdateNb(){
                ServicePanier sp= new ServicePanier();
                int nb= sp.NombreLivres();
                return nb;
            }
    
    public float Updateprix(){
                ServicePanier sp= new ServicePanier();
                float p= sp.PrixLivres();
                return p;
            }

    @FXML
    private void UpdateTable(ActionEvent event) {
        list_panier.removeAll(list_panier);
        UpdatePanier();
        list_panier = loadData(list_panier);
        tab_panier.setItems(list_panier);
        nbr_total.setText(String.valueOf(UpdateNb()));
        total_prix.setText(String.valueOf(Updateprix()));
    }
    
     public void setUsername(String user) {
	      this.username.setText(user);
	}
}
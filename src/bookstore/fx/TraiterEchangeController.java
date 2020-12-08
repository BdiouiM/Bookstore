/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.model.Echange;
import bookstore.service.ServiceAdmin;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author mega pc
 */
public class TraiterEchangeController implements Initializable {

    @FXML
    private TextField labelEchange;
    @FXML
    private VBox echangeitems;
    @FXML
    private TableView<Echange> tabview;

    /**
     * Initializes the controller class.
     */
    
    public void initialize() {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("EchangeItem.fxml"));
             
                
                
        
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Node[] node=new Node[1];
         for (int i = 0; i < node.length; i++) {
            try{
               
                node[i]=FXMLLoader.load(getClass().getResource("EchangeItem.fxml"));
                echangeitems.getChildren().add(node[i]);
            }
            catch(Exception e){
                System.err.println("erreur dans items");
            }
        }
         TableColumn Identifiantechange = new TableColumn("Identifiantechange");
         TableColumn CIN1 = new TableColumn("CIN1");
         TableColumn CIN2 = new TableColumn("CIN2");
         TableColumn Titre1 = new TableColumn("Titre1");
         TableColumn Titre2 = new TableColumn("Titre2");
         TableColumn StatutEchange = new TableColumn("StatutEchange");
         TableColumn Annuler = new TableColumn("Annuler");
         TableColumn Valider = new TableColumn("Valider");
         tabview.getColumns().addAll(Identifiantechange,CIN1,CIN2,Titre1,Titre2,StatutEchange,Annuler,Valider);
         
         Identifiantechange.setCellFactory(new PropertyValueFactory<Echange,String>("Identifiantechange"));
         CIN1.setCellFactory(new PropertyValueFactory<Echange,String>("CIN1"));
         CIN2.setCellFactory(new PropertyValueFactory<Echange,String>("CIN2"));
         Titre1.setCellFactory(new PropertyValueFactory<Echange,String>("Titre1"));
         Titre2.setCellFactory(new PropertyValueFactory<Echange,String>("Titre2"));
         StatutEchange.setCellFactory(new PropertyValueFactory<Echange,String>("StatutEchange"));
    }
    
   

    private void ListerEchange(ActionEvent event) {
         ServiceAdmin sa=new ServiceAdmin();
         ObservableList<Echange> data = FXCollections.observableArrayList();
         tabview.setItems(data);
    }
    
}

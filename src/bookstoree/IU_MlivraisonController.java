/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoree;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import connexion.connexion;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class IU_MlivraisonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // llenadocombobox();
    }   
   /* public void llenadocombobox() {
        connexion cnx = null;
            ObservableList<String> listacombo= FXCollections.observableArrayList();
            String consulta = "select adrclient from livraison";
            PreparedStatement ps;
        try {
            ps = cnx.getConnection().prepareStatement(consulta);
             ResultSet rs = null;
        
            rs = ps.executeQuery();
               
              while ( rs.next() ) 
             {  
               listacombo.add(rs.getString("adrclient"));
                 
               
             }
       
        } catch (SQLException ex) {
            Logger.getLogger(IU_MlivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
            
               
           combo.setItems(listacombo);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }*/
    
}

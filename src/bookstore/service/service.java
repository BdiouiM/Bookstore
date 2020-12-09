/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.service;
import entity.livraison.livraison; 
import bookstore.Interface.interface_livraison;
import bookstore.connexion.connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Pc
 */
public class service implements interface_livraison {
  connexion cnx;
    public service()
    {
        cnx=connexion.getIstance();
        System.out.println("Connection établie");
    }

    /**
     *
     * @param v
     */
    @Override
    public void ajouter_livraison(livraison v) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req= "insert into livraison (id_livraison ,coords, adrclient,id_client,id_livreur) values (?,?,?,?,?)";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setInt(1, v.getId()); 
            ps.setString(2, v.getCoords());
          ps.setString(3,v.getAdrClient());
            ps.setInt(4, v.getId_client());
            ps.setInt(5, v.getId_livreur());
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            System.err.println("erreur");
        }
    } public void modifier_Livraison(livraison v) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
           String sql = "UPDATE livraison SET adrClient=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(sql); 
       
           ps.setString(1,v.getAdrClient());
 
int rowsUpdated = ps.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("An existing user was updated successfully!");
}
            
            
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            System.err.println("erreur");
        }
    }
    
    /**
     *
     */
    @Override
    public void  afficher_livraison()  {
      try {
          String sql = "SELECT * FROM livraison";
          
          Statement statement = cnx.getConnection().createStatement();
          ResultSet result = statement.executeQuery(sql);
          
          
          while (result.next()){
              int id = result.getInt(1);
              int id_client = result.getInt(4);
              int id_livreur = result.getInt(5);
              String coords = result.getString(2);
              String adrClient = result.getString(3);
              
              System.out.println("livraison : " +id+"/"+coords+"/"+adrClient +"/"+id_client+"/"+id_livreur);
              
          } } catch (SQLException ex) {
          Logger.getLogger(service.class.getName()).log(Level.SEVERE, null, ex);
      }
}
       public void  suprrimer_livraison(livraison v ) {
                try {
       String sql = "DELETE FROM livraison WHERE id_livraison=2";
PreparedStatement ps = cnx.getConnection().prepareStatement(sql);
ps.executeUpdate(sql); } catch (SQLException ex) {
            System.err.println("erreur");
        }

}

    @Override
    public void modifier_livraison(livraison v) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer_livraison(livraison v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   



}

package bookstore.service;

import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Reclamation;
import bookstore.exception.ReclamationExisteException;
import bookstore.Interface.EnvoyerReclamationInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ServiceClient implements EnvoyerReclamationInterface {
    bookstoreConnexion cnx;
    
    public ServiceClient()
    {
        cnx=bookstoreConnexion.getIstance();
    }
    
    
    @Override
    public void envoyerReclamation(Reclamation r) throws ReclamationExisteException {
      if(existeReclamation(r))
          throw (new ReclamationExisteException("la réclamation existe déja"));
      else
      {try {
            String req= "INSERT INTO reclamation (UsernameClient,DateReclamation,StatutReclamation,Type,Description)VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
                 ps.setString(1, r.getClientUsername());
                 ps.setString(2, r.getDateReclamation());
                 ps.setString(3, r.getStatutReclamation());
                 ps.setString(4, r.getType());
                 ps.setString(5, r.getDescription());
            ps.executeUpdate(); 
            System.out.println("Reclamation envoyée");
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
      }
    }

    @Override
    public void modifierReclamation(Reclamation r) {
        try {
            annulerReclamations(r);
        } catch (ReclamationExisteException ex) {
            System.err.println("erreur modification");
        }
    }

    @Override
    public void annulerReclamations(Reclamation r) throws ReclamationExisteException {
        if(existeReclamation(r))
            throw (new ReclamationExisteException("existe déja"));
        else
        {try {
            String req= "DELETE FROM reclamation WHERE UsernameClient=? ";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
                 ps.setString(1, r.getClientUsername());
            ps.executeUpdate(); 
            System.out.println("Reclamation supprimée");
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }}
    }

    @Override
    public boolean existeReclamation(Reclamation r) {
         
        try {
            String req1= "select * from reclamation ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Reclamation TEST = new Reclamation();
                TEST.setClientUsername(rs.getString("ClientUsername"));
                TEST.setDateReclamation(rs.getString("DateReclamation"));
                TEST.setType(rs.getString("Type"));
                if(TEST.equals(r))
                    return true;
                
            }
        } catch (SQLException ex) {
            System.err.println("errrr");
        }
        return false;
    }
    
}

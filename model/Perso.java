package bookstore.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import bookstore.Interface.InterfacePerso;
import bookstore.connexion.Myconnection;
import bookstore.model.Personnel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author oumaima
 */
public class Perso implements InterfacePerso{
Myconnection cnx;

    public Perso() {
          cnx=Myconnection.getInstance();
    }

    @Override
    public void modifierPerso(Personnel p, int CIN) {
 
        
    try {
         String req3= "update personnel set poste=? ,cin=?, nom=?, prenom=?, adresse=?, email=?, username=?, password=?, type=?  where username=?";
        PreparedStatement ps = cnx.getConnection().prepareStatement(req3);
        ps.setString(1, p.getPoste());
            ps.setInt(2, p.getCIN());
            ps.setString(3, p.getNom());         
            ps.setString(4, p.getPrenom());
            ps.setString(5, p.getAdresse());
               ps.setString(6, p.getEmail());
                 ps.setString(7, p.getUsername());
                   ps.setString(8, p.getPassword());
                     ps.setString(9, p.getType());
                     ps.setString(10, p.getUsername());
         ps.executeUpdate(); 
    } catch (SQLException ex) {
           System.err.println(ex.getMessage());
    }
    }

    }
    


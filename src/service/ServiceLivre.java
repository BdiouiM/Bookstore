/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Livre;
import connexion.bookstoreConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariem Messaoudi
 */
public class ServiceLivre implements Interface.InterfaceLivre{
     bookstoreConnexion cnx ;
    public ServiceLivre(){
        cnx = bookstoreConnexion.getInstance();
       
    }  

    @Override
    public void ajouterLivre(Livre l) {
         try {
             String req = "insert into livre(id_livre,titre,auteur,prix) values(?,?,?,?)";
             PreparedStatement ps= cnx.getConnection().prepareStatement(req);
             ps.setInt(1, l.getId());
             ps.setString(2, l.getTitre());
             ps.setString(3, l.getAuteur());
             ps.setFloat(4, l.getPrix());
             ps.executeUpdate();
             System.out.println("livre ajouté");
         } catch (SQLException ex) {
             Logger.getLogger(ServiceLivre.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void afficherLivre() {
         try {
             String req1= "select * from livre";
             Statement s = cnx.getConnection().createStatement();
             ResultSet rs= s.executeQuery(req1);
             while (rs.next()) {
                System.out.println("id "+rs.getInt("id_livre")+" titre "+rs.getString("titre")+" auteur "+rs.getString("auteur")+" prix "+rs.getFloat("prix"));
                
            }
         } catch (SQLException ex) {
             Logger.getLogger(ServiceLivre.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}

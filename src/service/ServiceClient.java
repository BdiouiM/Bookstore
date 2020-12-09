/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Client;
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
public class ServiceClient implements Interface.InterfaceClient{
 bookstoreConnexion cnx ;
    public ServiceClient() {
        cnx = bookstoreConnexion.getInstance();
    }

    @Override
    public void ajouterClient(Client c) {
     try {
         String req = "insert into client (id_client,nom_client,adresse,email) values(?,?,?,?)";
         PreparedStatement ps= cnx.getConnection().prepareStatement(req);
         ps.setInt(1, c.getId_client());
         ps.setString(2, c.getNom());
         ps.setString(3, c.getAdresse());
         ps.setString(4, c.getEmail());
         ps.executeUpdate();
         System.out.println("client ajouté");
     } catch (SQLException ex) {
         Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    @Override
    public void afficherClient() {
     try {
         String req1= "select * from client";
         Statement s = cnx.getConnection().createStatement();
         ResultSet rs= s.executeQuery(req1);
         while (rs.next()) {
             System.out.println("id "+rs.getInt("id_client")+" nom "+rs.getString("nom_client")+" adresse "+rs.getString("adresse")+" email "+rs.getString("email"));
                      }
     } catch (SQLException ex) {
         Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
}


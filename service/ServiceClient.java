/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.InterfaceClient;
import Connexion.Myconnection;
import model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oumaima
 */
public class ServiceClient implements InterfaceClient{
Myconnection cnx;

    public ServiceClient() {
          cnx=Myconnection.getInstance();
    }

    @Override
    public void supprimerClient(Client c) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req1= "delete from client where cin=? AND nom=?  AND prenom=? AND adresse=? AND email=? AND username=? AND password=? AND type=? ";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req1);        
            ps.setInt(1, c.getCIN());
            ps.setString(2, c.getNom());         
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getAdresse());
               ps.setString(5, c.getEmail());
                 ps.setString(6, c.getUsername());
                   ps.setString(7, c.getPassword());
                     ps.setString(8, c.getType());
                    
                      ps.executeUpdate(); 
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifierClient(Client c, int CIN) {
       try {
         String req3= "update client set cin=?, nom=?, prenom=?, adresse=?, email=?, username=?, password=?, type=?  where cin=? ";
        PreparedStatement ps = cnx.getConnection().prepareStatement(req3);
       
            ps.setInt(1, c.getCIN());
            ps.setString(2, c.getNom());         
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getAdresse());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getUsername());
            ps.setString(7, c.getPassword());
            ps.setString(8, c.getType());  
              ps.setInt(9, c.getCIN());

         ps.executeUpdate(); 
    } catch (SQLException ex) {
           System.err.println(ex.getMessage());
    }
    }

    @Override
    public void consulterClient() {
          try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req2= "select * from client ";
             PreparedStatement s= cnx.getConnection().prepareStatement(req2);
          
            ResultSet res = s.executeQuery(req2);
            while(res.next())
            {
                System.out.println("ID :"+res.getInt("ID")+", "+" CIN :"+res.getString("CIN")+", "+" Nom :"+res.getString("Nom")+", "+" Prenom :"+res.getString("Prenom")+", "+" Email :"+res.getString("Email"));
            }
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
    }
@Override
     public void consulterAchat(){
      try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req2= "select * from Achat ";
             PreparedStatement s= cnx.getConnection().prepareStatement(req2);
          
            ResultSet res = s.executeQuery(req2);
            while(res.next())
            {
            //    System.out.println("ID :"+res.getInt("ID")+"," "TitreLivre :"+res.getString("TitreLivre"), +" Date :"+res.getString("date"));
            }
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
     }
}

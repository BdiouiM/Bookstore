/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.InterfacePersonnel;
import Connexion.Myconnection;
import model.Client;
import model.Personnel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oumaima
 */
public class ServicePersonnel implements InterfacePersonnel{
Myconnection cnx;

    public ServicePersonnel() {
          cnx=Myconnection.getInstance();
    }

   
  

    @Override
    public void ajouterPersonnel(Personnel p) {
          try {
           
            String req= "insert into personnel (poste,cin,nom,prenom,adresse,email,username,password,type) values (?,?,?,?,?,?, ?, ?, ?)";
              PreparedStatement ps = cnx.getConnection().prepareStatement(req);
                ps.setString(1, p.getPoste());
            ps.setInt(2, p.getCIN());
            ps.setString(3, p.getNom());         
            ps.setString(4, p.getPrenom());
            ps.setString(5, p.getAdresse());
               ps.setString(6, p.getEmail());
                 ps.setString(7, p.getUsername());
                   ps.setString(8, p.getPassword());
                     ps.setString(9, p.getType());
               
            
             ps.executeUpdate(); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerPersonnel(Personnel p) {
         try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req1= "delete from personnel where poste=? AND cin=? AND nom=?  AND prenom=? AND adresse=? AND email=? AND username=? AND password=? AND type=? ";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req1);
          ps.setString(1, p.getPoste());
            ps.setInt(2, p.getCIN());
            ps.setString(3, p.getNom());         
            ps.setString(4, p.getPrenom());
            ps.setString(5, p.getAdresse());
               ps.setString(6, p.getEmail());
                 ps.setString(7, p.getUsername());
                   ps.setString(8, p.getPassword());
                     ps.setString(9, p.getType());
                      ps.executeUpdate(); 
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifierPersonnel(Personnel p, String Username) {
        
    try {
         String req3= "update personnel set poste=? ,cin=?, nom=?, prenom=?, adresse=?, email=?, username=?, password=?, type=?  where username=? ";
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
    } catch (Exception ex) {
           System.err.println(ex.getMessage());
    }
    }

    @Override
    public void consulterPersonnel() {
      //  private ObservaleList<Personnel> personnelData= FxCollection.observableArrayList();
        
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req2= "select * from personnel ";
             PreparedStatement s= cnx.getConnection().prepareStatement(req2);
          
            ResultSet res = s.executeQuery(req2);
           
            while(res.next())
            {
                System.out.println("ID :"+res.getInt("ID")+", "+" Poste :"+res.getString("Poste")+", "+" CIN :"+res.getString("CIN")+", "+" Nom :"+res.getString("Nom")+", "+" Prenom :"+res.getString("Prenom")+", "+" Email :"+res.getString("Email"));
            }
                    
            }
         catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
       
    }
@Override
 public void supprimerClie(Client c){
      try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req1= "delete from client where poste=? AND cin=? AND nom=?  AND prenom=? AND adresse=? AND email=? AND username=? AND password=? AND type=? ";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req1);
     
            ps.setInt(1, c.getCIN());
            ps.setString(2, c.getNom());         
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getAdresse());
               ps.setString(5, c.getEmail());
                 ps.setString(6,c.getUsername());
                   ps.setString(7, c.getPassword());
                     ps.setString(8, c.getType());
                      ps.executeUpdate(); 
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
 }
 }


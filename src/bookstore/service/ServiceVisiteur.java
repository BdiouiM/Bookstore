/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.service;

import bookstore.Interface.InterfaceVisiteur;
import bookstore.model.Visiteur;



import bookstore.connexion.My_connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oumaima
 */
public class ServiceVisiteur implements InterfaceVisiteur{
My_connexion cnx;

    public ServiceVisiteur() {
          cnx=My_connexion.getIstance();
    }
      @Override
    public void search() {
         try {
           
            String req1= "select cin ,username from personnel ";
             PreparedStatement s= cnx.getConnection().prepareStatement(req1);
              ResultSet res = s.executeQuery(req1);
             while(res.next())
            {
           res.getString("cin");
           res.getString("username");
            }
            
          
           
           
    } catch (Exception e) {
             System.out.println(e.getMessage());
    }}
    @Override
    public void ajouterCom(Visiteur v) {
         
         try {
            
         /*   String req1= "select * from client where cin = "+ v.getCIN();
                      PreparedStatement pss = cnx.getConnection().prepareStatement(req1);
                      
                      System.out.println(req1);
                    ResultSet x=pss.executeQuery();
                     
                     if(x== null){    */     
                                                   
                String req= "insert into client (cin,nom,prenom,adresse,email,username,password,type) values (?,?,?,?,?, ?, ?, ?)";
              PreparedStatement ps = cnx.getConnection().prepareStatement(req);
                
            ps.setInt(1, v.getCIN());
            ps.setString(2, v.getNom());         
            ps.setString(3, v.getPrenom());
            ps.setString(4, v.getAdresse());
            ps.setString(5, v.getEmail());
            ps.setString(6, v.getUsername());
            ps.setString(7, v.getPassword());
            ps.setString(8, v.getType());
           
            ps.executeUpdate();
                                     
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_store.service;

import book_store.Interface.AuthentificationInterface;
import book_store.My_connexion;
import bookstore.model.Administrateur;
import bookstore.model.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceAuthentification implements AuthentificationInterface{
    My_connexion cnx;

    public ServiceAuthentification()
    {
    	cnx=My_connexion.getIstance();
    }

    @Override
    public boolean clientAuthentification(String username, String password) {
       
         try {
            String req1= "select * from client ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Client client = new Client();
                client.setUsername(rs.getString("UsernameClient"));
                client.setPassword(rs.getString("Password"));
                if(client.getPassword().equals(password)&&client.getUsername().equals(username))
                    return true;
                
            }
        } catch (SQLException ex) {
            System.err.println("erreur authentification client : "+ex);
        }
        return false;
    }

    @Override
    public boolean adminAuthentification(String username, String password) {
         try {
            String req1= "select * from admin ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Administrateur admin = new Administrateur();
                admin.setUsername(rs.getString("UsernameAdmin"));
                admin.setPassword(rs.getString("Password"));
                if(admin.getPassword().equals(password)&&admin.getUsername().equals(username))
                    return true;
                
            }
        } catch (SQLException ex) {
            System.err.println("erreur authentification admin : "+ex);
        }
        return false;
      
    }

   
}

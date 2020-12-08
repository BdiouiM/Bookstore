/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.service;

import bookstore.Interface.AuthentificationInterface;
import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Administrateur;
import bookstore.model.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class ServiceAuthentification implements AuthentificationInterface{
     bookstoreConnexion cnx;
    
    public ServiceAuthentification()
    {
        cnx=bookstoreConnexion.getIstance();
    }

    @Override
    public boolean clientAuthentification(String username, String password) {
       
         try {
            String req1= "select * from Client ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Client client = new Client();
                client.setUsername(rs.getString("Username"));
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
            String req1= "select * from administrateur ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Administrateur admin = new Administrateur();
                admin.setUsername(rs.getString("Username"));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oumaima
 */
public class Myconnection {
   private String url="jdbc:mysql://localhost:3306/bookstore";
           private String login="root";
           private String mdp="";
private Connection connexion;
private static Myconnection instance;
    private Myconnection() {
       try {
           connexion = DriverManager.getConnection(url, login, mdp);
           System.out.println("Connexion etablie");
                   } catch (SQLException ex) {
                      
           Logger.getLogger(Myconnection.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
       public static Myconnection getInstance()   {
           if(instance==null)
              
               instance = new Myconnection();
                
           return instance;
}
  public Connection getConnection(){
      return connexion;
  }
  }

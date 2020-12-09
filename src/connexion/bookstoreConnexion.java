/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariem Messaoudi
 */
public class bookstoreConnexion {
    private String url="jdbc:mysql://localhost:3306/bookstore";
    private String login="root";
    private String pwd="";
    private Connection connexion;
    private static bookstoreConnexion instance;
    
    private bookstoreConnexion(){
        try {
            connexion = DriverManager.getConnection(url, login, pwd);
            System.out.println("cnx etablie");
        } catch (SQLException ex) {
            Logger.getLogger(bookstoreConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public static bookstoreConnexion getInstance(){
        if (instance==null){
             instance= new bookstoreConnexion();             
        }
        return instance;
    }
    public java.sql.Connection getConnection(){
        return connexion;
    }
}

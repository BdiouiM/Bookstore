
package bookstore1.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Myconnexion {
    private String url="jdbc:mysql://localhost:3306/bookstore";
    private String login="root";
    private String pwd="";
    private Connection connexion;
    private static Myconnexion instance ;
    
    private Myconnexion(){
        try {
            connexion =DriverManager.getConnection(url, login, pwd);
            System.out.println("connection établie");
        } catch (SQLException ex) {
            Logger.getLogger(Myconnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Myconnexion getInstance(){
        if (instance==null){
            instance = new Myconnexion();
        }
        return instance;
    }
    public Connection getConnection(){
        return connexion;
    }
    
}

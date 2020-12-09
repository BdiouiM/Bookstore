/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

/**
 *
 * @author Pc
 */
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion  {
  
    private String url="jdbc:mysql://localhost:3306/bookstore";
    private String login="root";
    private String pwd="";
    private Connection connexion;
    private static connexion instance;
    
    private connexion()
    {
      
        try {
            connexion=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion établie ");
        } catch (SQLException ex) {
            Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static connexion getIstance()
    {
        if(instance==null)
            instance=new connexion();
        
        return instance;
    }
    
    public Connection getConnection()
    {
        
        return connexion;
    }

    

}

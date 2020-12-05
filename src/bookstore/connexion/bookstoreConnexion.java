package bookstore.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class bookstoreConnexion {
     private String url="jdbc:mysql://localhost:3306/bookstore";
    private String login="root";
    private String pwd="";
    private Connection connexion;
    private static bookstoreConnexion instance;
    
    public bookstoreConnexion()
    {
          try {
            connexion=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
              System.err.println("connexion n'est pas établie");
        }
    }
    public static bookstoreConnexion getIstance()
    {
        if(instance==null)
            instance=new bookstoreConnexion();
        
        return instance;
    }
    public Connection getConnection()
    {
        return connexion;
    }
}

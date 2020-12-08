package book_store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class My_connexion {
	 private String url="jdbc:mysql://localhost:3306/bookstore";
	    private String login="root";
	    private String pwd="";
	    private Connection connexion;
	    private static My_connexion instance;
	    
	    private My_connexion() {
	    
	            try {
					connexion=DriverManager.getConnection(url, login, pwd);
		            System.out.println("connecté");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
	    
	    public static My_connexion getIstance()
	    {
	        if(instance==null)
	            instance=new My_connexion();
	        
	        return instance;
	    }
	    public Connection getConnection()
	    {
	        return connexion;
	    }
	       
}

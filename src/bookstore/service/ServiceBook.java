package bookstore.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.model.Book;
import bookstore.connexion.My_connexion;
import bookstore.Interface.InterfaceBook;
import bookstore.fx.MesLivresAdminController;

public class ServiceBook implements InterfaceBook {
    My_connexion cnx;
public ServiceBook() {
	cnx=My_connexion.getIstance();
    System.out.println("Connection �tablie");
}
	@Override
	public void ajouterBook(Book b) {
		// TODO Auto-generated method stub
         try {
    		 String req= "insert into livre (Genre,Titre,Auteur,Prix,nbrPages,quantite) values (?,?,?,?,?,?)";
			PreparedStatement ps = cnx.getConnection().prepareStatement(req);
			 ps.setString( 1, b.getGenre());
			 ps.setString( 2, b.getTitre());
			 ps.setString( 3, b.getAuteur());
			 ps.setDouble( 4, b.getPrix());
			 ps.setInt( 5, b.getNbrPages());
			 ps.setInt( 6, b.getQuantite());

	            ps.executeUpdate(); 
         } catch (SQLException e) {
			// TODO Auto-generated catch block
e.printStackTrace();		}
	}

	  @Override
	    public void afficher() {
 
		  try {
	            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	            String req1= "select * from livre ";
	            Statement s= cnx.getConnection().createStatement();
	           // ArrayList<Book> list = new ArrayList(50);
	            ResultSet rs = s.executeQuery(req1);
	            while(rs.next())
	            {
	               System.out.println("ID : " + rs.getInt("Id")+ "  | Genre : " + rs.getString("Genre")+"  | Titre : " + rs.getString("Titre")+"  | Auteur : " + rs.getString("Auteur")+" | Prix : " + rs.getFloat("Prix")+" | Nombre de pages : " + rs.getInt("nbrPages"));
	               
	            }
	        } catch (SQLException ex) {
               
	        	ex.getStackTrace();

	        }
		       
	        
	    }
	 
	@Override
	public void supprimerBook(Book b) {
		 try {
	            String req2= "DELETE from livre WHERE Id='"+b.getId()+"'";
				PreparedStatement s2 = cnx.getConnection().prepareStatement(req2);
	            s2.executeUpdate(req2); 
	            System.out.println("supprim�");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
	            System.out.println("erreur de suppression !");
	            e.printStackTrace();
			}	
	}
	@Override
	public void update(Book b, String Genre, String Titre, String Auteur, double Prix, int nbrPages, int Quantite) {
		// TODO Auto-generated method stub
		 
		 try {
			 String req3= "UPDATE livre SET Genre=? "+ " WHERE Id='"+b.getId()+"'";
			 System.out.println(req3);
			PreparedStatement s3 = cnx.getConnection().prepareStatement(req3);
			s3.setString(1, Genre);
			s3.setString(2, Titre);
			s3.setString(3, Auteur);
			s3.setDouble(4, Prix);
			s3.setInt(5, nbrPages);
            s3.executeUpdate(req3); 
	         System.out.println("Modifi�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void supprimerBook1(bookstore.model.Book b) {
		// TODO Auto-generated method stub
		 try {
	            String req2= "DELETE from livre WHERE Id='"+b.getId()+"'";
				PreparedStatement s2 = cnx.getConnection().prepareStatement(req2);
	            s2.executeUpdate(req2); 
                System.out.println(b.getId());
	            System.out.println("supprim�");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
	            System.out.println("erreur de suppression !");
	            e.printStackTrace();
			}	
		
	}
	public void modifierBook(bookstore.model.Book b, int i) {
		
		 try {
	            String req= "UPDATE livre SET Genre=? , Titre=? , Auteur=? , Prix=? , nbrPages=? , Quantite=? WHERE Id=?";
	            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
	             ps.setString(1, b.getGenre());
	             ps.setString(2, b.getTitre());
	             ps.setString(3, b.getAuteur());
	             ps.setDouble(4, b.getPrix());
	             ps.setInt(5, b.getNbrPages());
	             ps.setInt(6, b.getQuantite());

	             ps.setInt(7, i);
	             ps.executeUpdate(); 
	            System.out.println("Livre modifi�");
	        } catch (SQLException ex) {
	            System.err.println(ex);
	            
	        }
		
	}
	
	public ArrayList<bookstore.model.Book> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
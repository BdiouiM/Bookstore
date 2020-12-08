
package bookstore;

import bookstore1.entite.Remise;
import bookstore1.interfacee.InterfaceUser;
import bookstore1.technique.Myconnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ServiceUser implements InterfaceUser{
    Myconnexion cnx ;
    public  ServiceUser(){
        cnx = Myconnexion.getInstance();
    }
    @Override
    public void ajouterRemise(Remise r) {
        try {
            String req ="Insert into remise(idLivre,pourcentage,ancienPrix,nouveauPrix) values(?,?,?,?)";
            PreparedStatement prep = cnx.getConnection().prepareStatement(req);
            float f = selectPrix(r.getIdLivre());
            float remise = f*r.getPourcentage() ;
            
            prep.setInt(1, r.getIdLivre());
            prep.setFloat(2, r.getPourcentage());
            prep.setFloat(3, f);
            
            
            prep.setFloat(4,f-remise);
            prep.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        
        
    }

    @Override
    public void afficher() {
        try {
            String req = "select * from remise";
            Statement s = cnx.getConnection().createStatement();
            
            ResultSet rs = s.executeQuery(req);
            while(rs.next()){
                System.out.println("id: "+ rs.getInt("id")+" idLivre: "+rs.getInt("idLivre")+" pourcentage: "+rs.getFloat("pourcentage")+"ancien prix: "+rs.getFloat("ancienPrix")+" nouveau prix: "+rs.getFloat("nouveauPrix"));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
    }

    @Override
    public void supprimerRemise(Remise r) {
        
        try {
            String req = " delete  from remise where id="+r.getId();
            PreparedStatement s = cnx.getConnection().prepareStatement(req);
            System.out.println("remise supprimée");
            s.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        
        
    }
    
    

    @Override
    public float selectPrix(int id) {
        try {
            
            String req = "select prix from livre where idLivre ="+id;
            Statement s2 = cnx.getConnection().createStatement();
            ResultSet rs = s2.executeQuery(req);
            rs.next();
            
            return rs.getFloat("prix");
            
        } catch (SQLException ex) {
            return 0;
        }
        
    }
    
}

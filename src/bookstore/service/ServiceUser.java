
package bookstore.service;

import bookstore.model.Remise;
import bookstore.Interface.InterfaceUser;
import bookstore.connexion.Myconnexion;
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
            float nvpr =f-remise;
            
            prep.setInt(1, r.getIdLivre());
            prep.setFloat(2, r.getPourcentage());
            prep.setFloat(3, f);
            
            
            prep.setFloat(4,f-remise);
            prep.executeUpdate();
            String req1 ="update  livre set prix ="+ nvpr + " where idLivre ="+r.getIdLivre();
            prep.executeUpdate(req1);
            
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
            float pourc = selectPourcentage(r.getId());
            int idlivre = selectId(r.getId());
            
            float var = 1-pourc;
            float nvpr =  selectPrix(idlivre)/var;
            String req = " delete  from remise where id="+r.getId();
            String req1 ="update  livre set prix ="+ nvpr + " where idLivre ="+idlivre;
            PreparedStatement s = cnx.getConnection().prepareStatement(req1);
            PreparedStatement s1 = cnx.getConnection().prepareStatement(req);
            
            
            
            s.executeUpdate();
            s1.executeUpdate();
            System.out.println("remise supprimée");
            
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
    public int selectId(int id) {
        try {
            
            String req = "select idLivre from remise where id ="+id;
            Statement s2 = cnx.getConnection().createStatement();
            
            ResultSet rs = s2.executeQuery(req);
            rs.next();
            
            return rs.getInt("idLivre");
            
            
        } catch (SQLException ex) {
            return 0 ;
        }
        
    }
    public float selectPourcentage(int id) {
        try {
            
            String req = "select pourcentage from remise where id ="+id;
            Statement s2 = cnx.getConnection().createStatement();
            
            ResultSet rs = s2.executeQuery(req);
            rs.next();
            
            return rs.getFloat("pourcentage");
            
            
        } catch (SQLException ex) {
            return 0 ;
        }
        
    }
    
}

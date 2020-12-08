package bookstore.service;

import bookstore.Interface.EnvoyerEchangeInterface;
import bookstore.connexion.bookstoreConnexion;
import bookstore.exception.EchangeException;
import bookstore.model.Client;
import bookstore.model.Echange;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ServiceClient implements EnvoyerEchangeInterface {
    bookstoreConnexion cnx;
    
    public ServiceClient()
    {
        cnx=bookstoreConnexion.getIstance();
    }
    
    
    
    
    @Override
    public void envoyerEchange(Echange e) throws EchangeException {
      try {
            String req= "INSERT INTO echange (Identifiantechange,CIN1,CIN2,Titre1,Titre2,StatutEchange,Client1Confirmation)VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
                 ps.setString(1, e.getIdentifiantechange());
                 ps.setString(2, e.getCIN1());
                 ps.setString(3, e.getCIN2());
                 ps.setString(4, e.getTitre1());
                 ps.setString(5, e.getTitre2());
                 ps.setString(6, e.getStatutEchange());
                 ps.setString(7, "en cours ..");
                 
            ps.executeUpdate(); 
            System.out.println("Echange envoyée");
        } catch (SQLException ex) {
            System.err.println("erreur dans l'envoi"+ ex.getMessage());
            
        }
      
    }
    @Override
    public boolean existeEchange(Echange e) {
         
        try {
            String req1= "select * from echange ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Echange TEST = new Echange();
                TEST.setIdentifiantechange(rs.getString("Identifiantechange"));
                TEST.setCIN1(rs.getString("CIN1"));
                TEST.setTitre1(rs.getString("Titre1"));
                if(TEST.equals(e))
                    return true;
                
            }
        } catch (SQLException ex) {
            System.err.println("errrr");
        }
        return false;
    }

    @Override
    public void annulerEchange(Echange e) throws EchangeException {
        
    if(existeEchange(e))
            throw (new EchangeException("existe déja"));
        else
        {try {
            String req= "DELETE * FROM echanage WHERE Identifiantechange=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
                 ps.setString(1, e.getIdentifiantechange());
            ps.executeUpdate(); 
            System.out.println("Echange supprimée");
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }  
}
  
}

    @Override
    public void modifierEchange(Echange e) {
        
              
        try {
             String req5= "UPDATE echange SET CIN2=?, Titre2=? where Identifiantechange=?";
             PreparedStatement s5=cnx.getConnection().prepareCall(req5);
             s5.setString(1,e.getCIN2());
             s5.setString(2,e.getTitre2());
             s5.setString(3, e.getIdentifiantechange());
             s5.executeUpdate();
             System.out.println("Modifié");
        } catch (SQLException ex) {
            System.err.println("errrr");
            System.out.println("Modification erroné");
        }
       
        
}

    @Override
    public void afficherMesEchange(Echange e) {
        try {
            String req1= "select * from echange WHERE CIN1="+e.getCIN1();
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Echange TEST = new Echange();
                TEST.setIdentifiantechange(rs.getString("Identifiantechange"));
                TEST.setCIN1(rs.getString("CIN1"));
                TEST.setTitre1(rs.getString("Titre1"));
                
                
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans mes EChange");
        }
    }  

    @Override
    public boolean validerEchangec(Echange e) throws EchangeException {
    
        try {
            String req= "UPDATE echange SET Client1Confirmation=? WHERE Identifiantechange=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
             ps.setString(1, "Validée..");
             ps.setString(2, e.getIdentifiantechange());
            ps.executeUpdate(); 
            System.out.println("Echange Validée");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
         return false;
  
    }

    @Override
    public boolean AnnulerEchangec(Echange e) {
        
        try {
            String req= "UPDATE echange SET CIN2=?,Titre2=?,Client1Confirmation=? WHERE Identifiantechange=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
             ps.setString(1, "Waiting for echange..");
             ps.setString(2, "Waiting for echange..");
             ps.setString(3, "Waiting for new echnage");
             ps.setString(4, e.getIdentifiantechange());
             ps.executeUpdate(); 
            System.out.println("Echange Annuler");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
         return false;
    }
    
    @Override
    public boolean pointerEchangec(Echange e) {
        try {
            
            String req= "UPDATE echange SET CIN2=?,Titre2=? WHERE Identifiantechange=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
             ps.setString(1, e.getCIN2());
             ps.setString(2, e.getTitre2());
             ps.setString(3, e.getIdentifiantechange());
             ps.executeUpdate(); 
            System.out.println("Echange Annuler");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }/*}*/
         return false;
        
    }

    @Override
    public boolean freeEchange(Echange e) {
        try {
            String req= "UPDATE echange SET CIN2=?,Titre2=?,Client1Confirmation=? WHERE Identifiantechange=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
             ps.setString(1, "Waiting for echange..");
             ps.setString(2, "Waiting for echange..");
             ps.setString(3, "Waiting for new echnage");
             ps.setString(4, e.getIdentifiantechange());
             ps.executeUpdate(); 
            System.out.println("Echange Annuler");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
         return false;
    }
    
}

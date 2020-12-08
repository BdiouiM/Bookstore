package bookstore.service;

import bookstore.Interface.ListerEchangeInterface;
import bookstore.connexion.bookstoreConnexion;
import bookstore.Interface.TraiterEchangeInterface;
import bookstore.exception.EchangeException;
import bookstore.model.Administrateur;
import bookstore.model.Echange;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceAdmin implements TraiterEchangeInterface,ListerEchangeInterface{

    bookstoreConnexion cnx;
    
    public ServiceAdmin()
    {
        cnx=bookstoreConnexion.getIstance();
    }
  
    @Override
    public boolean annulerEchange(Echange e) throws EchangeException {
       // if(!existeEchange(e))
           //throw (new EchangeException("n'existe pas"));
      // else{
        try {
            String req= "UPDATE echange SET StatutEchange=? WHERE Identifiantechange=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
             ps.setString(1, "annulée..");
             ps.setString(2, e.getIdentifiantechange());
             ps.executeUpdate(); 
            System.out.println("Echange annulée");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }/*}*/
         return false;
    }
    @Override
    public boolean validerEchange(Echange e) throws EchangeException {
        
       
        try {
            String req= "UPDATE echange SET StatutEchange=? WHERE Identifiantechange=?";
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
    public boolean TraiterEchange(Echange e) {
        try {
            return annulerEchange(e)||validerEchange(e);
        } catch (EchangeException ex) {
            System.err.println("erreur traitement");
        }
        return false;
    }

    @Override
    public List<Echange> afficherEchange() {
        List<Echange> listeEchange = new ArrayList<>();
        try {
            String req1= "select * from echange ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Echange e = new Echange();
                e.setIdentifiantechange(rs.getString("Identifiantechange"));
                e.setCIN1(rs.getString("CIN1"));
                e.setCIN2(rs.getString("CIN2"));
                e.setTitre1(rs.getString("Titre1"));
                e.setTitre2(rs.getString("Titre2"));
                e.setStatutEchange(rs.getString("StatutEchange"));
                
                listeEchange.add(e);
            }
        } catch (SQLException ex) {
            System.err.println("errrr");
        }
        return listeEchange;
    }

    @Override
    public List<Echange> afficherEchange(Echange e) throws EchangeException {
        if (!existeEchange(e))
           throw (new EchangeException("Echange n'existe pas"));
       else
       {List<Echange> unEchange = new ArrayList<>();
        String Identifiantechange =e.getIdentifiantechange();
        try {
            String req1= "SELECT * FROM echange WHERE Identifiantechange="+Identifiantechange;
            Statement s= cnx.getConnection().createStatement();
            
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                e.setIdentifiantechange(rs.getString("Identifiantechange"));
                e.setCIN1(rs.getString("CIN1"));
                e.setCIN2(rs.getString("CIN2"));
                e.setTitre1(rs.getString("Titre1"));
                e.setTitre2(rs.getString("Titre2"));
                e.setStatutEchange(rs.getString("StatutEchange"));
                unEchange.add(e);
            }
        } catch (SQLException ex) {
            System.err.println("errrr");
        }
       
        return unEchange;}
   
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

    public int NombreEchanges() {
        int nombre=0;
         try {
            String req1= "select * from echange ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                nombre++;
                
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans nombre echanges");
        }
       
        return nombre;
    }
    
public  String getRecepient()
   { 
         String recepient="test ";
         try {
            String req1= "SELECT Email FROM client";
            Statement s= cnx.getConnection().createStatement();
            
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Administrateur a = new Administrateur();
                a.setEmail(rs.getString("Email"));
                recepient=a.getEmail();
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans getRecepient "+ex);
        }
       return recepient;
   }
}


    

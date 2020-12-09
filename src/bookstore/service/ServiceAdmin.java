package bookstore.service;

import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Reclamation;
import bookstore.Interface.ListerReclamationInterface;
import bookstore.Interface.TraiterReclamationInterface;
import bookstore.exception.ReclamationExisteException;
import com.sun.deploy.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceAdmin implements TraiterReclamationInterface,ListerReclamationInterface{

    bookstoreConnexion cnx;
    
    public ServiceAdmin()
    {
        cnx=bookstoreConnexion.getIstance();
    }
    
    @Override
    public boolean annulerReclamation(Reclamation r) throws ReclamationExisteException {
         if(!existeReclamation(r))
           throw (new ReclamationExisteException("n'existe pas"));
       else{
        try {
            String req= "UPDATE reclamation SET StatutReclamation=? WHERE Identifiant=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
             ps.setString(1, "annulée..");
             System.out.println(r.getIdentifiant());
              ps.setInt(2, r.getIdentifiant());
            ps.executeUpdate(); 
            System.out.println("Reclamation annulée");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }}
         return false;
    }

    @Override
    public boolean validerReclamations(Reclamation r)  throws ReclamationExisteException {
       if(!existeReclamation(r))
           throw (new ReclamationExisteException("n'existe pas"));
       else{
         try {
                String req= "UPDATE reclamation SET StatutReclamation=? WHERE Identifiant=?";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setString(1, "validée..");
           ps.setInt(2, r.getIdentifiant());
            ps.executeUpdate(); 
            System.out.println("Reclamation validée");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }}
         return false;
    }

    @Override
    public boolean TraiterReclamation(Reclamation r) {
        try {
            return annulerReclamation(r)||validerReclamations(r);
        } catch (ReclamationExisteException ex) {
            System.err.println("erreur traitement");
        }
        return false;
    }

    @Override
    public List<Reclamation> ListReclamations() {
        List<Reclamation> listeReclamations = new ArrayList<>();
        try {
            String req1= "select * from reclamation ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Reclamation r = new Reclamation();
                r.setClientUsername(rs.getString("UsernameClient"));
                r.setDateReclamation(rs.getString("DateReclamation"));
                r.setDescription(rs.getString("Description"));
                r.setType(rs.getString("Type"));
                r.setStatutReclamation(rs.getString("StatutReclamation"));
                listeReclamations.add(r);
            }
        } catch (SQLException ex) {
            System.err.println("errrr");
        }
        return listeReclamations;
    }
    @Override
     public  void AfficherReclamations(List<Reclamation> reclamations, Consumer<Reclamation> consumer){
         for (Reclamation r : reclamations) {
               consumer.accept(r);
          }   
     }
    @Override
    public Set<Reclamation> afficherReclamation(Reclamation r) throws ReclamationExisteException{
        
       if (!existeReclamation(r))
           throw (new ReclamationExisteException("Réclamation n'existe pas"));
       else
       {   System.out.println("reclamation existe :");
           Set<Reclamation> uneReclamation = new HashSet<>();
           
        try {
            String username =r.getClientUsername();
            String req1= "SELECT * FROM reclamation";
             Statement s= cnx.getConnection().createStatement();
             ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                if(rs.getString("UsernameClient") == null ? username == null : rs.getString("UsernameClient").equals(username))
                { Reclamation rTest = new Reclamation();
                rTest.setClientUsername(rs.getString("UsernameClient"));
                rTest.setDateReclamation(rs.getString("DateReclamation"));
                rTest.setDescription(rs.getString("Description"));
                rTest.setType(rs.getString("Type"));
                rTest.setStatutReclamation(rs.getString("StatutReclamation"));
                uneReclamation.add(rTest);}
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans l'affichage d'une reclamation:"+ex);
        }
       
        return uneReclamation;}
    }

    @Override
    public boolean existeReclamation(Reclamation r) {
        
        try {
            String req1= "select * from reclamation ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Reclamation TEST = new Reclamation();
                TEST.setClientUsername(rs.getString("UsernameClient"));
                TEST.setDateReclamation(rs.getString("DateReclamation"));
                TEST.setType(rs.getString("Type"));
                if(TEST.equals(r))
                    return true;
                
            }
        } catch (SQLException ex) {
            System.err.println("errrr");
        }
        return false;
    }

    @Override
    public int NombreReclamations() {
        int nombre=0;
         try {
            String req1= "select * from reclamation ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                nombre++;
                
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans nombre reclamations");
        }
       
        return nombre;
    }

    @Override
    public void SendSMS() {
       try {
                        String recipient = "22723458";
                        String message = "Hello ";
                        String username = "bdioui";
                        String password = "bdioui";
                        String originator = "22723458";
 
                        String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
            "username=" + URLEncoder.encode(username, "UTF-8") +
            "&password=" + URLEncoder.encode(password, "UTF-8") +
            "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
            "&messagetype=SMS:TEXT" +
            "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
            "&originator=" + URLEncoder.encode(originator, "UTF-8") +
            "&serviceprovider=GSMModem1" +
            "&responseformat=html";
 
 
 
                        URL url = new URL(requestUrl);
                        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
 
                        System.out.println(uc.getResponseMessage());
 
                        uc.disconnect();
 
                } catch(Exception ex) {
                        System.out.println(ex.getMessage());
 
                }
    }
    
}

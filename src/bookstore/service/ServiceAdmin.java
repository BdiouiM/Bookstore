package bookstore.service;

import bookstore.Interface.ListerEchangeInterface;
import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Reclamation;
import bookstore.Interface.ListerReclamationInterface;
import bookstore.Interface.TraiterEchangeInterface;
import bookstore.Interface.TraiterReclamationInterface;
import bookstore.exception.EchangeException;
import bookstore.exception.ReclamationExisteException;
import bookstore.model.Administrateur;
import bookstore.model.Echange;
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
import java.util.Properties;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceAdmin implements TraiterReclamationInterface,ListerReclamationInterface,TraiterEchangeInterface,ListerEchangeInterface{

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
   public void SendEmail(){
            final String username = "mymail before @";
           final String password = "password";
           String client=getRecepient();
           String adminMail="ahmeddridi1996@gmail.com";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mymail"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(adminMail)
            );
            message.setSubject("Echange de ");
            message.setText("Echange ");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
   }
}

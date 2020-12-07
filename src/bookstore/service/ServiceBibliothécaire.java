/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import bookstore.model.Livre;
import bookstore.Interface.VerifierStockInterface;
import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Reclamation;
import bookstore.exception.LivreExisteReclamation;
import bookstore.exception.ReclamationExisteException;
import bookstore.model.Administrateur;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceBibliothécaire implements VerifierStockInterface{
    bookstoreConnexion cnx;
    Session mailSession;
    public ServiceBibliothécaire()
    {
        cnx=bookstoreConnexion.getIstance();
    }
    
    
    @Override
    public boolean existeLivre(Livre l) {
          
        try {
            String req1= "select * from livre ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Livre TEST = new Livre();
                TEST.setAuteur(rs.getString("Auteur"));
                TEST.setNbrPages(rs.getInt("nbrPages"));
                TEST.setPrix(rs.getFloat("Prix"));
                TEST.setTitre(rs.getString("Titre"));
                if(TEST.equals(l))
                    return true;
                
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans l'existence");
        }
        return false;
    }

    @Override
    public int QuantiteLivre(Livre l) throws LivreExisteReclamation {
       int quantite=0;
       if(!existeLivre(l))
           throw(new LivreExisteReclamation("livre n'existe pas"));
       else{
            try {
            String req1= "select * from livre ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Livre TEST = new Livre();
               
               
                //TEST.setPrix(rs.getFloat("Prix"));
                TEST.setTitre(rs.getString("Titre"));
                 TEST.setAuteur(rs.getString("Auteur"));
                  TEST.setNbrPages(rs.getInt("nbrPages"));
                if(TEST.equals(l))
                    quantite++;
                
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans quantite : "+ex);
        }
       }
        return quantite;
    }

    @Override
    public int QuantiteLivres() {
        int quantiteTotale=0;   
        try {
            String req1= "select * from livre ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                quantiteTotale++;
                
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans quantite livres");
        }
       
        return quantiteTotale;
    }

  

   public  String getRecepient()
   { 
         String recepient="test ";
         try {
            String req1= "SELECT Email FROM admin";
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
    @Override
    public List<Livre> ListerLivres() {
        List<Livre> livres = new ArrayList<Livre>();
         try {
            String req1= "SELECT * FROM livre";
            Statement s= cnx.getConnection().createStatement();
            
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                Livre l = new Livre();
                l.setTitre(rs.getString("Titre"));
                l.setAuteur(rs.getString("Auteur"));
                l.setNbrPages(rs.getInt("nbrPages"));
                l.setPrix(rs.getFloat("Prix"));
                l.setGenre(rs.getString("Genre"));
                livres.add(l);
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans l'affichage");
        }
         return livres;
    }
    @Override
     public  void AfficherLivres(List<Livre> livres, Consumer<Livre> consumer){
         livres.stream().forEach((l) -> {
             consumer.accept(l);
        });   
     }
    @Override
    public List<Livre>  afficherLivre(Livre l) throws LivreExisteReclamation {
          if (!existeLivre(l))
           throw (new LivreExisteReclamation("livre n'existe pas"));
       else
       {List<Livre> unLivre = new ArrayList<>();
        String titre =l.getTitre();
        try {
            String req1= "SELECT * FROM livre WHERE UsernameClient="+titre;
            Statement s= cnx.getConnection().createStatement();
            
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                l.setTitre(rs.getString("Titre"));
                l.setAuteur(rs.getString("Auteur"));
                l.setNbrPages(rs.getInt("nbrPages"));
                l.setPrix(rs.getFloat("Prix"));
                unLivre.add(l);
            }
        } catch (SQLException ex) {
            System.err.println("erreur dans l'affichage");
        }
       
        return unLivre;}
    }
    
       @Override
       public void passerCommandeLivre(Livre l)throws Exception {
           final String username = "mohamedbedioui10";
           final String password = "Mohamedbdioui100";

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
            message.setFrom(new InternetAddress("mohamedbedioui10@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("bibliothecaire@gmail.com")
            );
            message.setSubject("Alimentation de "+l.getTitre());
            message.setText("Vous devez alimenter le livre '"+l.getTitre()+"'");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }

    }


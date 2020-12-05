/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.service;

import bookstore.model.Livre;
import bookstore.Interface.VerifierStockInterface;
import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Reclamation;
import bookstore.exception.LivreExisteReclamation;
import bookstore.exception.ReclamationExisteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ServiceBibliothécaire implements VerifierStockInterface{
    bookstoreConnexion cnx;
    
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

    @Override
    public void passerCommandeLivre(Livre l) {

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
         for (Livre l : livres) {
               consumer.accept(l);
          }   
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
    
}

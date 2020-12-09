/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.service;

import bookstore.Interface.InterfacePanier;
import bookstore.model.Livre;
import bookstore.model.Panier;
import bookstore.model.Client;
import bookstore.connexion.bookstoreConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariem Messaoudi
 */
public class ServicePanier implements InterfacePanier{
    
    bookstoreConnexion cnx ;
   
    public ServicePanier(){
        cnx = bookstoreConnexion.getIstance();
       }

@Override
    public void ajouterLivrePanier(Livre l,Client c) {
        try {
            String req = "insert into panier(titre, prix, id_client,id_livre,prix_total) values(?,?,?,?,?)";
            PreparedStatement ps= cnx.getConnection().prepareStatement(req);
            ps.setString(1, l.getTitre());
            ps.setFloat(2, l.getPrix());
            ps.setInt(3, c.getId_client());
            ps.setInt(4, l.getIdentifiant());
            ps.setFloat(5, l.getPrix()*1);
            ps.executeUpdate();
            System.out.println("livre ajouté au panier");
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

      @Override
    public void modifierquantite(Livre l, Client c, int quantite) {
        try {
            String req1= "UPDATE panier SET quantite=? WHERE id_livre=? AND id_client=?";
            PreparedStatement ps= cnx.getConnection().prepareStatement(req1);
            ps.setInt(1, quantite);
            ps.setInt(2, l.getIdentifiant());
            ps.setInt(3, c.getId_client());
            ps.executeUpdate();
            System.out.println("Quantité mise à jour");
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          modifierPrixTotal(l, c,quantite);
    }
    
    @Override
    public void supprimerLivrePanier(Livre l, Client c) {
        try {
            String req1= "DELETE FROM panier WHERE id_livre=? AND id_client=?";
            PreparedStatement ps= cnx.getConnection().prepareStatement(req1);
            ps.setInt(1, l.getIdentifiant());
            ps.setInt(2, c.getId_client());
            ps.executeUpdate();
            System.out.println("Livre supprimé du panier");
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ViderPanier() {
        try {
            String req1= "TRUNCATE TABLE panier ";
            Statement s = cnx.getConnection().createStatement();
            s.executeUpdate(req1);
            System.out.println("Panier vidé");
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @Override
    public void ValiderCommande() {

            System.out.println("Commande validée");
            JOptionPane.showMessageDialog(null, "Commande validée");

    }



    @Override
    public List<Panier> afficher(Client c) {
        List<Panier> liste = new ArrayList<>();
        try {
            String req= "select * from panier WHERE id_client='"+c.getId_client()+"'";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {Panier p = new Panier();
            p.setTitre(rs.getString("titre"));
            p.setQuantite(rs.getInt("quantite"));
            p.setPrix(rs.getFloat("prix"));
            p.setId_client(rs.getInt("id_client"));
            p.setId_livre(rs.getInt("id_livre"));
                liste.add(p);
            }
            System.out.println(liste);

            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }

    @Override
    public int NombreLivres() {
       int nb=0;
        try {
            String req= "SELECT * FROM panier ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req);
            while(rs.next())
            {
            nb++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
       return nb;
    }

    @Override
    public float PrixLivres() {
        float total=0;
        try {
            
            String req= "SELECT * FROM panier ";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                float tot = rs.getFloat("prix_total");
                total= total+tot;
            }   
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @Override
    public void modifierPrixTotal(Livre l, Client c, int quant) {

        try {
            String req1= "UPDATE panier SET prix_total=? WHERE id_livre=? AND id_client=?";
            PreparedStatement ps= cnx.getConnection().prepareStatement(req1);
            ps.setFloat(1, quant*l.getPrix() );
            ps.setInt(2, l.getIdentifiant());
            ps.setInt(3, c.getId_client());
            ps.executeUpdate();
            System.out.println("Prix total mise à jour");
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

    
    }
    
    

    
    
  


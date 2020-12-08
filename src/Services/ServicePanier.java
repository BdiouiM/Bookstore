/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.*;
import Techniques.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interfaces.*;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Mariem Messaoudi
 */
public class ServicePanier implements InterfacePanier{
    
    Connexion cnx ;
   
    public ServicePanier(){
        cnx = Connexion.getInstance();
       }

@Override
    public void ajouterLivrePanier(Livre l,Client c) {
        try {
            String req = "insert into panier(titre, prix, id_client,id_livre) values(?,?,?,?)";
            PreparedStatement ps= cnx.getConnection().prepareStatement(req);
            ps.setString(1, l.getTitre());
            ps.setFloat(2, l.getPrix());
            ps.setInt(3, c.getId_client());
            ps.setInt(4, l.getId());
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
            ps.setInt(2, l.getId());
            ps.setInt(3, c.getId_client());
            ps.executeUpdate();
            System.out.println("Quantité mise à jour");
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void supprimerLivrePanier(Livre l, Client c) {
        try {
            String req1= "DELETE FROM panier WHERE id_livre=? AND id_client=?";
            PreparedStatement ps= cnx.getConnection().prepareStatement(req1);
            ps.setInt(1, l.getId());
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
            String req1= "TRUNCATE TABLE panier";
            Statement s = cnx.getConnection().createStatement();
            s.executeUpdate(req1);
            System.out.println("Panier vidé");
        } catch (SQLException ex) {
            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @Override
    public void ValiderCommande() {
//        application.getHostServices().showDocument("http://www.mywebsite.org"); //redirection 
        
//        try {
//            String req= "UPDATE panier";
//            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
//            ps.executeUpdate();
            System.out.println("Commande validée");
//        } catch (SQLException ex) {
//            Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }



    @Override
    public List<Panier> afficher(Client c) {
        List<Panier> liste = new ArrayList<>();
        try {
            String req= "select * from panier WHERE id_client='"+c.getId_client()+"'";
            PreparedStatement s = cnx.getConnection().prepareStatement(req);
            ResultSet rs = s.executeQuery();
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

  
}

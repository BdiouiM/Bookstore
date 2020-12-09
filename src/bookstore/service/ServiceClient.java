package bookstore.service;

import bookstore.Interface.EnvoyerEchangeInterface;
import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Reclamation;
import bookstore.exception.ReclamationExisteException;
import bookstore.Interface.EnvoyerReclamationInterface;
import bookstore.Interface.InterfaceClient;
import bookstore.exception.EchangeException;
import bookstore.model.Client;
import bookstore.model.Echange;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ServiceClient implements EnvoyerReclamationInterface,EnvoyerEchangeInterface,InterfaceClient {
    bookstoreConnexion cnx;
    
    public ServiceClient()
    {
        cnx=bookstoreConnexion.getIstance();
    }
    
    
    @Override
    public void envoyerReclamation(Reclamation r) throws ReclamationExisteException {
      if(existeReclamation(r))
          throw (new ReclamationExisteException("la réclamation existe déja"));
      else
      {try {
            String req= "INSERT INTO reclamation (UsernameClient,DateReclamation,StatutReclamation,Type,Description)VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
                 ps.setString(1, r.getClientUsername());
                 ps.setString(2, r.getDateReclamation());
                 ps.setString(3, r.getStatutReclamation());
                 ps.setString(4, r.getType());
                 ps.setString(5, r.getDescription());
            ps.executeUpdate(); 
            System.out.println("Reclamation envoyée");
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }
      }
    }

    @Override
    public void modifierReclamation(Reclamation r) {
        try {
            annulerReclamations(r);
        } catch (ReclamationExisteException ex) {
            System.err.println("erreur modification");
        }
    }

    @Override
    public void annulerReclamations(Reclamation r) throws ReclamationExisteException {
        if(existeReclamation(r))
            throw (new ReclamationExisteException("existe déja"));
        else
        {try {
            String req= "DELETE FROM reclamation WHERE UsernameClient=? ";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
                 ps.setString(1, r.getClientUsername());
            ps.executeUpdate(); 
            System.out.println("Reclamation supprimée");
        } catch (SQLException ex) {
            System.err.println(ex);
            
        }}
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
                TEST.setClientUsername(rs.getString("ClientUsername"));
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
     @Override
    public void supprimerClient(Client c) {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req1= "delete from client where CIN=? AND Nom=?  AND Prenom=? AND Adresse=? AND Email=? AND UsernameClient=? AND Password=? ";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req1);        
            ps.setInt(1, c.getCIN());
            ps.setString(2, c.getNom());         
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getAdresse());
               ps.setString(5, c.getEmail());
                 ps.setString(6, c.getUsername());
                   ps.setString(7, c.getPassword());
                    // ps.setString(8, c.getType());
                    
                      ps.executeUpdate(); 
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifierClient(Client c, String Username) {
       try {
         String req3= "update client set CIN=?, Nom=?, Prenom=?, Adresse=?, Email=?, Username=?, Password=?  where UsernameClient=? ";
        PreparedStatement ps = cnx.getConnection().prepareStatement(req3);
       
            ps.setInt(1, c.getCIN());
            ps.setString(2, c.getNom());         
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getAdresse());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getUsername());
            ps.setString(7, c.getPassword());
           // ps.setString(8, c.getType());  
              ps.setString(8, c.getUsername());

         ps.executeUpdate(); 
    } catch (SQLException ex) {
           System.err.println(ex.getMessage());
    }
    }

    @Override
    public void consulterClient() {
          try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req2= "select * from client ";
             PreparedStatement s= cnx.getConnection().prepareStatement(req2);
          
            ResultSet res = s.executeQuery(req2);
            while(res.next())
            {
                System.out.println("ID :"+res.getInt("Id")+", "+" CIN :"+res.getString("CIN")+", "+" Nom :"+res.getString("Nom")+", "+" Prenom :"+res.getString("Prenom")+", "+" Email :"+res.getString("Email"));
            }
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
    }
@Override
     public void consulterAchat(){
      try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String req2= "select * from Achat ";
             PreparedStatement s= cnx.getConnection().prepareStatement(req2);
          
            ResultSet res = s.executeQuery(req2);
            while(res.next())
            {
            //    System.out.println("ID :"+res.getInt("ID")+"," "TitreLivre :"+res.getString("TitreLivre"), +" Date :"+res.getString("date"));
            }
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
     }


    
    
}

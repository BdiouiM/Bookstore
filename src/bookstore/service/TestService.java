package bookstore.service;

import bookstore.exception.LivreExisteReclamation;
import bookstore.exception.ReclamationExisteException;
import bookstore.model.Administrateur;
import bookstore.model.Client;
import bookstore.model.Livre;
import bookstore.model.Reclamation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestService {
    public static void main(String[] args) throws Exception {
        
      
          
            
            
            //********  Client ********* //
            /*Client c1 = new Client(1, 00000000, "Mohamed", "Bdioui", "zahra", "mohamed@esprit.tn", "Bdioui","", "", 22723458);
            Reclamation r1 = new Reclamation("Test1", "Test1", "Test1", "Test1", "Test1");
            Reclamation r2 = new Reclamation("Test2", "Test2", "Test2", "Test2", "Test2");
            ServiceClient sc = new ServiceClient();
            //  Envoyer Reclamation //
            System.out.println("************Envoyer Reclamation************");
            try {
            
            sc.envoyerReclamation(r1);
            sc.envoyerReclamation(r2);
            } catch (ReclamationExisteException ex) {
            System.err.println("erreur dans l'envoie");
            }
            //  Annuler Reclamation //
            System.out.println("************Annuler Reclamation************");
            try {
            sc.annulerReclamations(r1);
            
            } catch (ReclamationExisteException ex) {
            System.err.println(ex);
            }
            //  Existe Reclamation //
            System.out.println("************Existe Reclamation************");
            System.out.println(sc.existeReclamation(r1));
            
            
            //********  Admin ********* //
           /* Administrateur a = new Administrateur();
            ServiceAdmin sa = new ServiceAdmin();
            
            //  Valider Reclamation //
            System.out.println("************Valider Reclamation************");
            try {
            System.out.println(sa.validerReclamations(r2));
            } catch (ReclamationExisteException ex) {
            System.err.println(ex);
            }
            //  Annuler Reclamation //
            System.out.println("************Annuler Reclamation************");
            try {
            System.out.println(sa.annulerReclamation(r2));
            } catch (ReclamationExisteException ex) {
            System.err.println(ex);
            }
            //  Afficher Reclamation //
            System.out.println("************Afficher Reclamation************");
            Set<Reclamation> s = new HashSet<>();
            try {
            s=sa.afficherReclamation(r2);
            } catch (ReclamationExisteException ex) {
            System.err.println(ex);
            }
            System.out.println(s);
            //  List Reclamations //
            System.out.println("************Liste Reclamations************");
            List<Reclamation> l = new ArrayList<Reclamation>();
            l=sa.ListReclamations();
            System.out.println(l);
            //  Afficher Reclamations //
            System.out.println("************Afficher Reclamations************");
            sa.AfficherReclamations(l, new Consumer<Reclamation>() {
            
            @Override
            public void accept(Reclamation r) {
            System.out.println(r);
            }
            });
            //  Existe Reclamations //
            System.out.println("************Existe Reclamations************");
            System.out.println(sa.existeReclamation(r2));
            
            */
            
//********  Bibliothécaire ********* //
          Livre livre1 = new Livre("", "", 200, 1.2f,"");
             ServiceBibliothécaire sb = new ServiceBibliothécaire();
             sb.passerCommandeLivre(livre1);
            /* //  Existe   Livre //
            System.out.println("*******Existe livre *********");
            System.out.println(sb.existeLivre(livre1));
            //  Quantite   Livre //
            System.out.println("*******Quantite livre *********");
            try {  
                System.out.println(sb.QuantiteLivre(livre1));
        } catch (LivreExisteReclamation ex) {
                System.err.println("probléme :  "+ex);
        }
            //  Quantite   Livres //
          System.out.println("*******Quantite livres *********");
          System.out.println(sb.QuantiteLivres());
          //  List   Livres //
          System.out.println("*******List livres *********");
          List<Livre>  livres = new ArrayList<>();
          livres = sb.ListerLivres();
          System.out.println(livres);
          //  Afficher   Livres //
           System.out.println("*******Afficher livres *********");
           sb.AfficherLivres(livres, new Consumer<Livre>() {

                @Override
                public void accept(Livre l) {
                    System.out.println(l);
                }
            });*/

    }
}

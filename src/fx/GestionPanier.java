/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mariem Messaoudi
 */
public class GestionPanier extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
//
//    ServiceLivre s= new ServiceLivre();
//    Livre l1= new Livre(1,"adulthere", "coelho", 20f);
//    Livre l2= new Livre(2,"mme bovary", "flaubert", 25f);
//    Livre l4= new Livre(6,"le petit prince", "exupery", 10f);
    
//    s.ajouterLivre(l1); s.ajouterLivre(l2);
//    s.afficherLivre();
//    Panier p=new Panier();

////
//    ServiceClient sc =new ServiceClient();
//    Client c1= new Client(1,"mariem mess","ariena","ksks@gmail.com");
//     Client c2= new Client(2,"tounsi ahmed","tunis","gthuj@gmail.com");
//     Client c3= new Client(3,"driss oumayma ","ben arous","driss@gmail.com");
//    sc.ajouterClient(c1);sc.ajouterClient(c2); sc.ajouterClient(c3);
//    sc.afficherClient();
    


//    ServicePanier sp = new ServicePanier();
//    Panier p = new Panier();
//    sp.ajouterLivrePanier(l4,c1);
//    
//    sp.ajouterLivrePanier(l1,c1);
//    sp.ajouterLivrePanier(l2,c1);
//    sp.ajouterLivrePanier(l1,c3);
//                      sp.afficherPanier(c3);
//sp.ViderPanier();
//    sp.afficherPanier();
//sp.supprimerLivrePanier(l1, c1);
//sp.ajouterLivrePanier(l2,c1);
//sp.modifierquantite(l4, c1, 2);
//sp.afficher(c1);
    
    }
    
}

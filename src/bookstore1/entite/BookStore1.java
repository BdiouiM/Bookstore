
package bookstore1.entite;

import bookstore.ServiceUser;


public class BookStore1 {

   
    public static void main(String[] args) {
        ServiceUser s = new ServiceUser();
        Remise r1 = new Remise(1,2, 0.2f);
        Remise r2 = new Remise(2,1,0.4f);
        Remise r3 = new Remise(3,3,0.3f);
        
        s.ajouterRemise(r1);
        s.ajouterRemise(r2);
        s.ajouterRemise(r3);
        s.afficher();
        s.supprimerRemise(r1);
        s.afficher();
        
        
        
        
    }
    
}

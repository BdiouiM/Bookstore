
package bookstore.model;

import bookstore.service.ServiceUser;


public class BookStore1 {

   
    public static void main(String[] args) {
        ServiceUser s = new ServiceUser();
        
       Remise r4 = new Remise(1,4,0.5f);
       s.ajouterRemise(r4);
       s.afficher();
       s.supprimerRemise(r4);
       s.afficher();
        
        
        
    }
    
}

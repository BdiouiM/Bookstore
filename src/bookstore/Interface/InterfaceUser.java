
package bookstore.Interface;

import bookstore.model.Remise;


public interface InterfaceUser {
    public void ajouterRemise(Remise r);
    public void afficher();
    public void supprimerRemise(Remise r);
    public float selectPrix(int id);
    
}

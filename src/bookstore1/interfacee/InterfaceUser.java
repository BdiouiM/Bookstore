
package bookstore1.interfacee;

import bookstore1.entite.Remise;


public interface InterfaceUser {
    public void ajouterRemise(Remise r);
    public void afficher();
    public void supprimerRemise(Remise r);
    public float selectPrix(int id);
    
}

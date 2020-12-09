/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import entity.livraison.livraison;
/**
 *
 * @author Pc
 */
public interface interface_livraison {
    
    public void ajouter_livraison(livraison v);
    public void modifier_livraison(livraison v); 
    public void afficher_livraison();
    public void supprimer_livraison(livraison v);
   
}

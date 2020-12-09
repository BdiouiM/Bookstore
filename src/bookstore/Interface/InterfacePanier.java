/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Interface;

import bookstore.model.Livre;
import bookstore.model.Panier;
import bookstore.model.Client;
import java.util.List;

/**
 *
 * @author Mariem Messaoudi
 */
 public interface InterfacePanier {
      
public  List<Panier> afficher(Client c);
public void ajouterLivrePanier(Livre l,Client c);
public void modifierquantite(Livre l, Client c, int quantite);
public void modifierPrixTotal(Livre l, Client c,  int quant);
public void ValiderCommande();
public void supprimerLivrePanier(Livre l,Client c);
public void ViderPanier();
public int NombreLivres();
public float PrixLivres();

 }
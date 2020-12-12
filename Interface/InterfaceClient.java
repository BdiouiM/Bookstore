/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Interface;

import bookstore.model.Client;

/**
 *
 * @author oumaima
 */
public interface InterfaceClient {
  
       public void supprimerClient(Client c);
          public void modifierClient(Client c, int CIN);
             public void consulterClient();
             public void consulterAchat();
}

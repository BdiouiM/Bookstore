/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import model.Client;
import model.Personnel;
import java.util.List;


/**
 *
 * @author oumaima
 */
public interface InterfacePersonnel {
    public void ajouterPersonnel(Personnel p);
       public void supprimerPersonnel(Personnel p);
          public void modifierPersonnel(Personnel p,String Username);
             public void consulterPersonnel();
             public void supprimerClie(Client c);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Interface;

import bookstore.exception.EchangeException;
import bookstore.model.Client;
import bookstore.model.Echange;

/**
 *
 * @author mega pc
 */
public interface EnvoyerEchangeInterface {
    
     public void envoyerEchange(Echange e) throws EchangeException;
     public void modifierEchange(Echange e);
     public void annulerEchange(Echange e) throws EchangeException;
     public boolean existeEchange(Echange e);
     public void afficherMesEchange(Echange e);
     public boolean validerEchangec(Echange e) throws EchangeException;
     public boolean AnnulerEchangec(Echange e);
     
     
     
     public boolean pointerEchangec(Echange e);
     public boolean freeEchange(Echange e);
}

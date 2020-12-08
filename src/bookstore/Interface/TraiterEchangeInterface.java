/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Interface;

import bookstore.exception.EchangeException;
import bookstore.model.Echange;

/**
 *
 * @author mega pc
 */
    public interface TraiterEchangeInterface {
    public boolean annulerEchange(Echange e) throws EchangeException;
    public boolean validerEchange(Echange e) throws EchangeException;
    public boolean TraiterEchange(Echange e);
}

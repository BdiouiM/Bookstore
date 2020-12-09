/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Interface;

import bookstore.exception.EchangeException;
import bookstore.model.Echange;
import java.util.List;

/**
 *
 * @author mega pc
 */
public interface ListerEchangeInterface {
    public  List<Echange> afficherEchange();
    public  List<Echange> afficherEchange(Echange e) throws EchangeException;
    public boolean existeEchange(Echange e);
}

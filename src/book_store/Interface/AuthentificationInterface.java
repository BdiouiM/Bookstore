/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_store.Interface;

public interface AuthentificationInterface {
    
    public boolean clientAuthentification(String username,String password);
    public boolean adminAuthentification(String username,String password);
}

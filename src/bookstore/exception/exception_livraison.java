/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.exception;

/**
 *
 * @author Pc
 */
public class exception_livraison extends Exception {

    public exception_livraison() {
        super();
    }
    public exception_livraison(String s){
    super(s);
    }
    
  public  void controle(int id , String coords , String adrClient) throws exception_livraison {
    if ((coords.equals("")== true) ||(adrClient.equals("")==true)){
      throw new exception_livraison("Saisie erronee , saisir vos infos");
  }
    
}
    }
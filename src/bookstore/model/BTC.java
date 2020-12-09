/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

/**
 *
 * @author omen
 */
public class BTC extends Utilisateur{

    public BTC() {
    }

    public BTC(int Identifiant, int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type, int telephone) {
        super(Identifiant, CIN, Nom, Prenom, Adresse, Email, Username, Password, Type, telephone);
    }
    
}

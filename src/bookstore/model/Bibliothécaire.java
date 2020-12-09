/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

public class Bibliothécaire extends Personnel {

    
    
    public Bibliothécaire(float salaire, int Identifiant, int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type,int telephone)  {
        super(salaire,Identifiant, CIN, Nom, Prenom, Adresse, Email, Username, Password, Type,telephone);
    }

    public Bibliothécaire() {
    }
    
}

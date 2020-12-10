/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

/**
 *
 * @author oumaima
 */
public class Visiteur extends Utilisateur{
     public Visiteur() {
        super();
    }

    public Visiteur(int Identifiant, int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type, int telephone) {
        super(Identifiant, CIN, Nom, Prenom, Adresse, Email, Username, Password, Type, telephone);
    }


    @Override
    public String toString() {
        return super.toString()+"Visiteur{" + '}';
    }
    
}

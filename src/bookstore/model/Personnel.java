/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

/**
 *
 * @author ASUS
 */
public class Personnel extends Utilisateur {
    private float salaire;
 public Personnel() {
        super();
    }
    public Personnel(float salaire) {
        super();
    }

    public Personnel(float salaire, int Identifiant, int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type,int telephone) {
        super(Identifiant, CIN, Nom, Prenom, Adresse, Email, Username, Password, Type,telephone);
        this.salaire = salaire;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personnel other = (Personnel) obj;
        if (Float.floatToIntBits(this.salaire) != Float.floatToIntBits(other.salaire)) {
            return false;
        }
        return true;
    }
    
    
}

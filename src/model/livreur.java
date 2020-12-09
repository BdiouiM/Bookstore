package model;

public class livreur extends Utilisateur {

    public livreur() {
        super();
    }

    public livreur(int Identifiant, int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type,int telephone) {
        super(Identifiant, CIN, Nom, Prenom, Adresse, Email, Username, Password, Type,telephone);
    }

    @Override
    public String toString() {
        return super.toString()+"livreur{" + '}';
    }
    
    
}
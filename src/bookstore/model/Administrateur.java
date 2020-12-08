package bookstore.model;

public class Administrateur extends Utilisateur{
    private float Salaire;

    public Administrateur() {
        super();
    }

    public Administrateur(float Salaire, int Identifiant, int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type,int telephone) {
        super(Identifiant, CIN, Nom, Prenom, Adresse, Email, Username, Password, Type,telephone);
        this.Salaire = Salaire;
    }

    public float getSalaire() {
        return Salaire;
    }

    public void setSalaire(float Salaire) {
        this.Salaire = Salaire;
    }

    @Override
    public String toString() {
        return "Administrateur{"+ super.toString() + "Salaire=" + Salaire + '}';
    }
    
    
}

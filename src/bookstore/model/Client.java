package bookstore.model;

public class Client extends Utilisateur {

    public Client() {
        super();
    }

    public Client(int Identifiant, int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type,int telephone) {
        super(Identifiant, CIN, Nom, Prenom, Adresse, Email, Username, Password, Type,telephone);
    }

    @Override
    public String toString() {
        return super.toString()+"Client{" + '}';
    }
    
    
}

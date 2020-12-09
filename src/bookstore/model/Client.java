package bookstore.model;

public class Client extends Utilisateur {
      private  int id_client;
    public Client() {
        super();
    }

    public Client(int Identifiant, int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type,int telephone) {
        super(Identifiant, CIN, Nom, Prenom, Adresse, Email, Username, Password, Type,telephone);
        this.id_client=id_client;
    }

    @Override
    public String toString() {
        return super.toString()+"Client{" + '}';
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    
    
}

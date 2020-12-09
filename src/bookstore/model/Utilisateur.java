
package bookstore.model;

import java.util.Objects;

public class Utilisateur {
    protected static int Identifiant=0;
    protected int CIN;
    protected String Nom;
    protected String Prenom;
    protected String Adresse;
    protected String Email;
    protected String Username;
    protected String Password;
    protected String Type;
    protected int telephone;

    public Utilisateur() {   }

    public Utilisateur(int Identifiant,int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type,int telephone) {
        this.CIN = CIN;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.Type = Type;
        this.telephone=telephone;
        this.Identifiant++;
    }

    public static int getIdentifiant() {
        return Identifiant;
    }

    public static void setIdentifiant(int Identifiant) {
        Utilisateur.Identifiant = Identifiant;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getCIN() {
        return CIN;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "CIN=" + CIN + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse + ", Email=" + Email + ", Username=" + Username + ", Password=" + Password + ", Type=" + Type + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (this.CIN != other.CIN) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.Prenom, other.Prenom)) {
            return false;
        }
        if (!Objects.equals(this.Type, other.Type)) {
            return false;
        }
        return true;
    }
    
    
    
}

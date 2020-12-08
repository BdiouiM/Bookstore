
package bookstore1.entite;


public class Livre {
    private int id;
    private String nom;
    private String genre;
    private float prix;
    private String auteur;
    private int nbrpages;

    public Livre(int id, String nom, String genre, float prix, String auteur, int nbrpages) {
        this.id = id;
        this.nom = nom;
        this.genre = genre;
        this.prix = prix;
        this.auteur = auteur;
        this.nbrpages = nbrpages;
    }

    public Livre() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getGenre() {
        return genre;
    }

    public float getPrix() {
        return prix;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getNbrpages() {
        return nbrpages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setNbrpages(int nbrpages) {
        this.nbrpages = nbrpages;
    }

    @Override
    public String toString() {
        return "Livre{" + "id=" + id + ", nom=" + nom + ", genre=" + genre + ", prix=" + prix + ", auteur=" + auteur + ", nbrpages=" + nbrpages + '}';
    }
    
    

   
    
    
}

package bookstore.model;

import java.util.Objects;

public class Livre {
    private int Identifiant;
    private String Titre;
    private String auteur;
    private int nbrPages;
    private float prix;
    private String Genre;

    public Livre(){}
    
    public Livre(String Titre, String auteur, int nbrPages, float prix,String Genre) {
        this.Titre = Titre;
        this.auteur = auteur;
        this.nbrPages = nbrPages;
        this.prix = prix;
        this.Genre=Genre;
        this.Identifiant=Identifiant;
    }

    public int getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant(int Identifiant) {
        this.Identifiant = Identifiant;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbrPages() {
        return nbrPages;
    }

    public void setNbrPages(int nbrPages) {
        this.nbrPages = nbrPages;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livre other = (Livre) obj;
        if (!Objects.equals(this.Titre, other.Titre)) {
            return false;
        }
        if (!Objects.equals(this.auteur, other.auteur)) {
            return false;
        }
        return (this.nbrPages == other.nbrPages) ;
          
        
    }

    @Override
    public String toString() {
        return "Livre{" + "Titre=" + Titre + ", auteur=" + auteur + ", nbrPages=" + nbrPages + ", prix=" + prix + '}';
    }
    
    
}

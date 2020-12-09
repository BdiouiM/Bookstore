/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;


public class Remise {
    private int id;
    private int idLivre;
    private float pourcentage;
    private float ancienPrix;
    private float nouveauPrix;

    public Remise(int id,int idLivre, float pourcentage) {
        this.id=id;
        this.idLivre = idLivre;
        this.pourcentage = pourcentage;
    }

    public Remise() {
    }

    public int getId() {
        return id;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public float getAncienPrix() {
        return ancienPrix;
    }

    public float getNouveauPrix() {
        return nouveauPrix;
    }

    public void setAncienPrix(float ancienPrix) {
        this.ancienPrix = ancienPrix;
    }

    public void setNouveauPrix(float nouveauPrix) {
        this.nouveauPrix = nouveauPrix;
    }
    

    public float getPourcentage() {
        return pourcentage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return "Remise{" + "id=" + id + ", idLivre=" + idLivre + ", pourcentage=" + pourcentage + ", ancienPrix=" + ancienPrix + ", nouveauPrix=" + nouveauPrix + '}';
    }

    
    
    
    
}

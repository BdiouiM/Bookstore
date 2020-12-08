/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


/**
 *
 * @author Mariem Messaoudi
 */
public class Livre {
    private  int id_livre;
    private String titre;
    private String auteur;
    private float prix;

    public Livre() {
    }

    public Livre(int id, String titre, String auteur, float prix) {
        this.id_livre = id;
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
    }

    public int getId() {
        return id_livre;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public float getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id_livre = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Livre{" + "id=" + id_livre + ", titre=" + titre + ", auteur=" + auteur + ", prix=" + prix + '}';
    }

    
}

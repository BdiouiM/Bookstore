/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javafx.scene.control.Button;

/**
 *
 * @author Mariem Messaoudi
 */
public class Panier {
    private String titre;
    private int quantite;
    private float prix;
    private float prix_total;
    private int id_client,id_livre;
    private Button supr_btn;

    public Panier() {
    }

    public Panier(String titre, int quantite, float prix, int id_client, int id_livre) {
        this.titre = titre;
        this.quantite = quantite;
        this.prix = prix;
        this.id_client = id_client;
        this.id_livre = id_livre;
        
        
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }
    
    public void setSupr_btn(Button supr_btn) {
        this.supr_btn = supr_btn;
    }

    public Button getSupr_btn() {
        return supr_btn;
    }

    public String getTitre() {
        return titre;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getPrix() {
        return prix;
    }

    public int getId_client() {
        return id_client;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    @Override
    public String toString() {
        return "Panier{" + "titre=" + titre + ", quantite=" + quantite + ", prix=" + prix + ", prix_total=" + prix_total + ", id_client=" + id_client + ", id_livre=" + id_livre + '}';
    }

    
     
}

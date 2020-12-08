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
public class Client{
    private  int id_client;
    private String nom;
    private String adresse;
    private String email;

    public Client() {
    }

    public Client(int id_client, String nom, String adresse, String email) {
        this.id_client = id_client;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
    }

    public int getId_client() {
        return id_client;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", nom=" + nom + ", adresse=" + adresse + ", email=" + email + '}';
    }
    

    
}

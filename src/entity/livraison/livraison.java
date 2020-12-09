/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.livraison;

import java.util.Objects;

/**
 *
 * @author Pc
 */
public class livraison {
    private int id ; 
        private String coords ; 
private String adrClient ;
    private int  id_client ; 
    private int id_livreur ;
 

    public livraison() {
    }

    public livraison(int id, String coords, String adrClient, int id_client, int id_livreur) {
        this.id = id;
        this.coords = coords;
        this.adrClient = adrClient;
        this.id_client = id_client;
        this.id_livreur = id_livreur;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final livraison other = (livraison) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_client != other.id_client) {
            return false;
        }
        if (this.id_livreur != other.id_livreur) {
            return false;
        }
        if (!Objects.equals(this.coords, other.coords)) {
            return false;
        }
        if (!Objects.equals(this.adrClient, other.adrClient)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "livraison{" + "id=" + id + ", coords=" + coords + ", adrClient=" + adrClient + ", id_client=" + id_client + ", id_livreur=" + id_livreur + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public void setAdrClient(String adrClient) {
        this.adrClient = adrClient;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public int getId() {
        return id;
    }

    public String getCoords() {
        return coords;
    }

    public String getAdrClient() {
        return adrClient;
    }

    public int getId_client() {
        return id_client;
    }

    public int getId_livreur() {
        return id_livreur;
    }

   
}

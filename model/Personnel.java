/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import java.util.logging.Logger;

/**
 *
 * @author oumaima
 */
public class Personnel extends Utilisateur{
   
      private String poste;
           
                  private float salaire;
 public Personnel() {
     super();
    }
    public Personnel(String poste,int CIN, String Nom, String Prenom, String Adresse, String Email, String Username, String Password, String Type) {
     super(Identifiant, CIN, Nom, Prenom, Adresse, Email, Username, Password, Type);
        this.poste = poste;
       
    }

    public String getPoste() {
        return poste;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return super.toString()+ "Personnel{" + "poste=" + poste + ", salaire=" + salaire + '}';
    }
   
      

    

   
                  
}

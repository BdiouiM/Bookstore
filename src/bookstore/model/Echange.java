/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import javafx.scene.control.Button;

/**
 *
 * @author mega pc
 */
public class Echange {
    
   private String Identifiantechange;
   private String CIN1;
   private String CIN2;
   private String Titre1;
   private String Titre2;
   private String StatutEchange;

    public Echange(String Identifiantechange, String CIN1, String CIN2, String Titre1, String Titre2, String StatutEchange) {
        this.Identifiantechange = Identifiantechange;
        this.CIN1 = CIN1;
        this.CIN2 = CIN2;
        this.Titre1 = Titre1;
        this.Titre2 = Titre2;
        this.StatutEchange = StatutEchange;
    }

    public Echange() {
        
    }

    public String getIdentifiantechange() {
        return Identifiantechange;
    }

    public void setIdentifiantechange(String Identifiantechange) {
        this.Identifiantechange = Identifiantechange;
    }

    public String getCIN1() {
        return CIN1;
    }

    public void setCIN1(String CIN1) {
        this.CIN1 = CIN1;
    }

    public String getCIN2() {
        return CIN2;
    }

    public void setCIN2(String CIN2) {
        this.CIN2 = CIN2;
    }

    public String getTitre1() {
        return Titre1;
    }

    public void setTitre1(String Titre1) {
        this.Titre1 = Titre1;
    }

    public String getTitre2() {
        return Titre2;
    }

    public void setTitre2(String Titre2) {
        this.Titre2 = Titre2;
    }

    public String getStatutEchange() {
        return StatutEchange;
    }

    public void setStatutEchange(String StatutEchange) {
        this.StatutEchange = StatutEchange;
    }

    @Override
    public String toString() {
        return "Echange{" + "Identifiantechange=" + Identifiantechange + ", CIN1=" + CIN1 + ", CIN2=" + CIN2 + ", Titre1=" + Titre1 + ", Titre2=" + Titre2 + ", StatutEchange=" + StatutEchange + '}';
    }

    public void setAnnuler(Button button) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setValider(Button button) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
   
   
   
   
   
    
}

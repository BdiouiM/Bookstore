package bookstore.model;

import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Reclamation {
    private String Type;
    private String StatutReclamation;
    private String DateReclamation;
    private String Description;
    private String ClientUsername;
    private int Identifiant;
    
    private Button annuler;
    private Button valider;

    public Reclamation() { }

    public Reclamation( String Type, String StatutReclamation, String DateReclamation, String Description,String ClientUsername) {
        this.Type = Type;
        this.StatutReclamation = StatutReclamation;
        this.DateReclamation = DateReclamation;
        this.Description = Description;
         this.ClientUsername = ClientUsername;
    }
public Reclamation( String Type, String StatutReclamation, String DateReclamation, String Description,String ClientUsername,int Identifiant,Button annuler,Button valider) {
        this.Type = Type;
        this.StatutReclamation = StatutReclamation;
        this.DateReclamation = DateReclamation;
        this.Description = Description;
         this.ClientUsername = ClientUsername;
         this.Identifiant = Identifiant;
          this.annuler = annuler;
           this.valider = valider;
    }

    public Button getAnnuler() {
        return annuler;
    }

    public Button getValider() {
        return valider;
    }

    public void setValider(Button valider) {
        this.valider = valider;
        
    }

    public void setAnnuler(Button annuler) {
        this.annuler = annuler;
    }

    public int getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant(int Identifiant) {
        this.Identifiant = Identifiant;
    }

    public String getClientUsername() {
        return ClientUsername;
    }

    public void setClientUsername(String ClientUsername) {
        this.ClientUsername = ClientUsername;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getStatutReclamation() {
        return StatutReclamation;
    }

    public void setStatutReclamation(String StatutReclamation) {
        this.StatutReclamation = StatutReclamation;
    }

    public String getDateReclamation() {
        return DateReclamation;
    }

    public void setDateReclamation(String DateReclamation) {
        this.DateReclamation = DateReclamation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "Type=" + Type + ", StatutReclamation=" + StatutReclamation + ", DateReclamation=" + DateReclamation + ", Description=" + Description + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Reclamation AutreReclamation = (Reclamation) obj;
        
        return (Objects.equals(this.Type, AutreReclamation.Type)&&Objects.equals(this.ClientUsername,
                AutreReclamation.ClientUsername)&&Objects.equals(this.DateReclamation, AutreReclamation.DateReclamation)
                );
    }
    
    
    
    
    
}

package bookstore.Interface;

import bookstore.model.Reclamation;
import bookstore.exception.ReclamationExisteException;
import java.util.List;

public interface TraiterReclamationInterface {
   
     public boolean annulerReclamation(Reclamation r) throws ReclamationExisteException;
     public boolean validerReclamations(Reclamation r) throws ReclamationExisteException;
     public boolean TraiterReclamation(Reclamation r);
     public int NombreReclamations();
     public void SendSMS();
     
}

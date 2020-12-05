package bookstore.Interface;

import bookstore.model.Reclamation;
import bookstore.exception.ReclamationExisteException;
import java.util.List;
import java.util.Set;

public interface EnvoyerReclamationInterface {
    
     public void envoyerReclamation(Reclamation r) throws ReclamationExisteException;
     public void modifierReclamation(Reclamation r);
     public void annulerReclamations(Reclamation r) throws ReclamationExisteException;
     public boolean existeReclamation(Reclamation r);
}

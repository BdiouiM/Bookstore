package bookstore.Interface;

import bookstore.model.Reclamation;
import bookstore.exception.ReclamationExisteException;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public interface ListerReclamationInterface {
    
 public  List<Reclamation> ListReclamations();
 public  void AfficherReclamations(List<Reclamation> reclamations, Consumer<Reclamation> consumer);
 public  Set<Reclamation> afficherReclamation(Reclamation r) throws ReclamationExisteException;
 public boolean existeReclamation(Reclamation r);
}

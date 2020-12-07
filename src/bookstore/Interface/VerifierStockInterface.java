package bookstore.Interface;

import bookstore.model.Livre;
import bookstore.exception.LivreExisteReclamation;
import java.util.List;
import java.util.function.Consumer;

public interface VerifierStockInterface {
    
    public boolean existeLivre(Livre l);
    public int QuantiteLivre (Livre l) throws LivreExisteReclamation;
    public int QuantiteLivres();
    public void passerCommandeLivre(Livre l)throws Exception;
    public List<Livre>  ListerLivres();
    public List<Livre>  afficherLivre(Livre l) throws LivreExisteReclamation;
    public  void AfficherLivres(List<Livre> livres,  Consumer<Livre> consumer);
}

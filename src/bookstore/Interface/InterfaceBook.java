package bookstore.Interface;

import bookstore.model.Book;

public interface InterfaceBook {
	public void ajouterBook(Book b);
    public void supprimerBook(Book b);
    public void afficher();
	void update(Book b, String Genre, String Titre, String Auteur, double Prix, int nbrPages, int Quantite);
	

}

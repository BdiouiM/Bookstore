package book_store.Interface;

import book_store.Book;

public interface InterfaceBook {
	public void ajouterBook(Book b);
    public void supprimerBook(Book b);
    public void afficher();
	void update(Book b, String Genre, String Titre, String Auteur, double Prix, int nbrPages, int Quantite);
	

}

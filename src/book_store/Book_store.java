package book_store;

import book_store.service.ServiceBook;

public class Book_store {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Book b1=new Book(8,"Romance","La mer", "Hedi", 14, 20);
		 Book b2=new Book(4, "Horror","Lucifer", "Mouhamed", 26, 30);
		 Book b3=new Book(4, "nbv","h", "j", 4, 3330);
	        
	        ServiceBook sb=new ServiceBook();
	        //sb.ajouterBook(b3);
	        //sb.ajouterBook(b2);
	        sb.afficher();
	        //sb.supprimerBook(b);
	        //sb.update(b1,"test","test","test",10.0,200);


	        }

}

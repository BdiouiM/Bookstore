package bookstore.model;

import javafx.scene.control.Label;

public class Book {
int Id;
String Genre;
String Titre;
String Auteur;
Float Prix;
int nbrPages;
int Quantite;

public Book(int Id, String Genre , String Titre, String Auteur, Float Prix, int nbrPages, int Quantite) {
	this.Id=Id;
	this.Genre=Genre;
	this.Titre=Titre;
	this.Auteur=Auteur;
	this.Prix=Prix;
	this.nbrPages=nbrPages;
	this.Quantite=Quantite;
}



public Book() {
	// TODO Auto-generated constructor stub
}



public int getId() {
	return Id;
}
public String getGenre() {
	return Genre;
}
public String getTitre() {
	return Titre;
}
public String getAuteur() {
	return Auteur;
}
public int getNbrPages() {
	return nbrPages;
}
public Float getPrix() {
	return Prix;
	
}

public int getQuantite() {
	return Quantite;
}

public void setId(int id) {
	Id = id;
}
public void setGenre(String genre) {
	this.Genre = genre;
}
public void setTitre(String titre) {
	Titre = titre;
}
public void setAuteur(String auteur) {
	Auteur = auteur;
}
public void setNbrPages(int nbrPages) {
	this.nbrPages = nbrPages;
}
public void setPrix(float prix) {
	Prix = prix;
}
public void setQuantite(int quantite) {
	Quantite = quantite;
}


@Override
	public String toString() {
		return "livre : { "+ Id + Genre +Titre + Auteur + Prix + nbrPages + "}";
	}








}

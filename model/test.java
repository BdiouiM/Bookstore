/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import service.ServiceClient;
import service.ServicePersonnel;
import service.ServiceVisiteur;
import model.Client;
import model.Personnel;
import model.Visiteur;

/**
 *
 * @author oumaima
 */
public class test {
      public static void main(String[] args) {
Personnel p2= new Personnel("bib", 120355655, "oumaima", "mejri", "mejrioumaima@gmail.com", "oumaima", "oumaima", "biblio", "c");
Personnel p1= new Personnel("biblio", 1203655, "oumaima", "mejri", "oumaao@gmail.com", "oumaima", "oumaima", "bib", "b");
Visiteur v= new Visiteur(126, "oumaima visiteur", "mejri", "oumaao@gmail.com", "oumaima", "oumaima", "bib", "client");
Client c= new Client(8, "ouma", "mejri", "oumaao@gmail.com", "oumiiaima", "mejri", "bjib", "client");
Visiteur v1= new Visiteur(82229, "ouma", "mejri", "oumaao@gmail.com", "oumiiaima", "mejri", "bjib", "client");

ServiceClient serviceclient=new ServiceClient();
//ServicePersonnel ers= new ServicePersonnel();
//ers.modifierPersonnel(p1, "bib");
ServiceVisiteur serv=new ServiceVisiteur(); 

 //serv.ajouterCom(v);
//serviceclient.supprimerClient(c);
serviceclient.modifierClient(c, 77);
     //  serviceclient.consulterClient();
//serviceclient.supprimerClient(c);

 //service.consulterPersonnel();
   // serviceclient.consulterClient();
}
}
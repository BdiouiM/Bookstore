package bookstore.fx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DetailsLivreController {

    @FXML
    private Label labelTitre;

    @FXML
    private Button mesRec;

    @FXML
    private Label labelPrix;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button stats;

    @FXML
    private Label labelnbrPages;

    @FXML
    private Label labelGenre;

    @FXML
    private Label labelAuteur;

    @FXML
    private Label username;
    
    public void setDetails(String s1,String s2,String s3,String s4,String s5)
    {
    	this.labelGenre.setText(s1);
    	this.labelTitre.setText(s2);
    	this.labelAuteur.setText(s3);
    	this.labelPrix.setText(s4);
    	this.labelnbrPages.setText(s5);
    }

    @FXML
    void MesLivres(ActionEvent event) {
    	 try {
             String user=username.getText();

             FXMLLoader loader=new FXMLLoader(getClass().getResource("MesLivresClient.fxml"));
              Parent root1=(Parent) loader.load();
              MesLivresClientController rc = loader.getController();
              rc.setUsername(user);
              Stage stage=new Stage();
              stage.setScene(new Scene(root1));
              stage.show();
         } catch (IOException ex) {
             System.err.println(ex);
         }
         
    }
   
    @FXML
    void voirStat(ActionEvent event) {
    	 try {

             FXMLLoader loader=new FXMLLoader(getClass().getResource("barchart.fxml"));
              Parent root1=(Parent) loader.load();
             barchartController rc = loader.getController();
             
              Stage stage=new Stage();
              stage.setScene(new Scene(root1));
              stage.show();
         } catch (IOException ex) {
             System.err.println(ex);
         }
    }
    public void setUsername(String user) {
	      this.labelGenre.setText(user);
	}
    
    public void setLabelAuteur(String auteur) {
		this.labelAuteur.setText(auteur);
	}
    
    public void setLabelGenre(String genre) {
		this.labelGenre.setText(genre);
	}
    public void setLabelnbrPages(String nbr) {
		this.labelnbrPages.setText(nbr);
	}
    public void setLabelPrix(String prix) {
		this.labelPrix.setText(prix);
	}
   public void setLabelTitre(String titre) {
	this.labelTitre.setText(titre); 
			}
}

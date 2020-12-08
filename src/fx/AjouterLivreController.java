package fx;

import java.io.IOException;

import book_store.service.ServiceBook;
import bookstore.model.Book;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AjouterLivreController {

    @FXML
    private TextField labelTitre;

    @FXML
    private Button mesRec;

    @FXML
    private TextField labelPrix;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField labelnbrPages;

    @FXML
    private TextField labelGenre;

    @FXML
    private TextField labelAuteur;

    
    @FXML
    private Label username;

    @FXML
    void MesLivres(ActionEvent event) {
    	 try {
             String user=username.getText();

             FXMLLoader loader=new FXMLLoader(getClass().getResource("MesLivresAdmin.fxml"));
              Parent root1=(Parent) loader.load();
              MesLivresAdminController rc = loader.getController();
              rc.setUsername(user);
              Stage stage=new Stage();
              stage.setScene(new Scene(root1));
              stage.show();
         } catch (IOException ex) {
             System.err.println(ex);
         }
         
    }

    @FXML
    void Ajouter(ActionEvent event) {
    	ServiceBook sb =new ServiceBook();
		Book b = new Book();
		b.setGenre(labelGenre.getText());
		b.setTitre(labelTitre.getText());
		b.setAuteur(labelAuteur.getText());
		b.setPrix(labelPrix.getAnchor());
		b.setNbrPages(labelnbrPages.getAnchor());
		sb.ajouterBook(b);
    }

	public void setUsername(String user) {
	      this.username.setText(user);
	}
	

}

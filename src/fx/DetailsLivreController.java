package fx;

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
    private TextField labelTitre;

    @FXML
    private Button mesRec;

    @FXML
    private TextField labelPrix;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button stats;

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

}

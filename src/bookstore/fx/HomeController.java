/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HomeController implements Initializable {
    @FXML
    private HBox parentChildren;
    @FXML
    private Button inscrit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*long endTime = 5;
        
        DateFormat timeFormat = new SimpleDateFormat( "HH:mm:ss" );
        final Timeline timeline = new Timeline(
        new KeyFrame(
        Duration.millis( 500 ),
        event -> {
        final long diff = endTime - System.currentTimeMillis();
        if ( diff < 0 ) {
        //  timeLabel.setText( "00:00:00" );
        this.inscrit.setText( timeFormat.format( 0 ) );
        } else {
        this.inscrit.setText( timeFormat.format( diff ) );
        }
        }
        )
        );
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.play();*/
    }    

    @FXML
    private void authentification(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("Authentification.fxml"));
            loadPage(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadPage(Parent root){
        parentChildren.getChildren().removeAll();
        parentChildren.getChildren().setAll(root);
    }

    @FXML
    private void visiteur(ActionEvent event) throws IOException {
          FXMLLoader loader=new FXMLLoader(getClass().getResource("Visiteur.fxml"));
             
             Parent root1=(Parent) loader.load();
          
             Stage stage=new Stage();
             stage.setScene(new Scene(root1));
             stage.show();
    }
          
    
}

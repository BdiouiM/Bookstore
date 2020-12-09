/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoree;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class IU_ClivraisonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    private void afficherMap(ActionEvent event) {
        try{
       // create web engine and view
        Stage stage = new Stage();
        
            
            // set title for the stage 
            stage.setTitle("creating Webview"); 
   
            // create a webview object 
            WebView w = new WebView(); 
   
            // get the web engine 
            WebEngine e = w.getEngine(); 
   
            // load a website 
            e.load("https://www.google.com/maps"); 
   
            // create a scene 
            Scene scene = new Scene(w, w.getPrefWidth(),  
                                     w.getPrefHeight()); 
   
            // set the scene 
            stage.setScene(scene); 
   
            stage.show(); 
        }catch(Exception e ){
        System.out.println(e.getMessage());
        }
        } 
   
    
    
}

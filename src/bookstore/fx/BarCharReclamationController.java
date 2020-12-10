/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Reclamation;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class BarCharReclamationController implements Initializable {
    @FXML
    private Label username;
    @FXML
    private BarChart<?, ?> barchart;
    @FXML
    private NumberAxis Y;
    @FXML
    private CategoryAxis X;
    @FXML
    private AnchorPane parentChildren;

  @SuppressWarnings("unchecked")
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
        
       
		try {
			 XYChart.Series reclamation = new XYChart.Series<>();
		        bookstoreConnexion cnx = bookstoreConnexion.getIstance();
		        String req ="select * from reclamation ";
		        Statement s;
	         	s = cnx.getConnection().createStatement();	
                      ResultSet rs = s.executeQuery(req);
        
        while(rs.next()){
            Reclamation b = new Reclamation();

           String user = rs.getString("UsernameClient");
            String statut = rs.getString("StatutReclamation");
            float number=0.0f;
            if(statut.equals("en cours.."))number=0;
            else if(statut.equals("annulée..")) number=1;
             else number=2;
            reclamation.getData().add(new XYChart.Data(user,number));

        }
       
         barchart.getData().addAll(reclamation);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
     Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Statistiques");
         a.setHeaderText("Statistique selon le statut");
          a.setContentText("3 types de statut");
          a.showAndWait();
	}
         public void setUsername(String username)
    {
        this.username.setText(username);
        this.username.setText(username);
    }
        
}
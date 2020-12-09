package fx;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import book_store.My_connexion;
import bookstore.model.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class barchartController implements Initializable {

    @FXML
    private BarChart<?, ?> BookChart;

    @FXML
    private CategoryAxis X;

    @FXML
    private NumberAxis Y;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
        
       
		try {
			 XYChart.Series livre = new XYChart.Series<>();
		        My_connexion cnx = My_connexion.getIstance();
		        String req ="select * from livre ";
		        Statement s;
		s = cnx.getConnection().createStatement();	
        ResultSet rs = s.executeQuery(req);
        
        while(rs.next()){
            Book b = new Book();

           String titre = rs.getString("Titre");
            int quantite = rs.getInt("Quantite");
            livre.getData().add(new XYChart.Data(titre,quantite));

        }
       
         BookChart.getData().addAll(livre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

	}
}

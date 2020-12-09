package fx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import book_store.service.ServiceBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import bookstore.model.Book;


public class StatsController implements Initializable {


	 @FXML
	    private Pane paneView;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		loadData();
	}

	private void loadData() {
		 ObservableList<PieChart.Data> list =FXCollections.observableArrayList();

		    paneView.getChildren().clear();
	        /*list.add(new PieChart.Data("Grapefruit", 300));
	        list.add( new PieChart.Data("Oranges", 250));
	        list.add( new PieChart.Data("Plums", 200));
	        list.add( new PieChart.Data("Pears", 220));
	        list.add(new PieChart.Data("Apples", 300));
	        System.out.println(list);*/
	         //PieChart chart = new PieChart(list);	
	         //chart.setTitle("pieChart");
	         //paneView.getChildren().add(chart);
	}
  
}

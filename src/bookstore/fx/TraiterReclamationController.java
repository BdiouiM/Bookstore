 package bookstore.fx;

import bookstore.connexion.bookstoreConnexion;
import bookstore.exception.ReclamationExisteException;
import bookstore.model.Reclamation;
import bookstore.service.ServiceAdmin;
import bookstore.service.ServiceClient;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import sun.plugin2.jvm.RemoteJVMLauncher;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TraiterReclamationController implements Initializable {
    @FXML
    private TableView<Reclamation> tableR;
    @FXML
    private TableColumn<Reclamation, String> tableID;
    @FXML
    private TableColumn<Reclamation, String> tableUser;
    @FXML
    private TableColumn<Reclamation, String>tableDate;
    @FXML
    private TableColumn<Reclamation, String>tableType;
    @FXML
    private TableColumn<Reclamation, String> tableStatut;
    @FXML
    private TableColumn<Reclamation, String> tableDescription;

    ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();
    
    @FXML
    private Text nbrR;
    @FXML
    private Label user;
    @FXML
    private TextField chercher;
    @FXML
    private AnchorPane parentChildren;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           InitColumn();
           reclamations=loadData(reclamations);
           //ajouter buton annuler
           addAnnulerToTableView();
           //ajouter buton valider
           addValiderToTableView();
          
           //nombre reclamations
           ServiceAdmin sa = new ServiceAdmin();
           int nombre =sa.NombreReclamations();
           nbrR.setText(String.valueOf(nombre));
           System.out.println(nbrR);
           //Observable in FilteredList
           FilteredList<Reclamation> filteredList= new FilteredList<Reclamation>(reclamations,b->true);
           //Set Filter predicate
           chercher.textProperty().addListener((reclamations,oldValue,newValue)->{
                filteredList.setPredicate((Reclamation reclamation) -> {
                    //si textField est vide afficher all
                    if (newValue==null||newValue.isEmpty())
                        return true;
                    //comparer username to textField
                    String lowerCase = newValue.toLowerCase();
                    if(reclamation.getClientUsername().toLowerCase().indexOf(lowerCase)!= -1)
                        return true; //filter match usernameClient
                    else {
                        return false;}//doesn't match
                });
                  
            });
           //Filtered List in Sorted List
           SortedList<Reclamation> sortedList= new SortedList<>(filteredList);
           sortedList.comparatorProperty().bind(tableR.comparatorProperty());
           //ajouter items dans le tableau
           tableR.setItems(sortedList);
          
           
    }   
    
    public void setUsername(String username)
    {
        this.user.setText(username);
    }
    
    public void InitColumn(){
           tableUser.setCellValueFactory(new PropertyValueFactory<>("ClientUsername"));
           tableDate.setCellValueFactory(new PropertyValueFactory<>("DateReclamation"));
           tableType.setCellValueFactory(new PropertyValueFactory<>("Type"));
           tableStatut.setCellValueFactory(new PropertyValueFactory<>("StatutReclamation"));
           tableDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
           tableID.setCellValueFactory(new PropertyValueFactory<>("Identifiant"));
           
    }
    public ObservableList<Reclamation> loadData(ObservableList<Reclamation> reclamations){
        try{
               bookstoreConnexion cnx=bookstoreConnexion.getIstance();
               String req ="select * from reclamation";
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   Reclamation r = new Reclamation();
                   r.setClientUsername(rs.getString("UsernameClient"));
                   r.setType(rs.getString("Type"));
                   r.setDateReclamation(rs.getString("DateReclamation"));
                   r.setStatutReclamation(rs.getString("StatutReclamation"));
                   r.setDescription(rs.getString("Description"));
                   r.setIdentifiant(rs.getInt("Identifiant"));
                   
                   reclamations.add(r);
               }
           }
           catch(Exception e){
               
           }
        return reclamations;
    }
    public void addAnnulerToTableView(){
        
        TableColumn<Reclamation, Void> tableAnnuler = new TableColumn("Annuler");
        Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>> cellFactory = new Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>>() {
            @Override
            public TableCell<Reclamation, Void> call(final TableColumn<Reclamation, Void> param) {
                final TableCell<Reclamation, Void> cell = new TableCell<Reclamation, Void>() {

                    String cssButton="-fx-cursor:  hand;\n" +
                    "    -fx-border-color: #ffa500;\n" +
                    "    -fx-border-width: 3px;\n" +
                    "    -fx-border-radius: 20px;\n" +
                    "    -fx-background-color:  #FFF;\n" +
                    "    -fx-text-fill:#ffa500;\n" +
                    "    -fx-font-veigth:bold ;"
                            + "";
                   private final    Button btn = new Button("Annuler");
                    {
                        
                        
                        btn.setOnAction((ActionEvent event) -> {
                             String cu = getTableView().getItems().get(getIndex()).getClientUsername();
                             String d = getTableView().getItems().get(getIndex()).getDateReclamation();
                             String t = getTableView().getItems().get(getIndex()).getType();
                               int i = getTableView().getItems().get(getIndex()).getIdentifiant();
                            Reclamation r = new Reclamation();
                            System.out.println("selected Reclamation : " + i);
                            r.setClientUsername(cu);
                            r.setDateReclamation(d);
                            r.setType(t);
                            r.setIdentifiant(i);
                            annulerButton(r);
                        });
                    }
                    {
                        this.btn.setStyle(cssButton);
                    }
                   
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
       tableAnnuler.setCellFactory(cellFactory);
       tableR.getColumns().add(tableAnnuler);
         
    }
    public void annulerButton(Reclamation r){
      
                 try {
            System.out.println("reclamation test");
            ServiceAdmin sa=new ServiceAdmin();
                     System.out.println("id :"+r.getIdentifiant());
            
            sa.annulerReclamation(r);
        } catch (ReclamationExisteException ex) {
            System.err.println("erreur dans l'annulation:  "+ex);      
        }
          
         
        
       
    }
      public void addValiderToTableView(){
        
        TableColumn<Reclamation, Void> tableAnnuler = new TableColumn("Valider");
        Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>> cellFactory = new Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>>() {
            @Override
            public TableCell<Reclamation, Void> call(final TableColumn<Reclamation, Void> param) {
                final TableCell<Reclamation, Void> cell = new TableCell<Reclamation, Void>() {
                    
                    String cssButton="-fx-cursor:  hand;\n" +
                    "    -fx-border-color: #ffa500;\n" +
                    "    -fx-border-width: 3px;\n" +
                    "    -fx-border-radius: 20px;\n" +
                    "    -fx-background-color:  #FFF;\n" +
                    "    -fx-text-fill:#ffa500;\n" +
                    "    -fx-font-veigth:bold ;"
                            + "";

                  private final Button btn = new Button("valider");

                    {
                        
                        
                        btn.setOnAction((ActionEvent event) -> {
                            String cu = getTableView().getItems().get(getIndex()).getClientUsername();
                             String d = getTableView().getItems().get(getIndex()).getDateReclamation();
                              String t = getTableView().getItems().get(getIndex()).getType();
                               int i = getTableView().getItems().get(getIndex()).getIdentifiant();
                            Reclamation r = new Reclamation();
                            System.out.println("selected Reclamation : " + cu);
                            r.setClientUsername(cu);
                            r.setDateReclamation(d);
                            r.setType(t);
                            r.setIdentifiant(i);
                            validerButton(r);
                        });
                    }
                    {
                        this.btn.setStyle(cssButton);
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
       tableAnnuler.setCellFactory(cellFactory);
       tableR.getColumns().add(tableAnnuler);
         
    }
     public void validerButton(Reclamation r){
             try {
            System.out.println("test");
            ServiceAdmin sa=new ServiceAdmin();
                 System.out.println(r.getIdentifiant());
            sa.validerReclamations(r);
            sa.SendSMS();
        } catch (ReclamationExisteException ex) {
            System.err.println("erreur dans la validation");      
        }  
    }
      public void alertUsername(ActionEvent event,String username)
    {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Reclamation");
         a.setHeaderText("Reclamation n'existe pas");
          a.setContentText(username+"  n'a pas envoyé une réclamation");
          a.showAndWait();
    }
      public void loadPage(Parent root){
       parentChildren.getChildren().removeAll();
       parentChildren.getChildren().setAll(root);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.fx;

import bookstore.connexion.bookstoreConnexion;
import bookstore.model.Echange;
import bookstore.service.ServiceAdmin;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author mega pc
 */
public class EchangeAdminController implements Initializable {

    @FXML
    private Text nbrR;
    @FXML
    private TableView<Echange> tableR;
    @FXML
    private TableColumn<Echange, String> tableIdentifiantechange;
    @FXML
    private TableColumn<Echange, String> tableCIN1;
    @FXML
    private TableColumn<Echange, String> tableCIN2;
    @FXML
    private TableColumn<Echange, String> tableTitre1;
    @FXML
    private TableColumn<Echange, String> tableTitre2;
    @FXML
    private TableColumn<Echange, String> tableStatutEchange;
    ObservableList<Echange> echanges = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        InitColumn();
           echanges=loadData(echanges);
           //ajouter buton annuler
           addAnnulerToTableView();
          //ajouter buton valider
           addValiderToTableView();
          //ajouter items dans le tableau
           tableR.setItems(echanges);
           //nombre reclamations
          ServiceAdmin sa = new ServiceAdmin();
           int nombre =sa.NombreEchanges();
           nbrR.setText(String.valueOf(nombre));
           System.out.println(nbrR);
        
    }

public void InitColumn(){
           tableIdentifiantechange.setCellValueFactory(new PropertyValueFactory<>("Identifiantechange"));
           tableCIN1.setCellValueFactory(new PropertyValueFactory<>("CIN1"));
           tableCIN1.setCellValueFactory(new PropertyValueFactory<>("CIN2"));
           tableTitre1.setCellValueFactory(new PropertyValueFactory<>("Titre1"));
           tableTitre2.setCellValueFactory(new PropertyValueFactory<>("Titre2"));
           tableStatutEchange.setCellValueFactory(new PropertyValueFactory<>("StatutEchange"));
           
    }   

public ObservableList<Echange> loadData(ObservableList<Echange> echanges){
        try{
               bookstoreConnexion cnx=bookstoreConnexion.getIstance();
               String req ="select * from echange";
               Statement s= cnx.getConnection().createStatement();
               ResultSet rs = s.executeQuery(req);
               while(rs.next()){
                   Echange r = new Echange();
                   r.setIdentifiantechange(rs.getString("Identifiantechange"));
                   r.setCIN1(rs.getString("CIN1"));
                   r.setCIN2(rs.getString("CIN2"));
                   r.setTitre1(rs.getString("Titre1"));
                   r.setTitre2(rs.getString("Titre2"));
                   r.setStatutEchange(rs.getString("StatutEchange"));
                   
                  /* Button annulerB= new Button("annuler"); 
                   r.setAnnuler(annulerB);
                   Button validerB= new Button("valider");
                   r.setValider(validerB);*/
                
                   echanges.add(r);
               }
           }
           catch(Exception e){
               
           }
        return echanges;
    }


public void addAnnulerToTableView(){
        
        TableColumn<Echange, Void> tableAnnuler = new TableColumn("Annuler");
        Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>> cellFactory = new Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>>() {
            @Override
            public TableCell<Echange, Void> call(final TableColumn<Echange, Void> param) {
                final TableCell<Echange, Void> cell = new TableCell<Echange, Void>() {

                    private final Button btn = new Button("annuler");

                    {
                        
                        
                        btn.setOnAction((ActionEvent event) -> {
                            String cu = getTableView().getItems().get(getIndex()).getIdentifiantechange();
                             String d = getTableView().getItems().get(getIndex()).getCIN1();
                              String t = getTableView().getItems().get(getIndex()).getCIN2();
                              String y = getTableView().getItems().get(getIndex()).getTitre1();
                              String z = getTableView().getItems().get(getIndex()).getTitre2();
                              String x = getTableView().getItems().get(getIndex()).getStatutEchange();
                              
                            Echange e = new Echange();
                            System.out.println("selected Reclamation : " + cu);
                            e.setIdentifiantechange(cu);
                            e.setCIN1(d);
                            e.setCIN2(t);
                            e.setTitre1(y);
                            e.setTitre2(z);
                            e.setStatutEchange(x);
                            annulerButton(e);
                        });
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
    public void annulerButton(Echange e){
      
                 try {
            System.out.println("reclamation test");
            ServiceAdmin sa=new ServiceAdmin();
                   //  System.out.println("id :"+r.getIdentifiant());
            
            sa.annulerEchange(e);
        } catch (Exception ex) {
            System.err.println("erreur dans l'annulation:  "+ex);      
        }
          
         
        
       
    }
    
    
    public void addValiderToTableView(){
        
       TableColumn<Echange, Void> tableAnnuler = new TableColumn("Valider");
        Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>> cellFactory = new Callback<TableColumn<Echange, Void>, TableCell<Echange, Void>>() {
            @Override
            public TableCell<Echange, Void> call(final TableColumn<Echange, Void> param) {
                final TableCell<Echange, Void> cell = new TableCell<Echange, Void>() {

                    private final Button btn = new Button("valider");

                    {
                        
                        
                        btn.setOnAction((ActionEvent event) -> {
                            String cu = getTableView().getItems().get(getIndex()).getIdentifiantechange();
                             String d = getTableView().getItems().get(getIndex()).getCIN1();
                              String t = getTableView().getItems().get(getIndex()).getCIN2();
                              String y = getTableView().getItems().get(getIndex()).getTitre1();
                              String z = getTableView().getItems().get(getIndex()).getTitre2();
                              String x = getTableView().getItems().get(getIndex()).getStatutEchange();
                              
                            Echange e = new Echange();
                            System.out.println("selected echange : " + cu);
                            e.setIdentifiantechange(cu);
                            e.setCIN1(d);
                            e.setCIN2(t);
                            e.setTitre1(y);
                            e.setTitre2(z);
                            e.setStatutEchange(x);
                            validerEchange(e);
                        });
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
        };
      public void validerEchange(Echange e){
      
                 try {
            System.out.println("echange test");
            ServiceAdmin sa=new ServiceAdmin();
                   //  System.out.println("id :"+r.getIdentifiant());
            
            sa.validerEchange(e);
            sa.SendEmail();
        } catch (Exception ex) {
            System.err.println("erreur dans la validation  "+ex);      
        }
          
         
        
       
    }
    
         
    }



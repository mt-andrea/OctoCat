/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package octocat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import panel.Panel;

/**
 *
 * @author Miu
 */


public class FXMLDocumentController implements Initializable {
    DB ab= new DB();
    @FXML
    private Button btnNemTudtam;
    @FXML
    private Button btnTudtam;
    @FXML
    private Label lblAlso;
    @FXML
    private Label lblFelso;
    @FXML
    private Label lblHanyvan;
    @FXML
    private TableColumn<Szo, String> oIdegenNyelv;
    @FXML
    private TableColumn<Szo, String> oIdegenSzo;
    @FXML
    private TableColumn<Szo, String> oLecke;
    @FXML
    private TableColumn<Szo, String> oMagyar;
    @FXML
    private Tab tabSzotar;
    @FXML
    private TableView<Szo> tblSzavak;
    @FXML
    private TextField txtIdegenNyelv;
    @FXML
    private TextField txtIdegenNyelvSzuro;
    @FXML
    private TextField txtIdegenSzo;
    @FXML
    private TextField txtIdegenSzoSzuro;
    @FXML
    private TextField txtLecke;
    @FXML
    private TextField txtLeckeSzuro;
    @FXML
    private TextField txtMagyar;
    @FXML
    private TextField txtMagyarSzuro;

    @FXML
    void hozzaad() {

    }

    @FXML
    void modosit() {

    }

    @FXML
    void mutat() {

    }

    @FXML
    void nem_tudtam() {

    }

    @FXML
    void szuro_torol() {
        txtIdegenNyelvSzuro.clear();
        txtIdegenSzoSzuro.clear();
        txtLeckeSzuro.clear();
        txtMagyarSzuro.clear();
        tblSzavak.requestFocus();
    }

    @FXML
    void torol() {

    }

    @FXML
    void tudtam() {

    }

    @FXML
    void uj() {
        txtIdegenNyelv.clear();
        txtIdegenSzo.clear();
        txtLecke.clear();
        txtMagyar.clear();
        txtLecke.reguestFocus();
        tblSzavak.getSelectionModel().select(null);
    }
    private void beolvas(){
        String szuro1 = "'%" + txtLeckeSzuro.getText() + "%'";
        String szuro2 = "'%" + txtIdegenSzoSzuro.getText() + "%'";
        String szuro3 = "'%" + txtMagyarSzuro.getText() + "%'";
        String szuro4 = "'%" + txtIdegenNyelvSzuro.getText() + "%'";
        String s = "SELECT * FROM szavak"
                 + "WHERE lecke LIKE" + szuro1
                 + "AND idegenszo LIKE" + szuro2
                 + "AND magyar LIKE" + szuro3
                 + "AND idegenNyelv LIKE" + szuro4
                 + "ORDER BY idegenszo;";
        ab.beolvas(tblSzavak.getItems(), s );
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        beolvas();   
        oLecke.setCellValueFactory(new PropertyValueFactory<>("lecke"));
        oIdegenNyelv.setCellValueFactory(new PropertyValueFactory<>("idegenNyelv"));
        oMagyar.setCellValueFactory(new PropertyValueFactory<>("magyar"));
        oIdegenSzo.setCellValueFactory(new PropertyValueFactory<>("idegenSzo"));
         txtIdegenNyelvSzuro.textProperty().addListener((ObservableValue Observable, String regiAdat, String uj_adat) -> beolvas());
        txtIdegenSzoSzuro.textProperty().addListener((ObservableValue Observable, String regiAdat, String uj_adat) -> beolvas());
        txtLeckeSzuro.textProperty().addListener((ObservableValue Observable, String regiAdat, String uj_adat) -> beolvas());
        txtMagyarSzuro.textProperty().addListener((ObservableValue Observable, String regiAdat, String uj_adat) -> beolvas());
    }    
    
}

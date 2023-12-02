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
    private java.awt.TextField txtIdegenNyelv;
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
        String lecke = txtLecke.getText();
        if (lecke.length() < 1 || lecke.length() > 10) {
            hiba ("Hiba!", "A lecke hossza 1-10 karakter lehet!");
            txtLecke.requestFocus();
            return;
        }
        String IdegenNyelv = txtIdegenNyelv.getText();
        if (IdegenNyelv.length() < 1 || IdegenNyelv.length() > 10) {
            hiba ("Hiba!", "Az IdegenNyelv hossza 1-10 karakter lehet!");
            txtIdegenNyelv.requestFocus();
            return;
        }   
            
        String IdegenSzo = txtIdegenSzo.getText();
        if (IdegenSzo.length() < 1 || IdegenSzo.length() > 60) {
            hiba ("Hiba!", "Az IdegenSzo hossza 1-60 karakter lehet!");
            txtIdegenSzo.requestFocus();
            return;
        }   
        String Magyar = txtMagyar.getText();  
         if (Magyar.length() < 1 || Magyar.length() > 60) {
            hiba ("Hiba!", "A Magyar hossza 1-60 karakter lehet!");
            txtMagyar.requestFocus();
            return;
        }   
    int sor = ab.hozzaad (lecke, IdegenNyelv, IdegenSzo, Magyar);
    if (sor > 0) {
    beolvas ();
    uj ();
    }
}

    @FXML
    void modosit() {
        int index = tblSzavak.getSelectionModel () .getSelectedIndex ();
        if (index == -1)
            return;
        int id = tblSzavak.getItems (). get (index) .getSzoID ();

        String lecke = txtLecke.getText ();
        if (lecke.length () < 1 || lecke.length () > 10) {
            hiba ("Hiba!", "A lecke hossza 1-10 karakter lehet!");
            txtLecke.requestFocus ();
            return;
        }
        String IdegenNyelv = txtIdegenNyelv.getText ();
        if (IdegnNyelv.length () < 1 || IdegenNyelv.length () > 10) {
            hiba ("Hiba!", "Az IdegenNyelv hossza 1-10 karakter lehet!");
            txtIdegenNyelv.requestFocus ();
            return;
        }
        String IdegenSzo = txtIdegenSzo.getText ();
        if (IdegnNSzo.length () < 1 || IdegenSzo.length () > 60) {
            hiba ("Hiba!", "Az IdegenSzó hossza 1-60 karakter lehet!");
            txtIdegenSzo.requestFocus ();
            return;
        }
        
        String Magyar = txtMagyar.getText ();
        if (lecke.Magyar () < 1 || Magyar.length () > 60) {
            hiba ("Hiba!", "A Magyar hossza 1-10 karakter lehet!");
            txtMagyar.requestFocus ();
            return;
        }

    int sor = ab.modosit(id, lecke, IdegenNyelv, IdegenSzo, Magyar);
    if (sor > 0) {
        beolvas ();
        for (int i = 0; i < tblSzavak.getItems (). size (); i++) {
            if (tblSzavak.getItems().get (i).getSzoID () == id){
                tblSzavak.getSelectionModel ().select (i);
                break;
            }
        }
    }
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
    void tablabol(int sorIndex){
        if (sorIndex!=-1) {
            Szo szo = tblSzavak.getItems().get(sorIndex);
            txtIdegenNyelv.setText(""+szo.getIdegenNyelv());
            txtIdegenSzo.setText(""+szo.getIdegenSzo());
            txtLecke.setText(""+szo.getLecke());
            txtMagyar.setText(""+szo.getMagyar());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {beolvas();   
        oLecke.setCellValueFactory(new PropertyValueFactory<>("lecke"));
        oIdegenNyelv.setCellValueFactory(new PropertyValueFactory<>("idegenNyelv"));
        oMagyar.setCellValueFactory(new PropertyValueFactory<>("magyar"));
        oIdegenSzo.setCellValueFactory(new PropertyValueFactory<>("idegenSzo"));
         txtIdegenNyelvSzuro.textProperty().addListener((ObservableValue Observable, String regiAdat, String uj_adat) -> beolvas());
        txtIdegenSzoSzuro.textProperty().addListener((ObservableValue Observable, String regiAdat, String uj_adat) -> beolvas());
        txtLeckeSzuro.textProperty().addListener((ObservableValue Observable, String regiAdat, String uj_adat) -> beolvas());
        txtMagyarSzuro.textProperty().addListener((ObservableValue Observable, String regiAdat, String uj_adat) -> beolvas());
        tblSzavak.getSelectionModel().selectedIndexProperty().addListener(
            (o,regi,uj) -> tablabol(uj.intValue())
        );
    }    
    
}

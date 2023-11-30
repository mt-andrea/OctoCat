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

/**
 *
 * @author Miu
 */


public class FXMLDocumentController implements Initializable {

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

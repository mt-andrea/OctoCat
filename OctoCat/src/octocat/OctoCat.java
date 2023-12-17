/*Made by Andrea Mate, Katalin Andorfer, András Spengler, Bezdán Anita, Kalmár János, Tamás Nagy
* For practice.
This is the way! */

package octocat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author $Mate Andrea, Andorfer Katalin, András Spengler, Bezdán Anita, Kalmár János, Tamás Nagy
 */
public class OctoCat extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("OctoCat szótár");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
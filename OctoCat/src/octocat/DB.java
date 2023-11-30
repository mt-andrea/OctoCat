/**
 *
 * @author Kalmár János
 */
package octocat;

import java.sql.connction;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import panel.Panel;



/**
 *
 * @author Kalmár János
 */
public class DB {
    
    final String url = "";
    final String felhasznalo = "";
    final String jelszo = "";
    
    public void beolvas(ObservableList<Szo> tabla, String szoveg){
        try (Connection kapcsolat = DriverManager.getConnection(url,felhasznalo,jelszo)){
            
        } catch (SQLException hiba) {
            
        }
    }
    
}

/**
 *
 * @author Kalmár János
 */
package octocat;

import java.sql.Connection;
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
    
    final String url = "jdbc:mysql://localhost:3306/szotar?useUnicode=true&characterEncoding=UTF-8";
    final String felhasznalo = "root";
    final String jelszo = "";

    public int torol(int szoId){
        String sql = "DELETE FROM szavak WHERE szoID=?;";
        try (Connection kapcs = DriverManager.getConnection(url, felhasznalo, jelszo);
                PreparedStatement ekp = kapcs.prepareStatement(sql)){
            
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void beolvas(ObservableList<Szo> tabla, String szoveg){
        try (Connection kapcsolat = DriverManager.getConnection(url,felhasznalo,jelszo);
            PreparedStatement ekp = kapcsolat.prepareStatement (szoveg)){
            tabla.clear();
            ResultSet eredmeny = ekp.executeQuery();
            while (eredmeny.next()){
                tabla.add(
                        new Szo(
                                eredmeny.getInt("SzoID"),
                                eredmeny.getString("Lecke"),
                                eredmeny.getString("IdegenSzo"),
                                eredmeny.getString("IdegenNyelv"),
                                eredmeny.getString("Magyar")));
            }
        } catch (SQLException hiba) {
            Panel.hiba("Hiba",hiba.getMessage());
            Platform.exit();
        }
    }
    
}

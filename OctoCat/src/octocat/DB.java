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
    public int hozzaad (String lecke, String IdegenSzo, String IdegenNyelv, String Magyar){
        String s ="INSERT INTO szavak (lecke, IdegenNyelv, IgegenSzo, Magyar)"
                + "VALUES (?, ?, ?, ?)";
        try (Connection kapcs = DriverManager.getConnection (db, user, pass);
             PreparedStatement ekp = kapcs.prepareStatement (s)) {
           ekp.setString (1, lecke);
           ekp.setString (2, IdegenNyelv);
           ekp.setString (3, IdegenSzo);
           ekp.setString (4 , Magyar);
           return ekp.executeUpdate();
        }
           catch (SQLException ex){
             hiba ("Hozzáadás", ex.getMessage());
               return 0;
           }
    }
    
    public int modosit (int id, String lecke, String IdegenNyelv, String IegenSzo, String Magyar) {
        String s = "UPDATE szavak SET lecke= ?, IdegenNyelv=?, IdegenSzo=?, Magyar=? "
                 + "WHERE szID=?";
        try (Connection kapcs = DriverManager.getConnection (db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement (s)) {
            ekp.setString (1, lecke);
            ekp.setString (2, IdegenNyelv);
            ekp.setString (3, IdegenSzo);
            ekp.setString (4, Magyar);
            ekp. setInt (5, id);
            return ekp.executeUpdate ();
        } catch (SQLException ex) {
            hiba ("Modósítás", ex.getMessage());
            return 0;
        }
    }
}

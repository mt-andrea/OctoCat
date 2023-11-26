package panel;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

/**
 * Párbeszédpanelek
 * @author Tóth József
 */
public class Panel {

    /**
     * Hibaüzenet megjelenítése párbeszédpanelen
     * @param cim: a panel címe
     * @param uzenet: a panelen megjelenő üzenet 
     */
    public static void hiba(String cim, String uzenet) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(cim);
        alert.setHeaderText(null);
        alert.setContentText(uzenet);
        alert.showAndWait();
    }

    /**
     * Megerősítés kérése igen/nem párbeszédpanelen
     * @param cim: a panel címe
     * @param uzenet: a panelen megjelenő üzenet
     * @return: true, ha az Igen gombot választották,
     *          egyébként false
     */
    public static boolean igennem(String cim, String uzenet) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(cim);
        alert.setHeaderText(null);
        alert.setContentText(uzenet);
        ButtonType btIgen = new ButtonType("Igen",ButtonData.YES);
        ButtonType btNem = new ButtonType("Nem",ButtonData.NO);
        alert.getButtonTypes().setAll(btIgen, btNem);
        return alert.showAndWait().get() == btIgen;
    }

}

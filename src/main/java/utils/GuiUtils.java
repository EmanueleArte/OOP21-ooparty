package utils;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import utils.enums.PlayerColor;

/**
 * This class provides spinner utilities.
 */
public final class GuiUtils {

    private GuiUtils() {
    }

    /**
     * This method sets the value factory for a generic number spinner.
     * 
     * @param spinner the spinner to be set
     * @param min     the min value
     * @param max     the max value
     */
    public static void setSpinnerControls(final Spinner<Integer> spinner, final int min, final int max) {
        spinner.setValueFactory(new IntSpinnerValueFactory(min, max, min));
    }

    /**
     * This method fills the the combo box with colors which can be choose.
     * 
     * @param playerColors the list of combo boxes
     */
    public static void fillColorsBoxes(final List<ComboBox<PlayerColor>> playerColors) {
        playerColors.forEach(colors -> {
            colors.setItems(FXCollections.observableArrayList(PlayerColor.values()));
            colors.getSelectionModel().selectFirst();
        });
    }

}

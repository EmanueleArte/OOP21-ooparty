package utils;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
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

    /**
     * This method shows a player form.
     * 
     * @param form the player form
     */
    public static void showForm(final VBox form) {
        form.setVisible(true);
        form.setManaged(true);
    }

    /**
     * This method hides a player form.
     * 
     * @param form the player form
     */
    public static void hideForm(final VBox form) {
        form.setVisible(false);
        form.setManaged(false);
    }

    /**
     * This method resets a shape position.
     * 
     * @param shape the shape to reposition
     * @param x     the starting X
     * @param y     the starting Y
     */
    public static void resetPosition(final Shape shape, final double x, final double y) {
        shape.setTranslateX(x);
        shape.setTranslateY(y);
    }

    /**
     * This method hides a button.
     * 
     * @param button the button to hide
     */
    public static void hideButton(final Button button) {
        button.setVisible(false);
        button.setManaged(false);
    }

    /**
     * This method shows a button.
     * 
     * @param button the button to show
     */
    public static void showButton(final Button button) {
        button.setVisible(true);
        button.setManaged(true);
    }

}

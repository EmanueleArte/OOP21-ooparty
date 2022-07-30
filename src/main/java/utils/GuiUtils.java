package utils;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import utils.enums.PlayerColor;

/**
 * This class provides gui utilities.
 */
public final class GuiUtils {

    private GuiUtils() {
    }

    /**
     * This method sets the value factory for a generic number {@link Spinner}.
     * 
     * @param spinner the spinner to be set
     * @param min     the minimum value
     * @param max     the maximum value
     */
    public static void setSpinnerControls(final Spinner<Integer> spinner, final int min, final int max) {
        spinner.setValueFactory(new IntSpinnerValueFactory(min, max, min));
    }

    /**
     * This method fills the the combo box with colors which can be choose.
     * 
     * @param playerColors the list of {@link ComboBox}
     */
    public static void fillColorsBoxes(final List<ComboBox<PlayerColor>> playerColors) {
        playerColors.forEach(colors -> {
            colors.setItems(FXCollections.observableArrayList(PlayerColor.values()));
            colors.getSelectionModel().selectFirst();
        });
    }

    /**
     * This method shows a form.
     * 
     * @param form the player form
     */
    public static void showForm(final VBox form) {
        form.setVisible(true);
        form.setManaged(true);
    }

    /**
     * This method hides a form.
     * 
     * @param form the player form
     */
    public static void hideForm(final VBox form) {
        form.setVisible(false);
        form.setManaged(false);
    }

    /**
     * This method resets a {@link Shape} position.
     * 
     * @param shape the {@link Shape} to reposition
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
     * @param button the {@link Button} to hide
     */
    public static void hideButton(final Button button) {
        button.setVisible(false);
        button.setManaged(false);
    }

    /**
     * This method shows a button.
     * 
     * @param button the {@link Button} to show
     */
    public static void showButton(final Button button) {
        button.setVisible(true);
        button.setManaged(true);
    }

    /**
     * This method hides all labels in a list.
     * 
     * @param labels the list of {@link Label}
     */
    public static void hideLabels(final List<Label> labels) {
        labels.forEach(label -> {
            label.setVisible(false);
            label.setManaged(false);
        });
    }

}

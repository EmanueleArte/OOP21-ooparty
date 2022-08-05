package utils;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.shape.Shape;
import utils.enums.PlayerColor;

/**
 * This class provides javafx gui utilities.
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
     * This method shows a node.
     * 
     * @param node the node to show
     */
    public static void showNode(final Node node) {
        node.setVisible(true);
        node.setManaged(true);
    }

    /**
     * This method hides a node.
     * 
     * @param node the node to hide
     */
    public static void hideNode(final Node node) {
        node.setVisible(false);
        node.setManaged(false);
    }

    /**
     * This method resets a {@link Shape} Y position.
     * 
     * @param shape the {@link Shape} to reposition
     * @param y     the starting Y
     */
    public static void resetPositionY(final Shape shape, final double y) {
        shape.setTranslateY(y);
    }

    /**
     * This method resets a {@link Shape} X position.
     * 
     * @param shape the {@link Shape} to reposition
     * @param x     the starting X
     */
    public static void resetPositionX(final Shape shape, final double x) {
        shape.setTranslateX(x);
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

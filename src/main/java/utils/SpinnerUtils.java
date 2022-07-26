package utils;

import javafx.scene.control.Spinner;

/**
 * This class provides spinner utilities.
 */
public final class SpinnerUtils {

    private SpinnerUtils() {
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

}

package utils.enums;

import javafx.scene.paint.Color;

/**
 * This enum defines the different player colors.
 */
public enum PlayerColor {
    /**
     * Red color.
     */
    RED(Color.RED),
    /**
     * Blue color.
     */
    BLUE(Color.BLUE),
    /**
     * Green color.
     */
    GREEN(Color.GREEN),
    /**
     * Yellow color.
     */
    YELLOW(Color.YELLOW),
    /**
     * White color.
     */
    WHITE(Color.WHITE),
    /**
     * Black color.
     */
    BLACK(Color.BLACK),
    /**
     * Pink color.
     */
    PINK(Color.PINK);

    private final Color color;

    /**
     * This method returns the corresponding javafx color.
     * 
     * @return the javafx color
     */
    public Color getColor() {
        return this.color;
    }

    PlayerColor(final Color color) {
        this.color = color;
    }
}

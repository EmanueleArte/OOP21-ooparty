package utils.enums;

import javafx.scene.paint.Color;

/**
 * This enum defines the different player colors.
 */
public enum PlayerColor {
	RED(Color.RED),
	BLUE(Color.BLUE),
	GREEN(Color.GREEN),
	YELLOW(Color.YELLOW),
	WHITE(Color.WHITE),
	BLACK(Color.BLACK),
	PINK(Color.PINK);
	
	private final Color color;
	
	/**
	 * This method returns the corresponding javafx color.
	 * @return the javafx color
	 */
	public Color getColor() {
		return this.color;
	}
	
	PlayerColor(final Color color) {
		this.color = color;
	}
}

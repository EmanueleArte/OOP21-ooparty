package utils.enums;

/**
 * Defines the different layouts for the maps.
 */
public enum MapLayout {
    /**
     * A rectangle like layout.
     */
    DEFAULT(34);

    private final int size;

    MapLayout(final int size) {
        this.size = size;
    }

    /**
     * Returns the number of {@link game.map.GameMapSquare GameMapSquare} which the map is composed.
     * @return the size of the map.
     */
    public int getSize() {
        return this.size;
    }
}

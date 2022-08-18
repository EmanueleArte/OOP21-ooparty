package utils.enums;

/**
 * Defines the different layouts for the maps.
 */
public enum MapLayout {
    /**
     * A rectangle like layout.
     */
    DEFAULT(34),
    /**
     * A layout with a lot of turns.
     */
    SNAKE(50);

    private final int size;

    MapLayout(final int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}

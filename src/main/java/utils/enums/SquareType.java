package utils.enums;

/**
 * This enum defines the different {@link GameMapSquare} used.
 */
public enum SquareType {
    /**
     * First square of the map.
     */
    START,
    /**
     * Square with no effects.
     */
    DEFAULT,
    /**
     * Square which gives the player some coins.
     */
    COIN,
    /**
     * Square which gives the player a power-up.
     */
    POWERUP,
    /**
     * Square which deals damages to the player.
     */
    DAMAGE,
    /**
     * Square which gives the player a star.
     */
    STAR
}

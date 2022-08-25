package utils.enums;

/**
 * this enum defines the progress in every turn.
 */
public enum PlayerTurnProgress {
    /**
     * time to show banner.
     */
    SHOW_BANNER,
    /**
     * time to hide banner.
     */
    HIDE_BANNER,
    /**
     * time to roll the dice.
     */
    USE_POWERUP,
    /**
     * time to roll the dice.
     */
    ROLL_DICE,
    /**
     * time to move player's avatar.
     */
    MOVE_PLAYER,
    /**
     * end of player turn.
     */
    END_OF_TURN;

    /**
     * This method returns the next step of a player turn progress.
     * 
     * @param playerTurnProgress the {@link PlayerTurnProgress} to increment
     * @return the next step
     */
    public static PlayerTurnProgress next(final PlayerTurnProgress playerTurnProgress) {
        return playerTurnProgress.ordinal() == values().length - 1 ? values()[0] : values()[playerTurnProgress.ordinal() + 1];
    }

    /**
     * This method returns the previous step of a player turn progress.
     * 
     * @param playerTurnProgress the {@link PlayerTurnProgress} to decrement
     * @return the previous step
     */
    public static PlayerTurnProgress previous(final PlayerTurnProgress playerTurnProgress) {
        return playerTurnProgress.ordinal() == 0 ? values()[values().length - 1] : values()[playerTurnProgress.ordinal() - 1];
    }

}

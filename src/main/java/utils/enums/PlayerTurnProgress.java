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

    public static PlayerTurnProgress next(final PlayerTurnProgress turn) {
        return turn.ordinal() == values().length - 1 ? values()[0] : values()[turn.ordinal() + 1];
    }

    public static PlayerTurnProgress previous(final PlayerTurnProgress turn) {
        return turn.ordinal() == 0 ? values()[values().length - 1] : values()[turn.ordinal() - 1];
    }

}

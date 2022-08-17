package utils.enums;

/**
 * this enum defines the progress in every turn.
 */
public enum TurnProgress {
    /**
     * time to show banner.
     */
    SHOW_BANNER,
    /**
     * time to hide banner.
     */
    HIDE_BANNER,
    /**
     * players turns (see PlayerTurnProgress).
     */
    PLAYERS_TURNS,
    /**
     * time to play minigame.
     */
    PLAY_MINIGAME,
    /**
     * time to show leaderboard.
     */
    SHOW_LEADERBOARD,
    /**
     * end of turn.
     */
    END_OF_TURN;

    public static TurnProgress next(final TurnProgress turn) {
        return turn.ordinal() == values().length - 1 ? values()[0] : values()[turn.ordinal() + 1];
    }

}

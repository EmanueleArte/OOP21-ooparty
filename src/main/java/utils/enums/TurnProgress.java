package utils.enums;

/**
 * This enum defines the progress in every turn.
 */
public enum TurnProgress {
    /**
     * Time to show banner.
     */
    SHOW_BANNER,
    /**
     * Time to hide banner.
     */
    HIDE_BANNER,
    /**
     * Time of the players turns (see {@link PlayerTurnProgress}).
     */
    PLAYERS_TURNS,
    /**
     * Time to play minigame.
     */
    PLAY_MINIGAME,
    /**
     * Time to show leaderboard.
     */
    SHOW_LEADERBOARD,
    /**
     * End of the turn.
     */
    END_OF_TURN;

    /**
     * This method returns the next step of a turn progress.
     * 
     * @param turnProgress the {@link TurnProgress} to increment
     * @return the next step
     */
    public static TurnProgress next(final TurnProgress turnProgress) {
        return turnProgress.ordinal() == values().length - 1 ? values()[0] : values()[turnProgress.ordinal() + 1];
    }

}

package utils.enums;

/**
 * this enum defines the progress in every turn.
 */
public enum TurnProgress {
    /**
     * time to show banner.
     */
    SHOW_BANNER(0),
    /**
     * time to hide banner.
     */
    HIDE_BANNER(1),
    /**
     * players turns (see PlayerTurnProgress).
     */
    PLAYERS_TURNS(2),
    /**
     * time to play minigame.
     */
    PLAY_MINIGAME(3),
    /**
     * time to show leaderboard.
     */
    SHOW_LEADERBOARD(4),
    /**
     * end of turn.
     */
    END_OF_TURN(5);

    private int progress;

    TurnProgress(final int i) {
        this.progress = i;
    }

    public int getProgress() {
        return this.progress;
    }

}

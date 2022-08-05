package utils.enums;

/**
 * this enum defines the progress in every turn.
 */
public enum PlayerTurnProgress {
    /**
     * time to show banner.
     */
    SHOW_BANNER(0),
    /**
     * time to hide banner.
     */
    HIDE_BANNER(1),
    /**
     * time to roll the dice.
     */
    ROLL_DICE(2),
    /**
     * time to move player's avatar.
     */
    MOVE_PLAYER(3),
    /**
     * end of player turn.
     */
    END_OF_TURN(5);

    private int progress;

    PlayerTurnProgress(final int i) {
        this.progress = i;
    }

    public int getProgress() {
        return this.progress;
    }

}

package utils.enums;

/**
 * This enum models the different notices.
 */
public enum Notice {
    /**
     * Game creation error notice.
     */
    GAME_CREATION_ERROR("There are some nicknames or/and colors duplicated or empty."),
    /**
     * Mastermind input error notice.
     */
    MASTERMIND_INPUT_ERROR("The input must be a 4-digit number with different digits.");


    private final String notice;

    /**
     * This method returns the corresponding advice string.
     * 
     * @return the advice string
     */
    public String getNotice() {
        return this.notice;
    }

    Notice(final String notice) {
        this.notice = notice;
    }
}

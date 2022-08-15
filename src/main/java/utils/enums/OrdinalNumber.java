package utils.enums;

/**
 * Enumeration which represents the ordinal numbers in text format.
 */
public enum OrdinalNumber {
    /**
     * First.
     */
    FIRST("1st"),
    /**
     * Second.
     */
    SECOND("2nd"),
    /**
     * Third.
     */
    THIRD("3td"),
    /**
     * Fourth.
     */
    FOURTH("4th");

    private final String text;

    OrdinalNumber(final String text) {
        this.text = text;
    }

    /**
     * Returns the text representation of the ordinal number.
     * @return text representation.
     */
    public String getTextFormat() {
        return this.text;
    }
}

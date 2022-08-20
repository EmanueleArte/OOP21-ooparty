package utils.enums;

import java.util.Optional;

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

    public static Optional<OrdinalNumber> intToOrdinalNumber(final int n) {
        switch (n) {
            case 1:
                return Optional.of(OrdinalNumber.FIRST);
            case 2:
                return Optional.of(OrdinalNumber.SECOND);
            case 3:
                return Optional.of(OrdinalNumber.THIRD);
            case 4:
                return Optional.of(OrdinalNumber.FOURTH);
            default:
                return Optional.empty();
        }
    }
}

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
    THIRD("3rd"),
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

    /**
     * Converts an integer to an {@link Optional} of the corresponding {@link OrdinalNumber}.
     * @param n the integer to convert
     * @return an {@link Optional} with the {@link OrdinalNumber} if n is between 1 and the last ordinal number existent, otherwise it returns an empty {@link Optional}
     */
    public static Optional<OrdinalNumber> intToOrdinalNumber(final int n) {
        return n > 0 && n <= OrdinalNumber.values().length ? Optional.of(OrdinalNumber.values()[n - 1]) : Optional.empty();
    }
}

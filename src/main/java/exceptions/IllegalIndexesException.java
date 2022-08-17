package exceptions;

/**
 * Exception that indicates whether there is a problem with an index.
 */
public class IllegalIndexesException extends RuntimeException {

    private static final long serialVersionUID = 2992100609334242571L;

    /**
     * Builds a new {@link IllegalIndexesException} with the default error message.
     */
    public IllegalIndexesException() {
        this("IllegalIndexesException");
    }

    /**
     * Builds a new {@link IllegalIndexesException} with {@code errorMessage} as
     * error message.
     * 
     * @param errorMessage the error message displayed
     */
    public IllegalIndexesException(final String errorMessage) {
        super(errorMessage);
    }

}

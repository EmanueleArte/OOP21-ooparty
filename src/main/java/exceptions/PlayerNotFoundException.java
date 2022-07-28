package exceptions;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException() {
        super();
    }

    public PlayerNotFoundException(final String s) {
        super(s);
    }
}

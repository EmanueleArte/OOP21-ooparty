package exceptions;

public class PlayerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -553574310787308990L;

    public PlayerNotFoundException() {
        super();
    }

    public PlayerNotFoundException(final String s) {
        super(s);
    }
}

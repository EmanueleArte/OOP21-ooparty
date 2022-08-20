package utils.factories.board;

/**
 * Extension of {@link GameBoardFactory} which represents a factory of boards with a specified size (34 squares).
 */
public abstract class FixedSizeGameBoardFactory implements GameBoardFactory {

    private static final int SIZE = 34;

    @Override
    public final int getSize() {
        return SIZE;
    }

}

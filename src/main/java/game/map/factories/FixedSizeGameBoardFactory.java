package game.map.factories;

import java.util.List;

import game.map.GameMapSquare;

/**
 * Extension of {@link GameBoardFactory} which represents a factory of boards with a specified size (34 squares).
 */
public abstract class FixedSizeGameBoardFactory implements GameBoardFactory {

    private static final int SIZE = 34;

    @Override
    public final List<GameMapSquare> createGameBoard() {
        return createGameBoard(SIZE);
    }

    @Override
    public abstract List<GameMapSquare> createGameBoard(int size);

    /**
     * This method returns the sized property.
     * @return size
     */
    protected final int getSize() {
        return SIZE;
    }

}

package game.map.factories;

import java.util.List;

import game.map.GameMapSquare;

public abstract class FixedSizeGameBoardFactory implements GameBoardFactory {

    private static final int SIZE = 34;

    @Override
    public List<GameMapSquare> createGameBoard() {
        return createGameBoard(SIZE);
    }

    @Override
    public abstract List<GameMapSquare> createGameBoard(int size);

    protected final int getSize() {
        return SIZE;
    }

}

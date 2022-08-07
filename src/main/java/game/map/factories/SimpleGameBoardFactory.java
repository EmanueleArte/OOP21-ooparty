package game.map.factories;

import java.util.ArrayList;
import java.util.List;

import game.map.GameMapSquare;
import game.map.GameMapSquareImpl;

public class SimpleGameBoardFactory implements GameBoardFactory {

    @Override
    public List<GameMapSquare> createGameBoard(final int size) {
        List<GameMapSquare> gameMap = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            gameMap.add(new GameMapSquareImpl());
        }
        return gameMap;
    }
}

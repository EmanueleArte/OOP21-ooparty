package game.map.factories;

import java.util.ArrayList;
import java.util.List;

import game.map.CoinsGameMapSquare;
import game.map.GameMapSquare;
import game.map.GameMapSquareImpl;

public class SimpleGameBoardFactory implements GameBoardFactory {
    
    private static final int MAP_SIZE = 34;

    @Override
    public List<GameMapSquare> createGameBoard() {
        List<GameMapSquare> gameMap = new ArrayList<>();
        for (int i = 0; i < MAP_SIZE; i++) {
            //Fatto giusto per testare la grafica delle caselle
            if (i == 2) {
                gameMap.add(new CoinsGameMapSquare());
            } else {
                gameMap.add(new GameMapSquareImpl());
            }
        }
        return gameMap;
    }
}

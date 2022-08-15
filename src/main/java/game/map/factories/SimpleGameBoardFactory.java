package game.map.factories;

import java.util.ArrayList;
import java.util.List;

import game.map.CoinsGameMapSquare;
import game.map.DamageGameMapSquare;
import game.map.GameMapSquare;
import game.map.GameMapSquareImpl;
import game.map.PowerUpGameMapSquare;
import game.map.StarGameMapSquare;

public class SimpleGameBoardFactory implements GameBoardFactory {

    private static final int MAP_SIZE = 34;

    @Override
    public List<GameMapSquare> createGameBoard() {
        List<GameMapSquare> gameMap = new ArrayList<>();
        for (int i = 0; i < MAP_SIZE; i++) {
            //Fatto giusto per testare la grafica delle caselle
            if (i == 2 || i == 15) {
                gameMap.add(new CoinsGameMapSquare());
            } else if (i == 3 || i == 10) {
                gameMap.add(new StarGameMapSquare());
            } else if (i == 5 || i == 32) {
                gameMap.add(new PowerUpGameMapSquare());
            } else if (i == 8 || i == 22) {
                gameMap.add(new DamageGameMapSquare());
            } else {
                gameMap.add(new GameMapSquareImpl());
            }
        }
        return gameMap;
    }
}

package gamemap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.map.GameMap;
import game.map.GameMapImpl;

class TestGameBoard {

    @Test
    void testBasicGameBoard() {
        GameMap map = new GameMapImpl(null);
        var board = map.getSquares();
        System.out.println(board);
    }

}

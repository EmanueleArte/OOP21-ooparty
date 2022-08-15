package gamemap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import game.map.GameMap;
import game.map.GameMapSquare;
import game.map.GameMapSquareImpl;
import game.map.GameMapImpl;

public class TestMap {

    @Test
    void testBasicGameMap() {
        GameMapSquare box1 = new GameMapSquareImpl();
        GameMapSquare box2 = new GameMapSquareImpl();
        GameMapSquare box3 = new GameMapSquareImpl();
        GameMapSquare box4 = new GameMapSquareImpl();

        List<GameMapSquare> boxes = new ArrayList<>();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
        boxes.add(box4);

        GameMap gameMap = new GameMapImpl(boxes);
        assertEquals(gameMap.getSquares(), List.of(box1, box2, box3, box4));
    }
}

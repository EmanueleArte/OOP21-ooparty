package gamemap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import game.map.GameMap;
import game.map.GameMapBox;
import game.map.GameMapBoxImpl;
import game.map.GameMapImpl;

public class TestMap {

    @Test
    void testBasicGameMap() {
        GameMapBox box1 = new GameMapBoxImpl();
        GameMapBox box2 = new GameMapBoxImpl();
        GameMapBox box3 = new GameMapBoxImpl();
        GameMapBox box4 = new GameMapBoxImpl();

        List<GameMapBox> boxes = new ArrayList<>();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
        boxes.add(box4);

        GameMap gameMap = new GameMapImpl(boxes);
        assertEquals(gameMap.getBoxes(), List.of(box1, box2, box3, box4));
    }
}

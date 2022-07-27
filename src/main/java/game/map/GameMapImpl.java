package game.map;

import java.util.List;

public class GameMapImpl implements GameMap {
    private List<GameMapBox> boxes;
    public static final int MONEY_TO_BUY_STAR = 50;

    public GameMapImpl(final List<GameMapBox> boxes) {
        this.boxes = boxes;
    }

    @Override
    public List<GameMapBox> getBoxesSet() {
        return List.copyOf(this.boxes);
    }
}

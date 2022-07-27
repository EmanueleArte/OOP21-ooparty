package game.map;

import java.util.List;

public class GameMapImpl implements GameMap {
    private List<GameMapBox> boxes;

    public GameMapImpl(final List<GameMapBox> boxes) {
        this.boxes = boxes;
    }

    @Override
    public List<GameMapBox> getBoxesSet() {
        return List.copyOf(this.boxes);
    }
}

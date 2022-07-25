package gamemap;

import java.util.Set;

public class GameMapImpl implements GameMap {
    private Set<GameMapBox> boxes;

    public GameMapImpl(final Set<GameMapBox> boxes) {
        this.boxes = boxes;
    }

    @Override
    public Set<GameMapBox> getBoxesSet() {
        return Set.copyOf(this.boxes);
    }
}

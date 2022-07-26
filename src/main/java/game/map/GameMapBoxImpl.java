package game.map;

import java.util.HashSet;
import java.util.Set;

public class GameMapBoxImpl implements GameMapBox {
    private Set<GameMapBox> prev;
    private Set<GameMapBox> next;
    protected static int MAX_STARS = 10;
    protected static int MAX_MONEY = 10;

    public GameMapBoxImpl() {
        this.prev = new HashSet<>();
        this.next = new HashSet<>();
    }
}

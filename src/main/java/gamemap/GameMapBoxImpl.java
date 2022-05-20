package gamemap;

import java.util.HashSet;
import java.util.Set;

public class GameMapBoxImpl implements GameMapBox {
    private Set<GameMapBox> prev;
    private Set<GameMapBox> next;
    
    public GameMapBoxImpl() {
        this.prev = new HashSet<>();
        this.next = new HashSet<>();
    }
}

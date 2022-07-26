package game.map;

import java.util.Set;

public interface GameMapBox {

    Set<GameMapBox> getPrev();

    Set<GameMapBox> getNext();

}

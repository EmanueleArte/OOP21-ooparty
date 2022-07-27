package game.map;

import java.util.List;

import game.player.Player;

public class GameMapImpl implements GameMap {
    private List<GameMapBox> boxes;
    /**
     * Number of coins to buy a star.
     */
    public static final int COINS_TO_BUY_STAR = 50;

    public GameMapImpl(final List<GameMapBox> boxes) {
        //TODO generare mappa (qua viene passata ma non penso funzionerà così, bisognerà fare un metodo qua dentro che la crea)
        this.boxes = boxes;
    }

    /**
     * 
     */
    @Override
    public List<GameMapBox> getBoxes() {
        return List.copyOf(this.boxes);
    }

    /**
     * 
     */
    @Override
    public GameMapBox getPlayerPosition(final Player p) {
        for (GameMapBox b : this.boxes) {
            if (b.getPlayers().stream().anyMatch(o -> o.equals(p))) {
                return b;
            }
        }
        //TODO dovrebbe lanciare un'eccezione?
        return this.boxes.get(0);
    }
}

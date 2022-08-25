package minigames.yourethebobomb.model;

import java.util.List;

import minigames.common.model.MinigameModel;

/**
 * This interface models the minigame {@code you're the bob-omb}'s model. This
 * interface is a specialization of {@link MinigameModel}.
 */
public interface YoureTheBobombModel extends MinigameModel {

    /**
     * This method sets the tile that will be chosen.
     *
     * @param tile the index of the tile that will be chosen.
     * @return {@code true} if another player needs to choose the tile,
     *         {@code false} otherwise.
     */
    boolean chooseTile(int tile);

    /**
     * This method tells the active tiles.
     *
     * @return a list containing the active tiles.
     */
    List<Integer> getTiles();

}

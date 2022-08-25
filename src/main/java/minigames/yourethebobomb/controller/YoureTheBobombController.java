package minigames.yourethebobomb.controller;

import minigames.common.controller.MinigameController;

/**
 * This interface models the minigame {@code cut from the team}'s controller.
 * This interface is a specialization of {@link MinigameController}.
 */
public interface YoureTheBobombController extends MinigameController {

    /**
     * This method updates the view with the name of the current player.
     */
    void updateCurrentPlayerLabel();

    /**
     * This method picks a tile.
     *
     * @param tile the value of the rope.
     */
    void pickTile(int tile);

}

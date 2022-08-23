package minigames.cutFromTheTeam.controller;

import minigames.common.controller.MinigameController;

/**
 * This interface models the minigame {@code cut from the team}'s controller. This interface
 * is a specialization of {@link MinigameController}.
 */
public interface CutFromTheTeamController extends MinigameController {

    /**
     * This method updates the view with the name of the current player.
     */
    void updateCurrentPlayerLabel();

    /**
     * This method picks a rope.
     *
     * @param cardValue the value of the rope.
     */
    void pickRope(Boolean ropeValue);

    /**
     * This methods tells whether the game has ended.
     *
     * @return {@code true} if the game has ended, {@code false} otherwise.
     */
    boolean isOver();

}

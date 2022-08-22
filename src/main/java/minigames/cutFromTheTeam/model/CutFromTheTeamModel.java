package minigames.cutFromTheTeam.model;

import minigames.common.model.MinigameModel;

/**
 * This interface models the minigame {@code cut from the team}'s model. This
 * interface is a specialization of {@link MinigameModel}.
 */
public interface CutFromTheTeamModel extends MinigameModel {

    /**
     * This method sets the rope that will be cut.
     * 
     * @param rope the index of the rope that will be cut.
     */
    void setRope(Boolean rope);

    /**
     * This method tells whether the game has ended.
     * 
     * @return {@code true} if the game has ended, {@code false} otherwise.
     */
    boolean isOver();
}

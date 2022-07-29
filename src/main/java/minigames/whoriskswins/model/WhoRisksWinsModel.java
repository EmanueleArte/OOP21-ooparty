package minigames.whoriskswins.model;

import minigames.common.model.MinigameModel;

/**
 * This interface models the who risks wins model.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the players
 */
public interface WhoRisksWinsModel<S, U> extends MinigameModel<S, U> {

    /**
     * Getter for the score.
     * 
     * @return the score of a player
     */
    int getScore();

}

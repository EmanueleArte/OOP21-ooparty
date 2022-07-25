package minigames.common.view;

import java.util.List;

import utils.graphics.stagemanager.StageManager;

/**
 * This interface models a minigame view.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public interface MinigameView<S, U> {

    /**
     * Getter for the {@link StageManager}.
     * 
     * @return the stage manager
     */
    StageManager<S> getStageManager();

    /**
     * This method creates the minigame scene.
     */
    void startMinigame(List<U> players);

}

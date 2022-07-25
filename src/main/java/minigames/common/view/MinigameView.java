package minigames.common.view;

import java.util.List;

import utils.graphics.StageManagerController;

/**
 * This interface models a minigame view.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public interface MinigameView<S, U> {

    /**
     * Getter for the {@link StageManagerController}.
     * 
     * @return the stage manager
     */
    StageManagerController<S> getStageManager();

    /**
     * This method creates the minigame scene.
     */
    void startMinigame(List<U> players);

}

package minigames.common.view;

import java.util.List;

import utils.GenericController;
import utils.graphics.stagemanager.StageManager;

/**
 * This interface models a minigame view.
 * 
 * @param <S> the scenes of the stage
 */
public interface MinigameView<S> {

    /**
     * Getter for the {@link StageManager}.
     * 
     * @return the stage manager
     */
    StageManager<S> getStageManager();

    /**
     * This method creates the minigame scene.
     */
    void startMinigame(List<?> list, GenericController controller);

}

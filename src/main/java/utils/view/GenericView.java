package utils.view;

import utils.controller.GenericController;
import utils.graphics.controller.StageManager;

/**
 * This interface models a generic view.
 * 
 * @param <S> the scenes of the stage
 */
public interface GenericView<S> {

    /**
     * Getter for the {@link StageManager}.
     * 
     * @return the stage manager
     */
    StageManager<S> getStageManager();

    /**
     * This method creates a scene.
     * 
     * @param controller the controller to be used
     */
    void createScene(GenericController controller);

}

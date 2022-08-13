package utils.graphics.model;

import java.util.List;

import minigames.common.controller.MinigameController;
import utils.controller.GenericController;

/**
 * This interface models the scenes handling.
 * 
 * @param <S> the scenes of the stage
 */
public interface SceneHandler<S> {

    /**
     * This method adds a scene to the scenes list.
     * 
     * @param scene the scene to add
     */
    void addScene(S scene);

    /**
     * This method removes the last scene created.
     * 
     * @return the last added scene or null if the scenes list is empty.
     */
    S popScene();

    /**
     * This method calculates the index of the last added scene.
     * 
     * @return the index of the last added scene
     */
    int lastSceneIndex();

    /**
     * Getter for the scenes list.
     * 
     * @return the scenes list
     */
    List<S> getScenes();

    /**
     * This methods checks if the controller parameter is a minigame controller.
     * 
     * @param controller the controller to check
     * @return the controller casted to {@link MinigameController} if it is a
     *         minigame controller else null
     */
    MinigameController checkGameController(GenericController controller);

}

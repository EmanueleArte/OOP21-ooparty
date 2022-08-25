package utils.graphics.model;

import java.util.List;

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
     * @throws IllegalStateException if the scenes list is empty
     */
    S popScene() throws IllegalStateException;

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

}

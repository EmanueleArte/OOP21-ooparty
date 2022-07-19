package utils.graphics;

import java.util.List;

import utils.enums.ControllerType;

/**
 * This interface models a stage manager for javafx.
 * 
 * @param <S> the scenes of the stage
 */
public interface StageManager<S> {

    /**
     * This method adds a scene to the scene list.
     * 
     * @param <U>     the {@link game.player.Player}
     * @param fxmlUrl the url of the fxml file to load
     * @param c       the type of the controller
     * @param players the list of the players; put null if you haven't any list of
     *                players to pass
     */
    <U> void addScene(String fxmlUrl, ControllerType c, List<U> players);

    /**
     * This method pops a scene from the scene list.
     * 
     * @return the last scene added
     */
    S popScene();

    /**
     * This method starts the javafx gui.
     * 
     * @param args
     */
    void run();

    /**
     * This method returns the list of all scenes.
     * 
     * @return the scenes of the stage
     */
    List<S> getScenes();

}

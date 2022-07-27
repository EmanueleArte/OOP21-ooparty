package utils.graphics.stagemanager;

import java.util.List;

import minigames.common.controller.MinigameController;
import utils.GenericController;
import utils.enums.ViewControllerType;

/**
 * This interface models a stage manager.
 * 
 * @param <S> the scenes of the stage
 */
public interface StageManager<S> {

    /**
     * This method adds an FXML scene to the scene list.
     * 
     * @param <U>        the players type
     * @param fxmlUrl    the url of the fxml file to load
     * @param c          the type of the controller
     * @param players    the list of the players; put null if you haven't any list
     *                   of players to pass
     * @param controller the controller to be used
     */
    <U> void addFXMLScene(String fxmlUrl, ViewControllerType c, List<U> players, GenericController controller);

    /**
     * This method adds an existing scene.
     * 
     * @param scene the scene to add
     */
    void addScene(S scene);

    /**
     * This method pops a scene from the scene list.
     * 
     * @return the last scene added
     */
    S popScene();

    /**
     * This method starts the javafx gui.
     * 
     */
    void run();

    /**
     * This method returns the list of all scenes.
     * 
     * @return the scenes of the stage
     */
    List<S> getScenes();

    /**
     * This method returns the last game controller used.
     * 
     * @return the last controller created
     */
    MinigameController getLastGameController();

    /**
     * Getter for the {@link Gui}.
     * 
     * @return the gui used
     */
    Gui<S> getGui();

}

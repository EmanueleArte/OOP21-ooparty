package utils.graphics.stagemanager;

import java.util.List;

import minigames.common.controller.MinigameController;
import utils.controller.GenericController;
import utils.graphics.Gui;

/**
 * This interface models a stage manager.
 * 
 * @param <S> the scenes of the stage
 */
public interface StageManager<S> {

    /**
     * This method adds an FXML scene to the scene list.
     * 
     * @param <U>                 the players type
     * @param fxmlUrl             the url of the fxml file to load
     * @param viewControllerClass the type of the view controller
     * @param controller          the controller to be used
     */
    <U> void addFXMLScene(String fxmlUrl, Class<?> viewControllerClass, GenericController controller);

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
     * @return the last minigamecontroller created
     */
    MinigameController getLastGameController();

    /**
     * Getter for the {@link Gui}.
     * 
     * @return the gui used
     */
    Gui getGui();

}

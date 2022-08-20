package utils.graphics.controller;

import java.util.List;

import minigames.common.controller.MinigameController;
import utils.controller.GenericController;
import utils.factories.controller.ControllerFactory;
import utils.graphics.view.Gui;

/**
 * This interface models a stage manager.
 * 
 * @param <S> the scenes of the stage
 */
public interface StageManager<S> {

    /**
     * This method adds an FXML scene to the scene list.
     * 
     * @param fxmlUrl    the url of the fxml file to load
     * @param controller the controller to be used
     */
    void addFXMLScene(String fxmlUrl, GenericController controller);

    /**
     * This method adds an existing scene.
     * 
     * @param scene the scene to add
     */
    void addScene(S scene);

    /**
     * This method pops a scene from the scenes list.
     * 
     * @return the last scene added or null if the scenes list is empty
     */
    S popScene();

    /**
     * This method starts the gui.
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
     * @return the last minigame controller created or null if no minigames have
     *         already been created
     */
    MinigameController getLastGameController();

    /**
     * Setter for the last game controller used.
     * 
     * @param controller the last minigame controller created or null if no
     *                   minigames have already been created
     */
    void setLastGameController(GenericController controller);

    /**
     * Getter for the {@link Gui}.
     * 
     * @return the gui used
     */
    Gui getGui();

    /**
     * Setter for the controller factory.
     * 
     * @param factory the controller factory used
     */
    void setControllerFactory(ControllerFactory factory);

    /**
     * Getter for the controller factory.
     * 
     * @return the controller factory used
     */
    ControllerFactory getControllerFactory();

}

package utils.graphics.stagemanager;

import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import utils.enums.ViewControllerType;

/**
 * This interface models the javafx gui.
 *
 * @param <S> the scenes of the stage
 */
public interface Gui<S> {

    /**
     * This method starts the javafx gui.
     * 
     */
    void createGui();

    /**
     * This method loads an FXML file.
     * 
     * @param <U>     the player
     * @param fxmlUrl the url of the fxml file to load
     * @param c       the type of the controller
     * @param players the list of the players; put null if you haven't any list of
     *                players to pass
     */
    <U> void loadScene(String fxmlUrl, ViewControllerType c, List<U> players);

    /**
     * This method shows the actual scene.
     * 
     * @param scene the {@link Scene} to be shown
     */
    void setScene(Scene scene);

    /**
     * Getter for the {@link FXMLLoader}.
     * 
     * @return the last loader used
     */
    FXMLLoader getLoader();

    /**
     * Getter for the {@link JFXPanel} scene.
     * 
     * @return the main stage {@link Scene}
     */
    Scene getStageScene();

}

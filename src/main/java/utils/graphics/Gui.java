package utils.graphics;

import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import utils.enums.ControllerType;

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
     * @param <U>     the {@link game.player.Player}
     * @param fxmlUrl the url of the fxml file to load
     * @param c       the type of the controller
     * @param players the list of the players; put null if you haven't any list of
     *                players to pass
     * @return the scene loaded
     */
    <U> Parent loadScene(String fxmlUrl, ControllerType c, List<U> players);

    /**
     * This method shows the actual scene.
     * 
     * @param scene the scene to be shown
     */
    void setScene(S scene);

    /**
     * Getter for the {@link FXMLLoader}.
     * 
     * @return the last loader used
     */
    FXMLLoader getLoader();

}

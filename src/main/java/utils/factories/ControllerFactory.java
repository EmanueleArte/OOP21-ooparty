package utils.factories;

import java.util.List;

/**
 * This interface models the controller factory of the game.
 */
public interface ControllerFactory {

    /**
     * This method creates a controller callback for the
     * {@link javafx.fxml.FXMLLoader}.
     * 
     * @return the controller {@link javafx.util.Callback} for the main menu
     */
    <U> GenericController<U> createMainMenuController();

    /**
     * This method creates a controller callback for the
     * {@link javafx.fxml.FXMLLoader}.
     * 
     * @return the controller {@link javafx.util.Callback} for the game creation
     *         menu
     */
    <U> GenericController<U> createGameCreationMenuController();

    /**
     * This method creates a controller callback for the
     * {@link javafx.fxml.FXMLLoader}.
     * 
     * @param <U> the {@link game.player.Player}
     * @return the controller {@link javafx.util.Callback} for mastermind minigame
     */
    <U> GenericController<U> createMastermind(List<U> players);

}

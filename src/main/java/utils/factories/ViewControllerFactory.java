package utils.factories;

import java.util.List;

/**
 * This interface models the controller factory of the game.
 */
public interface ViewControllerFactory {

    /**
     * This method creates a controller callback for the
     * {@link javafx.fxml.FXMLLoader}.
     * 
     * @return the controller {@link javafx.util.Callback} for the main menu
     */
    <U> GenericControllerCallback<U> createMainMenuController();

    /**
     * This method creates a controller callback for the
     * {@link javafx.fxml.FXMLLoader}.
     * 
     * @return the controller {@link javafx.util.Callback} for the game creation
     *         menu
     */
    <U> GenericControllerCallback<U> createGameCreationMenuController();

    /**
     * This method creates a controller callback for the
     * {@link javafx.fxml.FXMLLoader}.
     * 
     * @param <U> the {@link game.player.Player}
     * @return the controller {@link javafx.util.Callback} for mastermind minigame
     */
    <U> GenericControllerCallback<U> createMastermind(List<U> players);

}

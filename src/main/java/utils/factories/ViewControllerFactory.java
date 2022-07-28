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
     * @param <U>       the players
     * @param menuClass the class of the menu controller
     * @return the controller {@link javafx.util.Callback} for a menu
     */
    <U> GenericControllerCallback<U> createMenuController(Class<?> menuClass);

    /**
     * This method creates a controller callback for the
     * {@link javafx.fxml.FXMLLoader}.
     * 
     * @param <U>       the players
     * @param gameClass the class of the game controller
     * @param players   the list of players
     * @return the controller {@link javafx.util.Callback} for a game
     */
    <U> GenericControllerCallback<U> createGameController(Class<?> gameClass, List<U> players);

}

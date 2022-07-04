package utils.factories;

/**
 * This interface models the controller factory of the game.
 * @param <S> the scenes of the stage
 */
public interface ControllerFactory<S> {
	
	/**
	 * This method creates a controller callback for the {@link javafx.fxml.FXMLLoader}.
	 * @return the controller {@link javafx.util.Callback} for the main menu
	 */
	GenericController<S> createMainMenuController();
	
	/**
	 * This method creates a controller callback for the {@link javafx.fxml.FXMLLoader}.
	 * @return the controller {@link javafx.util.Callback} for the game creation menu
	 */
	GenericController<S> createGameCreationMenuController();

}

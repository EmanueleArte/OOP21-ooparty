package menu.gamecreationmenu.model;

import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import utils.enums.PlayerColor;

/**
 * This interface models the game creation menu model of the game.
 */
public interface GameCreationMenuModel<S> {
	
	/**
	 * This method returns to the main menu of the game.
	 */
	void returnToMainMenu();
	
	/**
	 * This method starts the game.
	 */
	void startGame();
	
	/**
	 * This method fills the the combo box with colors which can be choose.
	 * @param playerColors the available colors
	 */
	void fillColorsBoxes(List<ComboBox<PlayerColor>> playerColors);
	
	/**
	 * This method sets the value factory for the number of players spinner.
	 * @param playerColors the available colors
	 */
	void setNumberOfPlayersSpinner(Spinner<Integer> numberOfPlayers);

}

package menu.gamecreationmenu.model;

import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import utils.NoticeUser;
import utils.enums.PlayerColor;

/**
 * This interface models the game creation menu model of the game.
 */
public interface GameCreationMenuModel<S> extends NoticeUser {
	
	/**
	 * This method returns to the main menu of the game.
	 */
	void returnToMainMenu();
	
	/**
	 * This method starts the game if the forms have correct values.
	 * @param playersNicknames the nicknames of the players
	 * @param playerColors the colors of the players
	 * @param turnsNumber the number of turns of the game
	 */
	void startGame(List<TextField> playersNicknames, List<ComboBox<PlayerColor>> playerColors, Spinner<Integer> turnsNumber);
	
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
	
	/**
	 * This method sets the value factory for the number of turns spinner.
	 * @param playerColors the available colors
	 */
	void setTurnsNumberSpinner(Spinner<Integer> turnsNumber);
	
	/**
	 * This method shows only the necessary players forms.
	 * @param playersForms the list of players forms
	 * @param nPlayers the selected number of players
	 */
	void showForms(List<VBox> playersForms, Integer nPlayers);

}

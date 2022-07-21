package menu.gamecreationmenu.model;

import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import utils.enums.PlayerColor;

/**
 * This interface models the game creation menu model of the game.
 * 
 * @param <S> the scenes of the stage
 */
public interface GameCreationMenuModel<S> {

    /**
     * This method returns to the main menu of the game.
     */
    void returnToMainMenu();

    /**
     * This method starts the game if the forms have correct values.
     * 
     * @param playersNicknames the nicknames of the players
     * @param playerColors     the colors of the players
     * @param turnsNumber      the number of turns of the game
     */
    void startGame(List<TextField> playersNicknames, List<ComboBox<PlayerColor>> playerColors,
            Spinner<Integer> turnsNumber);

    /**
     * Setter for actualNPlayers.
     * 
     * @param nPlayers the new number of players
     */
    void setActualNPlayers(Integer nPlayers);

    /**
     * This method fills the the combo box with colors which can be choose.
     * 
     * @param playerColors the available colors
     */
    void fillColorsBoxes(List<ComboBox<PlayerColor>> playerColors);

    /**
     * This method sets the value factory for the number of players spinner.
     * 
     * @param playerColors the available colors
     */
    void setNumberOfPlayersSpinner(Spinner<Integer> numberOfPlayers);

    /**
     * This method sets the value factory for the number of turns spinner.
     * 
     * @param playerColors the available colors
     */
    void setTurnsNumberSpinner(Spinner<Integer> turnsNumber);

}

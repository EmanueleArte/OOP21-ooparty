package menu.gamecreationmenu.model;

import java.util.List;
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
     * @return false if there are duplicates or blank forms
     */
    boolean startGame(List<String> playersNicknames, List<PlayerColor> playerColors, int turnsNumber);

    /**
     * Setter for actualNPlayers.
     * 
     * @param nPlayers the new number of players
     */
    void setActualNPlayers(Integer nPlayers);

}

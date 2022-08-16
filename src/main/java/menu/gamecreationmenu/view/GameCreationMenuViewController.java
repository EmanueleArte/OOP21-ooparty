package menu.gamecreationmenu.view;

import java.util.List;

import utils.enums.PlayerColor;
import utils.view.GenericViewController;

/**
 * Extension of {@link GenericViewController}.
 */
public interface GameCreationMenuViewController extends GenericViewController {

    /**
     * This method gets the players colors values.
     * 
     * @return the list of players colors
     */
    List<PlayerColor> getColorsValues();

    /**
     * This method gets the players nicknames.
     * 
     * @return the list of players nicknames
     */
    List<String> getPlayersNicknames();

    /**
     * This method gets the players nicknames.
     * 
     * @return the number of turns chosen
     */
    int getTurnsNumber();

    /**
     * This method gets the number of players.
     * 
     * @return the number of players
     */
    int getActualNumberOfPlayers();

    /**
     * This method shows the error occurred.
     */
    void showError();

}

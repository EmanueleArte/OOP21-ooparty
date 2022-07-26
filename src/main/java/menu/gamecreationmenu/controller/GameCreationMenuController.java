package menu.gamecreationmenu.controller;

import menu.mainmenu.controller.MainMenuController;

/**
 * This interface models the game creation menu controller.
 */
public interface GameCreationMenuController extends MainMenuController {

    /**
     * This method sets the actual number of players.
     * 
     * @param actualNPlayers the actual number of players
     */
    void setActualNumberOfPlayers(int actualNPlayers);

}

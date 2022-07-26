package menu.gamecreationmenu.controller;

import menu.mainmenu.controller.MainMenuController;

/**
 * This interface models the game creation menu controller.
 */
public interface GameCreationMenuController extends MainMenuController {

    /**
     * This method shows only the necessary players forms.
     */
    void showPlayersForms();

    /**
     * This method sets some gui elements rules.
     */
    void initialize();

    /**
     * This method sets the actual number of players.
     * 
     * @param actualNPlayers the actual number of players
     */
    void setActualNumberOfPlayers(int actualNPlayers);

}

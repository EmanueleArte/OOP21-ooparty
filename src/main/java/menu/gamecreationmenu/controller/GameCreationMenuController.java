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

}

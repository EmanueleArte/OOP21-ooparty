package menu.mainmenu.controller;

/**
 * This interface models the main menu controller.
 */
public interface MainMenuController {

    /**
     * This method creates and move on the next scene.
     */
    void goNext();

    /**
     * This method exits from the actual scene.
     */
    void exit();

    /**
     * This method creates the menu scene.
     */
    void createMenu();

}

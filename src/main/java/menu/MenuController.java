package menu;

import utils.GenericController;

/**
 * This interface models a menu controller.
 */
public interface MenuController extends GenericController {

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

package menu;

/**
 * This interface models a menu controller.
 */
public interface MenuController {

    /**
     * This method moves to the next scene.
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

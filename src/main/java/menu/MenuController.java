package menu;

/**
 * This interface models a menu controller and extends {@link GenericController}.
 */
public interface MenuController {

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

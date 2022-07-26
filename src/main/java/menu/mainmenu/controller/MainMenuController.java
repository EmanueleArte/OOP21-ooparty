package menu.mainmenu.controller;

/**
 * This interface models the main menu controller.
 * 
 * @param <S> the scenes of the stage
 */
public interface MainMenuController<S> {

    /**
     * This method creates and move on the next scene.
     */
    void goNext();

    /**
     * This method exits from the actual scene.
     */
    void exit();

}

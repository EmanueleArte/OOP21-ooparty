package menu.mainmenu.view;

import utils.GenericController;

/**
 * This interface models the main menu view of the game.
 * 
 * @param <S> the scenes of the stage
 */
public interface MainMenuView<S> {

    /**
     * This method creates the main menu scene.
     * 
     * @param controller the controller to be used
     */
    void createMainMenu(GenericController controller);

}

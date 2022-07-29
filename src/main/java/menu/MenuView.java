package menu;

import utils.GenericController;

/**
 * This interface models a menu view of the game.
 * 
 * @param <S> the scenes of the stage
 */
public interface MenuView<S> {

    /**
     * This method shows a menu into the javafx gui.
     * 
     * @param controller the controller to be used
     */
    void createMenu(GenericController controller);

}

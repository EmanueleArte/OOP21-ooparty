package menu.gamecreationmenu.view;

import utils.GenericController;

/**
 * This interface models the creation menu view of the game.
 * 
 * @param <S> the scenes of the stage
 */
public interface GameCreationMenuView<S> {

    /**
     * This method shows the game creation menu into the javafx gui.
     * 
     * @param controller the controller to be used
     */
    void createGameCreationMenu(GenericController controller);

}

package menu.pausemenu.model;

/**
 * This interface models the pause menu model of the game.
 * 
 * @param <S> the scenes of the stage
 */
public interface PauseMenuModel<S> {

    /**
     * This method returns to the main menu of the game.
     */
    void returnMainMenu();

    /**
     * This method continues the game.
     */
    void continueGame();

}

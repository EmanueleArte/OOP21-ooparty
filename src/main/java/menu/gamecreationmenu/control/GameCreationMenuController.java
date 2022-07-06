package menu.gamecreationmenu.control;

/**
 * This interface models the game creation menu control of the game.
 * 
 * @param <S> the scenes of the stage
 */
public interface GameCreationMenuController<S> {

    /**
     * This method returns to the main menu of the game.
     */
    void returnToMainMenu();

    /**
     * This method starts a new game.
     */
    void startGame();

    /**
     * This method shows only the necessary players forms.
     */
    void showPlayersForms();

    /**
     * This method clears the notice.
     */
    void clearNotice();

}

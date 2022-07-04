package menu.mainmenu.control;

/**
 * This interface models the main menu controller of the game.
 * @param <S> the scenes of the stage
 */
public interface MainMenuController<S> {
	
	/**
	 * This method exits the game.
	 */
	void exitGame();

	/**
	 * This method creates a new game.
	 */
	void createGame();
	
}

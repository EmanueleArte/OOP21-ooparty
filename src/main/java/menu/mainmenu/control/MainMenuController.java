package menu.mainmenu.control;

/**
 * This interface models the main menu controller of the game.
 */
public interface MainMenuController {
	
	/**
	 * This method shows the game main menu.
	 */
	void start();
	
	/**
	 * This method exits the game.
	 */
	void exitGame();

	/**
	 * This method creates a new game.
	 */
	void createGame();
	
}

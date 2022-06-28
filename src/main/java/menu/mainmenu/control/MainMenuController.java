package menu.mainmenu.control;

/**
 * This interface models the main menu control of the game.
 */
public interface MainMenuController {
	
	/**
	 * This method shows the game creation menu.
	 */
	void start();
	
	/**
	 * This method returns to the main menu.
	 */
	void exitGame();

	/**
	 * This method starts a new game.
	 */
	void startGame();
	
}

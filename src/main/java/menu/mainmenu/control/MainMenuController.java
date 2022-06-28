package menu.mainmenu.control;

/**
 * This interface models the main menu control of the game.
 */
public interface MainMenuController {
	
	/**
	 * This method shows the main menu.
	 */
	void start();
	
	/**
	 * This method exits from the game.
	 */
	public void exitGame();

	/**
	 * This method creates a new game.
	 */
	public void createGame();
	
}

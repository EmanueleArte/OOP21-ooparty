package menu.gamecreationmenu.control;

/**
 * This interface models the main menu control of the game.
 */
public interface GameCreationMenuController {
	
	/**
	 * This method shows the main menu.
	 */
	void start();
	
	/**
	 * This method exits from the game.
	 */
	void exitGame();

	/**
	 * This method creates a new game.
	 */
	void createGame();
	
}

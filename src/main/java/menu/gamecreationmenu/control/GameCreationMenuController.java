package menu.gamecreationmenu.control;

/**
 * This interface models the game creation menu control of the game.
 */
public interface GameCreationMenuController {
	
	/**
	 * This method shows the main menu.
	 */
	void start();
	
	/**
	 * This method returns to the main menu of the game.
	 */
	void exitGame();

	/**
	 * This method starts a new game.
	 */
	void startGame();
	
}

package menu.gamecreationmenu.model;

/**
 * This interface models the game creation menu model of the game.
 */
public interface GameCreationMenuModel<S> {
	
	/**
	 * This method returns to the main menu of the game.
	 */
	void returnToMainMenu();
	
	/**
	 * This method starts the game.
	 */
	void startGame();

}

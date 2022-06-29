package menu.mainmenu.model;

/**
 * This interface models the main menu model of the game.
 */
public interface MainMenuModel<S> {
	
	/**
	 * This method exits from the game.
	 */
	void exit();
	
	/**
	 * This method opens the game creation menu.
	 */
	void gameCreationMenu();

}

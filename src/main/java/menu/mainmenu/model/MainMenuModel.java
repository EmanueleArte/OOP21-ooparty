package menu.mainmenu.model;

import menu.mainmenu.view.MainMenuView;

/**
 * This interface models the main menu model of the game.
 */
public interface MainMenuModel {

	/**
	 * This method sets menuView.
	 */
	void setMenuView(MainMenuView menuView);
	
	/**
	 * This method exits from the game.
	 */
	void exit();
	
	/**
	 * This method open the game creation menu.
	 */
	void gameCreationMenu();

}

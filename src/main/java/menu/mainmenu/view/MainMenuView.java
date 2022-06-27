package menu.mainmenu.view;

import javafx.scene.control.Button;

/**
 * This interface models the main menu view of the game.
 */
public interface MainMenuView {
	
	/**
	 * This method returns the create game button.
	 * @return the button that opens the create game window
	 */
	Button getGameButton();
	
	/**
	 * This method returns the exit button.
	 * @return the button that exits the game
	 */
	Button getExitButton();

	/**
	 * This method starts the javaFX gui.
	 */
	void run(String[] args);
	
}

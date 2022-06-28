package menu.mainmenu.view;

import javafx.stage.Stage;

/**
 * This interface models the main menu view of the game.
 */
public interface MainMenuView {

	/**
	 * This method returns the primary stage.
	 * @return the primary stage
	 */
	Stage getStage();
	
	/**
	 * This method starts the javaFX gui.
	 */
	void run(String[] args);
	
}

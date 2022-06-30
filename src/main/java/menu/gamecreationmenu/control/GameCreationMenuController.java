package menu.gamecreationmenu.control;

import java.util.List;
import javafx.scene.layout.VBox;

/**
 * This interface models the game creation menu control of the game.
 */
public interface GameCreationMenuController<S> {
	
	/**
	 * This method returns to the main menu of the game.
	 */
	void returnToMainMenu();

	/**
	 * This method starts a new game.
	 */
	void startGame();
	
	/**
	 * This method shows only the necessary players forms.
	 */
	void showPlayersForms();
	
}

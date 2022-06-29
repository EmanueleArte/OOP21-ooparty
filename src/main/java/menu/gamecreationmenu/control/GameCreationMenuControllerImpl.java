package menu.gamecreationmenu.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;

/**
 * Implementation of {@link GameCreationMenuController}.
 */
public class GameCreationMenuControllerImpl<S> implements GameCreationMenuController<S> {

	private GameCreationMenuModel<S> gameCreationMenuModel;
	@FXML private Button returnMainMenuButton;
	@FXML private Button startGameButton;
	
	public GameCreationMenuControllerImpl<S>() {
		super();
		this.gameCreationMenuModel = new gameCreationMenuModelImpl<>(s);
	}
	
	@Override
	public void returnToMainMenu() {
		
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

	

}

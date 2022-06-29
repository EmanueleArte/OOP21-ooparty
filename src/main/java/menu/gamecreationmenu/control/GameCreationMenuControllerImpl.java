package menu.gamecreationmenu.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import menu.gamecreationmenu.model.GameCreationMenuModel;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import utils.graphics.StageManager;

/**
 * Implementation of {@link GameCreationMenuController}.
 */
public class GameCreationMenuControllerImpl<S> implements GameCreationMenuController<S> {

	private GameCreationMenuModel<S> gameCreationMenuModel;
	@FXML private Button returnMainMenuButton;
	@FXML private Button startGameButton;
	
	public GameCreationMenuControllerImpl(final StageManager<S> s) {
		super();
		this.gameCreationMenuModel = new GameCreationMenuModelImpl<>(s);
	}
	
	@Override
	public void returnToMainMenu() {
		this.gameCreationMenuModel.returnToMainMenu();
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

	

}

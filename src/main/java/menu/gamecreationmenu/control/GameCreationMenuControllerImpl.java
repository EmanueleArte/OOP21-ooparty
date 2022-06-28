package menu.gamecreationmenu.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import menu.gamecreationmenu.view.GameCreationMenuView;
import menu.gamecreationmenu.view.GameCreationMenuViewImpl;
import menu.mainmenu.model.MainMenuModel;

/**
 * Implementation of {@link GameCreationMenuController}.
 */
public class GameCreationMenuControllerImpl implements GameCreationMenuController {

	private GameCreationMenuView creationMenuView;
	private MainMenuModel creationMenuModel;
	
	public GameCreationMenuControllerImpl(final Stage s) {
		super();
		this.creationMenuView = new GameCreationMenuViewImpl(s);
	}
	
	@Override
	public void start() {
        this.creationMenuView.startGameCreationMenu();
	}

	@Override
	public void returnToMainMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

}

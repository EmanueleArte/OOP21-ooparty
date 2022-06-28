package menu.gamecreationmenu.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;

/**
 * Implementation of {@link CreationMenuController}.
 */
public class GameCreationMenuControllerImpl implements GameCreationMenuController {

	private MainMenuView creationMenuView;
	private MainMenuModel creationMenuModel;
	@FXML private Button exitButton;
	@FXML private Button createGameButton;
	
	public GameCreationMenuControllerImpl() {
		super();
		this.creationMenuView = new MainMenuViewImpl();
		this.creationMenuModel = new MainMenuModelImpl();
	}
	
	@Override
	public void start() {
        
	}

	@Override
	public void exitGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

}

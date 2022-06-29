package menu.mainmenu.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MainMenuController}.
 */
public class MainMenuControllerImpl<S> implements MainMenuController<S> {

	private MainMenuModel<S> menuModel;
	private StageManager<S> stageManager;
	@FXML private Button exitButton;
	@FXML private Button createGameButton;

	public MainMenuControllerImpl(final StageManager<S> s) {
		super();
		this.stageManager = s;
		this.menuModel = new MainMenuModelImpl<>(s);
	}
	
	@Override
	public void exitGame() {
		this.menuModel.exit();
	}
	
	@Override
	public void createGame() {
		this.menuModel.gameCreationMenu();
	}

}

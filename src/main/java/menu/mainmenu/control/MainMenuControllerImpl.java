package menu.mainmenu.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MainMenuController}.
 */
public class MainMenuControllerImpl<S> implements MainMenuController<S> {

	private MainMenuView<S> menuView;
	private MainMenuModel menuModel;
	private StageManager<S> stageManager;
	@FXML private Button exitButton;
	@FXML private Button createGameButton;

	public MainMenuControllerImpl() {
		super();
	}
	
	@Override
	public void start(final StageManager<S> s) {
		this.stageManager = s;
		//this.menuView = new MainMenuViewImpl<>(s);
		this.menuModel = new MainMenuModelImpl();
        this.menuView.createMainMenu();
	}
	
	@Override
	public void exitGame() {
		this.menuModel.exit();
	}
	
	@Override
	public void createGame() {
		this.menuModel.setMenuView(this.menuView);
		this.menuModel.gameCreationMenu();
	}

}

package menu.mainmenu.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;

public class MainMenuControllerImpl implements MainMenuController {

	private MainMenuView menuView;
	private MainMenuModel menuModel;
	@FXML private Button exitButton;
	
	public MainMenuControllerImpl() {
		super();
		this.menuView = new MainMenuViewImpl();
		this.menuModel = new MainMenuModelImpl();
	}
	
	@Override
	public void start() {
        this.menuView.run(null);
	}
	
	@Override
	public void exitGame() {
		this.menuModel.exit();
	}

	@Override
	public void createGame() {
		// TODO Auto-generated method stub

	}

}

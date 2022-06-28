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

	/**
	 * This method sets the listeners for the main menu buttons.
	 */
	private void setListeners() {
		this.menuView.setGameButton(new Button("Create game"));
		this.menuView.getGameButton().setOnMouseClicked(mouseEvent -> {
			this.createGame();
		});
		this.menuView.setExitButton(new Button("Exit"));
		this.menuView.getExitButton().setOnMouseClicked(mouseEvent -> {
			this.exitGame();
		});
	}
	
	@Override
	public void start() {
		//final Thread thread = new Thread(this.menuView);
        //thread.start();
        this.menuView.run(null);
		
		//this.setListeners();
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

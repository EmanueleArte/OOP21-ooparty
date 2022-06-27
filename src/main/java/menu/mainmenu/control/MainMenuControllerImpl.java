package menu.mainmenu.control;

import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;

public class MainMenuControllerImpl implements MainMenuController {

	private MainMenuView menuView;
	private MainMenuModel menuModel;
	
	public MainMenuControllerImpl() {
		this.menuView = new MainMenuViewImpl();
		this.menuView.run(null);
		this.menuModel = new MainMenuModelImpl(this.menuView.getStage());
		/*this.menuView.getGameButton().setOnMouseClicked(mouseEvent -> {
			this.createGame();
		});*/
		this.menuView.getExitButton().setOnMouseClicked(mouseEvent -> {
			this.menuView.getExitButton().setText("ok");
			//this.exitGame();
		});
	}

	@Override
	public void start() {
		this.menuView.run(null);
	}
	
	/**
	 * This method exits from the game.
	 */
	private void exitGame() {
		this.menuModel.exit();
	}

	/**
	 * This method creates a new game.
	 */
	private void createGame() {
		// TODO Auto-generated method stub

	}

}

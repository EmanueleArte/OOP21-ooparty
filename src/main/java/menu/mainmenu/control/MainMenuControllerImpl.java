package menu.mainmenu.control;

import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;

public class MainMenuControllerImpl implements MainMenuController {

	private MainMenuView menuView;
	private MainMenuModel menuModel;
	
	public MainMenuControllerImpl() {
		this.menuView = new MainMenuViewImpl();
		this.menuView.run(null);
	}

	@Override
	public void showMenu() {
		menuView.showView();
	}
	
	/**
	 * This method exits from the game.
	 */
	private void exitGame() {
		// TODO Auto-generated method stub

	}

	/**
	 * This method creates a new game.
	 */
	private void createGame() {
		// TODO Auto-generated method stub

	}

}

package menu.mainmenu.model;

import menu.mainmenu.view.MainMenuView;

/**
 * Implementation of {@link MainMenuModel}.
 */
public class MainMenuModelImpl implements MainMenuModel {

	private MainMenuView menuView;
	
	public MainMenuModelImpl() {
		super();
	}
	
	@Override
	public void setMenuView(final MainMenuView menuView) {
		this.menuView = menuView;
	}

	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void gameCreationMenu() {
		
	}

}

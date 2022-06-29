package menu.mainmenu.model;

import menu.gamecreationmenu.control.GameCreationMenuController;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MainMenuModel}.
 */
public class MainMenuModelImpl<S> implements MainMenuModel<S> {

	private StageManager<S> stageManager;
	
	public MainMenuModelImpl(final StageManager<S> s) {
		super();
		this.stageManager = s;
	}

	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void gameCreationMenu() {
		final GameCreationMenuView creationMenu = 
				new GameCreationMenuViewImpl(this.stageManager);
		creationMenu.start();
	}

}

package menu.mainmenu.model;

import menu.gamecreationmenu.view.GameCreationMenuView;
import menu.gamecreationmenu.view.GameCreationMenuViewImpl;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MainMenuModel}.
 */
public class MainMenuModelImpl<S> implements MainMenuModel<S> {

	private final StageManager<S> stageManager;

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
		final GameCreationMenuView<S> creationMenu = new GameCreationMenuViewImpl<>(this.stageManager);
		creationMenu.createGameCreationMenu();
	}

}

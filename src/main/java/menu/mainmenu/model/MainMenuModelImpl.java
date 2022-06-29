package menu.mainmenu.model;

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
		
		/*final GameCreationMenuController creationMenu = 
				new GameCreationMenuControllerImpl(this.menuView.getStage());
		creationMenu.start();*/
	}

}

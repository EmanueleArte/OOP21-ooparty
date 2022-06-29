package menu.gamecreationmenu.view;

import utils.enums.Controller;
import utils.graphics.StageManager;

/**
 * Implementation of {@link GameCreationMenuView}.
 */
public class GameCreationMenuViewImpl<S> implements GameCreationMenuView<S> {

final private StageManager<S> stageManager;
	
	public GameCreationMenuViewImpl(final StageManager<S> s) {
		super();
		this.stageManager = s;
	}

	@Override
	public void createGameCreationMenu() {
		final String fxmlUrl = "menu/creation_menu.fxml";
		this.stageManager.addScene(fxmlUrl, Controller.GAME_CREATION_MENU);
	}

}

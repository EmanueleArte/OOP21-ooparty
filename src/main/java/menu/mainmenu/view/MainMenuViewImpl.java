package menu.mainmenu.view;

import utils.enums.ControllerType;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MainMenuView}.
 */
public class MainMenuViewImpl<S> implements MainMenuView<S> {

	final private StageManager<S> stageManager;
	
	public MainMenuViewImpl(final StageManager<S> s) {
		super();
		this.stageManager = s;
	}

	@Override
	public void createMainMenu() {
		final String fxmlUrl = "menu/main_menu.fxml";
		this.stageManager.addScene(fxmlUrl, ControllerType.MAIN_MENU);
	}

}

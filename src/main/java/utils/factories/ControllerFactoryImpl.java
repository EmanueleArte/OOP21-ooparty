package utils.factories;

import menu.mainmenu.control.MainMenuControllerImpl;
import utils.graphics.StageManager;

/**
 * Implementation of {@link ControllerFactory}.
 */
public class ControllerFactoryImpl<S> implements ControllerFactory<S> {
	
	private final StageManager<S> stageManager;
	
	public ControllerFactoryImpl(final StageManager<S> s) {
		this.stageManager = s;
	}
	
	@Override
	public GenericController<S> createMainMenuController() {
		return new GenericController<S>(this.stageManager, MainMenuControllerImpl.class);
	}

	@Override
	public GenericController<S> createGameCreationMenuController() {
		return new GenericController<S>(this.stageManager, null);
	}

}

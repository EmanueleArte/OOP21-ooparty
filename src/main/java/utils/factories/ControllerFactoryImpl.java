package utils.factories;

import java.util.List;

import menu.gamecreationmenu.control.GameCreationMenuControllerImpl;
import menu.mainmenu.control.MainMenuControllerImpl;
import minigames.mastermind.control.MastermindControllerImpl;
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
	public <U> GenericController<S, U> createMainMenuController() {
		return new GenericController<S, U>(this.stageManager, MainMenuControllerImpl.class);
	}

	@Override
	public <U> GenericController<S, U> createGameCreationMenuController() {
		return new GenericController<S, U>(this.stageManager, GameCreationMenuControllerImpl.class);
	}

	@Override
	public <U> GenericController<S, U> createMastermind(List<U> players) {
		return new GenericController<S, U>(this.stageManager, players, MastermindControllerImpl.class);
	}

}

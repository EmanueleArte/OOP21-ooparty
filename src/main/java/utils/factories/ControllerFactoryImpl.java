package utils.factories;

import java.util.List;

import menu.gamecreationmenu.control.GameCreationMenuViewController;
import menu.mainmenu.control.MainMenuViewController;
import minigames.mastermind.control.MastermindControllerImpl;
import utils.graphics.StageManager;

/**
 * Implementation of {@link ControllerFactory}.
 * 
 * @param <S> the scenes of the stage
 */
public class ControllerFactoryImpl<S> implements ControllerFactory<S> {

    private final StageManager<S> stageManager;

    public ControllerFactoryImpl(final StageManager<S> s) {
        this.stageManager = s;
    }

    @Override
    public final <U> GenericController<S, U> createMainMenuController() {
        return new GenericController<S, U>(this.stageManager, MainMenuViewController.class);
    }

    @Override
    public final <U> GenericController<S, U> createGameCreationMenuController() {
        return new GenericController<S, U>(this.stageManager, GameCreationMenuViewController.class);
    }

    @Override
    public final <U> GenericController<S, U> createMastermind(final List<U> players) {
        return new GenericController<S, U>(this.stageManager, players, MastermindControllerImpl.class);
    }

}

package utils.factories;

import java.util.List;

import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewController;
import menu.mainmenu.viewcontroller.MainMenuViewController;
import minigames.mastermind.viewcontroller.MastermindViewController;
import utils.graphics.StageManagerController;

/**
 * Implementation of {@link ControllerFactory}.
 * 
 * @param <S> the scenes of the stage
 */
public class ControllerFactoryImpl<S> implements ControllerFactory<S> {

    private final StageManagerController<S> stageManager;

    /**
     * Builds a new {@link ControllerFactoryImpl}.
     * 
     * @param s the {@link utils.graphics.StageManagerController}
     */
    public ControllerFactoryImpl(final StageManagerController<S> s) {
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
        return new GenericController<S, U>(this.stageManager, players, MastermindViewController.class);
    }

}

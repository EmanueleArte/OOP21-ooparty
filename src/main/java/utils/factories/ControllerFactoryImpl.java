package utils.factories;

import java.util.List;

import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewController;
import menu.mainmenu.viewcontroller.MainMenuViewController;
import minigames.mastermind.viewcontroller.MastermindViewController;

/**
 * Implementation of {@link ControllerFactory}.
 */
public class ControllerFactoryImpl implements ControllerFactory {

    /**
     * Builds a new {@link ControllerFactoryImpl}.
     */
    public ControllerFactoryImpl() {
    }

    @Override
    public final <U> GenericController<U> createMainMenuController() {
        return new GenericController<U>(MainMenuViewController.class);
    }

    @Override
    public final <U> GenericController<U> createGameCreationMenuController() {
        return new GenericController<U>(GameCreationMenuViewController.class);
    }

    @Override
    public final <U> GenericController<U> createMastermind(final List<U> players) {
        return new GenericController<U>(players, MastermindViewController.class);
    }

}

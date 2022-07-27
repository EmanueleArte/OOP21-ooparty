package utils.factories;

import java.util.List;

import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewControllerImpl;
import menu.mainmenu.viewcontroller.MainMenuViewControllerImpl;
import minigames.mastermind.viewcontroller.MastermindViewController;

/**
 * Implementation of {@link ViewControllerFactory}.
 */
public class ViewControllerFactoryImpl implements ViewControllerFactory {

    /**
     * Builds a new {@link ViewControllerFactoryImpl}.
     */
    public ViewControllerFactoryImpl() {
    }

    @Override
    public final <U> GenericController<U> createMainMenuController() {
        return new GenericController<U>(MainMenuViewControllerImpl.class);
    }

    @Override
    public final <U> GenericController<U> createGameCreationMenuController() {
        return new GenericController<U>(GameCreationMenuViewControllerImpl.class);
    }

    @Override
    public final <U> GenericController<U> createMastermind(final List<U> players) {
        return new GenericController<U>(players, MastermindViewController.class);
    }

}

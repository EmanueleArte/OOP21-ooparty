package utils.factories;

import java.util.List;

import menu.gamecreationmenu.viewcontroller.GameCreationMenuViewControllerImpl;
import menu.mainmenu.viewcontroller.MainMenuViewControllerImpl;
import minigames.mastermind.viewcontroller.MastermindViewControllerImpl;

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
    public final <U> GenericControllerCallback<U> createMainMenuController() {
        return new GenericControllerCallback<U>(MainMenuViewControllerImpl.class);
    }

    @Override
    public final <U> GenericControllerCallback<U> createGameCreationMenuController() {
        return new GenericControllerCallback<U>(GameCreationMenuViewControllerImpl.class);
    }

    @Override
    public final <U> GenericControllerCallback<U> createMastermind(final List<U> players) {
        return new GenericControllerCallback<U>(players, MastermindViewControllerImpl.class);
    }

}

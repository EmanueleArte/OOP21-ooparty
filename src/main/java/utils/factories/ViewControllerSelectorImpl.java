package utils.factories;

import java.util.List;

import javafx.util.Callback;
import utils.enums.ViewControllerType;

/**
 * Implementation of {@link ViewControllerSelector}.
 */
public class ViewControllerSelectorImpl implements ViewControllerSelector {

    private final ViewControllerFactory controlFactory;

    /**
     * Builds a new {@link ViewControllerSelectorImpl}.
     */
    public ViewControllerSelectorImpl() {
        this.controlFactory = new ViewControllerFactoryImpl();
    }

    @Override
    public final <U> Callback<Class<?>, Object> selectControllerCallback(final ViewControllerType vc,
            final List<U> players) {
        switch (vc) {
        case MAIN_MENU:
            return this.controlFactory.createMainMenuController();
        case GAME_CREATION_MENU:
            return this.controlFactory.createGameCreationMenuController();
        case MASTERMIND:
            return this.controlFactory.createMastermind(players);
        default:
            return null;
        }
    }

}

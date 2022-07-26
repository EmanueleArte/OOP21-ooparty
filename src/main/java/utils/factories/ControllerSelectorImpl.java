package utils.factories;

import java.util.List;

import javafx.util.Callback;
import utils.enums.ControllerType;

/**
 * Implementation of {@link ControllerSelector}.
 */
public class ControllerSelectorImpl implements ControllerSelector {

    private final ControllerFactory controlFactory;

    /**
     * Builds a new {@link ControllerSelectorImpl}.
     */
    public ControllerSelectorImpl() {
        this.controlFactory = new ControllerFactoryImpl();
    }

    @Override
    public final <U> Callback<Class<?>, Object> selectControllerCallback(final ControllerType controller,
            final List<U> players) {
        switch (controller) {
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

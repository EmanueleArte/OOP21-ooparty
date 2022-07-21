package utils.factories;

import java.util.List;

import javafx.util.Callback;
import utils.enums.ControllerType;
import utils.graphics.StageManager;

/**
 * Implementation of {@link ControllerSelector}.
 * 
 * @param <S> the scenes of the stage
 */
public class ControllerSelectorImpl<S> implements ControllerSelector<S> {

    private final ControllerFactory<S> controlFactory;

    /**
     * Builds a new {@link ControllerSelectorImpl}.
     * 
     * @param s the {@link utils.graphics.StageManager}
     */
    public ControllerSelectorImpl(final StageManager<S> s) {
        this.controlFactory = new ControllerFactoryImpl<>(s);
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

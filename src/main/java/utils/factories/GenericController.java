package utils.factories;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import javafx.util.Callback;
import utils.graphics.stagemanager.StageManager;

/**
 * This class models a generic controller creation.
 * 
 * @param <U> the {@link game.player.Player}
 */
class GenericController<U> implements Callback<Class<?>, Object> {

    private final Class<?> controllerClass;
    private final Optional<List<U>> players;

    /**
     * Builds a new {@link GenericController}.
     * 
     * @param players         the list of players
     * @param controllerClass the class of the controller
     */
    GenericController(final List<U> players, final Class<?> controllerClass) {
        super();
        this.controllerClass = controllerClass;
        this.players = Optional.ofNullable(players);
    }

    /**
     * Builds a new {@link GenericController} with no players.
     * 
     * @param s               the {@link utils.graphics.stagemanager.StageManager}
     * @param controllerClass the class of the controller
     */
    GenericController(final Class<?> controllerClass) {
        this(null, controllerClass);
    }

    @Override
    public Object call(final Class<?> param) {
        try {
            if (this.players.isPresent()) {
                return this.controllerClass.getConstructor(StageManager.class, List.class)
                        .newInstance(this.players.get());
            } else {
                return this.controllerClass.getConstructor(StageManager.class).newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

}

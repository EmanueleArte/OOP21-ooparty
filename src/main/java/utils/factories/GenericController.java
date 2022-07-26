package utils.factories;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import javafx.util.Callback;
import utils.graphics.stagemanager.StageManager;

/**
 * This class models a generic controller creation.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
class GenericController<S, U> implements Callback<Class<?>, Object> {

    private final StageManager<S> stageManager;
    private final Class<?> controllerClass;
    private final Optional<List<U>> players;

    /**
     * Builds a new {@link GenericController}.
     * 
     * @param s               the {@link utils.graphics.stagemanager.StageManager}
     * @param players         the list of players
     * @param controllerClass the class of the controller
     */
    GenericController(final StageManager<S> s, final List<U> players, final Class<?> controllerClass) {
        super();
        this.stageManager = s;
        this.controllerClass = controllerClass;
        this.players = Optional.ofNullable(players);
    }

    GenericController(final StageManager<S> s, final Class<?> controllerClass) {
        this(s, null, controllerClass);
    }

    @Override
    public Object call(final Class<?> param) {
        try {
            if (this.players.isPresent()) {
                return this.controllerClass.getConstructor(StageManager.class, List.class)
                        .newInstance(this.stageManager, this.players.get());
            } else {
                return this.controllerClass.getConstructor(StageManager.class).newInstance(this.stageManager);
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

}

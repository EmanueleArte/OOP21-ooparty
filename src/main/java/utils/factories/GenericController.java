package utils.factories;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javafx.util.Callback;
import utils.graphics.StageManager;

/**
 * This class models a generic controller creation.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
class GenericController<S, U> implements Callback<Class<?>, Object> {

    private final StageManager<S> stageManager;
    private final Class<?> controllerClass;
    private final List<U> players;

    GenericController(final StageManager<S> s, final List<U> players, final Class<?> controllerClass) {
        super();
        this.stageManager = s;
        this.controllerClass = controllerClass;
        this.players = players;
    }

    GenericController(final StageManager<S> s, final Class<?> controllerClass) {
        this(s, null, controllerClass);
    }

    @Override
    public Object call(final Class<?> param) {
        try {
            if (this.players != null) {
                return this.controllerClass.getConstructor(StageManager.class, List.class)
                        .newInstance(this.stageManager, this.players);
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

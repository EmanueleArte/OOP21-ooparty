package utils.factories;

import java.lang.reflect.InvocationTargetException;
import javafx.util.Callback;

/**
 * This class models a generic controller creation.
 * 
 * @param <U> the {@link game.player.Player}
 */
class GenericControllerCallback<U> implements Callback<Class<?>, Object> {

    private final Class<?> controllerClass;

    /**
     * Builds a new {@link GenericControllerCallback} with no players.
     * 
     * @param s               the {@link utils.graphics.stagemanager.StageManager}
     * @param controllerClass the class of the controller
     */
    GenericControllerCallback(final Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    @Override
    public Object call(final Class<?> param) {
        try {
            return this.controllerClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

}

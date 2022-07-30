package utils.factories;

import java.lang.reflect.InvocationTargetException;
import javafx.util.Callback;

/**
 * This class models a generic controller creation.
 */
class GenericControllerCallback implements Callback<Class<?>, Object> {

    private final Class<?> viewControllerClass;

    /**
     * Builds a new {@link GenericControllerCallback} with no players.
     * 
     * @param controllerClass the class of the controller
     */
    GenericControllerCallback(final Class<?> viewControllerClass) {
        this.viewControllerClass = viewControllerClass;
    }

    @Override
    public Object call(final Class<?> param) {
        try {
            return this.viewControllerClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

}

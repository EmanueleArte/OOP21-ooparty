package utils.factories;

import java.util.List;

import javafx.util.Callback;
import utils.enums.ControllerType;

/**
 * This interface models a selector for the view controllers.
 * 
 * @param <S> the scenes of the stage
 */
public interface ControllerSelector<S> {

    /**
     * This method chooses the right controller to be implemented.
     * 
     * @param <U> the {@link game.player.Player}
     * @return the right controller callback
     */
    <U> Callback<Class<?>, Object> selectControllerCallback(ControllerType controller, List<U> players);

}

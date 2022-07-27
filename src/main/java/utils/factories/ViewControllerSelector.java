package utils.factories;

import java.util.List;

import javafx.util.Callback;
import utils.enums.ViewControllerType;

/**
 * This interface models a selector for the view controllers.
 */
public interface ViewControllerSelector {

    /**
     * This method chooses the right controller to be implemented.
     * 
     * @param <U> the {@link game.player.Player}
     * @return the right controller callback
     */
    <U> Callback<Class<?>, Object> selectControllerCallback(ViewControllerType controller, List<U> players);

}

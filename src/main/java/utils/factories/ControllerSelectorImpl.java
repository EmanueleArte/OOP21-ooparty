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

    final private ControllerFactory<S> controlFactory;

    public ControllerSelectorImpl(final StageManager<S> s) {
        this.controlFactory = new ControllerFactoryImpl<>(s);
    }

    @Override
    public final <U> Callback<Class<?>, Object> selectControllerCallback(final ControllerType controller, final List<U> players) {
        // TODO Auto-generated method stub
        return null;
    }

}

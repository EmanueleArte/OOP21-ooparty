package utils.factories;

import java.lang.reflect.InvocationTargetException;
import javafx.util.Callback;
import utils.graphics.StageManager;

/**
 * This class models a generic controller creation.
 * @param <S> the scenes of the stage
 */
class GenericController<S> implements Callback<Class<?>, Object> {
	
	final StageManager<S> stageManager;
	final Class<?> controllerClass;
	
	public GenericController(final StageManager<S> s, final Class<?> controllerClass) {
		super();
		this.stageManager = s;
		this.controllerClass = controllerClass;
		
	}

	@Override
	public Object call(Class<?> param) {
		try {
			return this.controllerClass.getConstructor(StageManager.class).newInstance(this.stageManager);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

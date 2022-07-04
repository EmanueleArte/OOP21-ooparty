package utils.factories;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javafx.util.Callback;
import utils.graphics.StageManager;

/**
 * This class models a generic controller creation.
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
class GenericController<S, U> implements Callback<Class<?>, Object> {
	
	final StageManager<S> stageManager;
	final Class<?> controllerClass;
	final List<U> players;
	
	public GenericController(final StageManager<S> s, final List<U> players, final Class<?> controllerClass) {
		super();
		this.stageManager = s;
		this.controllerClass = controllerClass;
		this.players = players;
	}
	
	public GenericController(final StageManager<S> s, final Class<?> controllerClass) {
		this(s, null, controllerClass);
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

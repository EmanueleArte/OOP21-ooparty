package utils;

import java.util.List;

import javafx.scene.Scene;

/**
 * This interface models a stage manager for javafx.
 * @param <S> the scenes of the stage
 */
public interface StageManager<S> {
	
	/**
	 * This method adds a scene to the scene list.
	 */
	void addScene(Scene s);
	
	/**
	 * This method pops a scene from the scene list.
	 * @return the last scene added
	 */
	Scene popScene();
	
	/**
	 * This method shows a scene.
	 */
	void setScene();
	
	/**
	 * This method starts the javafx gui.
	 * @param args
	 */
	void run(String[] args);
	
	/**
	 *  This method returns the list of all scenes.
	 * @param <U>
	 * @return the scenes of the stage
	 */
	<U> List<U> getScenes();

}

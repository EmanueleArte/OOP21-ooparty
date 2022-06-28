package utils;

import java.util.List;

/**
 * This interface models a stage manager for javafx.
 * @param <S> the scenes of the stage
 */
public interface StageManager<S> {
	
	/**
	 * This method adds a scene to the scene list.
	 */
	void addScene(S s);
	
	/**
	 * This method pops a scene from the scene list.
	 * @return the last scene added
	 */
	S popScene();
	
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
	 * @return the scenes of the stage
	 */
	List<S> getScenes();

}

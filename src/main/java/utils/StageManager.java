package utils;

import javafx.scene.Scene;

/**
 * This interface models a stage manager for javafx.
 */
public interface StageManager {
	
	/**
	 * This method adds a scene to the scene list.
	 */
	void addScene();
	
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

}

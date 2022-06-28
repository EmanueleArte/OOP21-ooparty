package utils;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;

/**
 * Implementation of {@link StageManager}.
 */
public class StageManagerAbstr<S> extends Application implements StageManager<S> {

	final private List<S> scenes;
	
	public StageManagerAbstr() {
		this.scenes = new ArrayList<S>();
	}

	@Override
	public void addScene(final Scene s) {
		
	}

	@Override
	public Scene popScene() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScene() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}

}

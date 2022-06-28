package utils.graphics;

import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;

/**
 * Implementation of {@link StageManager}.
 */
public class StageManagerImpl<S> extends Application implements StageManager<S> {

	final private List<S> scenes;
	private Stage primaryStage;
	
	public StageManagerImpl() {
		this.scenes = new ArrayList<S>();
	}

	@Override
	public void addScene(final S s) {
		this.scenes.add(s);
	}
	
	@Override
	public S popScene() {
		return this.scenes.remove(this.lastSceneIndex());
	}

	@Override
	public void setScene() {
		this.primaryStage.setScene((Scene) this.scenes.get(this.lastSceneIndex()));
	}

	@Override
	public void run(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("OOParty");
        primaryStage.setMaximized(true);
        this.primaryStage = primaryStage;
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));     
        this.primaryStage.show();
        while (true) {
        	if(!this.primaryStage.getScene().equals(this.scenes.get(this.lastSceneIndex()))) {
        		this.setScene();
        	}
        }
	}

	@Override
	public List<S> getScenes() {
		return this.scenes;
	}
	
	/**
	 * This method calculates the index of the last added scene.
	 * @return the index of the last added scene
	 */
	private int lastSceneIndex() {
		return this.scenes.size() - 1;
	}

}

package utils.graphics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Implementation of {@link StageManager}.
 */
public class StageManagerImpl<S> extends JFrame implements StageManager<S> {

	private static final long serialVersionUID = -2502020530541111808L;
	final private List<S> scenes;
	private JFXPanel mainStage;
	
	public StageManagerImpl() {
		this.scenes = new ArrayList<S>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addScene(final String fxmlUrl) {
		Platform.runLater(() -> {
			Parent root = null;
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlUrl));
			try {
				root = loader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.scenes.add((S) new Scene(root));
			this.setScene();
        });
	}
	
	@Override
	public S popScene() {
		return this.scenes.remove(this.lastSceneIndex());
	}

	@Override
	public void setScene() {
		this.mainStage.setScene((Scene) this.scenes.get(this.lastSceneIndex()));
	}

	@Override
	public void run() {
		final JFrame frame = new JFrame("OOParty");
		this.mainStage = new JFXPanel();
        frame.add(this.mainStage);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}

	/*@Override
	public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("OOParty");
        
        final String fxmlUrl = "menu/main_menu.fxml";
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlUrl));
		primaryStage.setScene(new Scene(root));
		
		this.primaryStage = primaryStage;
        this.primaryStage.setMaximized(true);
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
		this.primaryStage.show();
		
        if (this.scenes.size() != 0) {
	        if (!this.primaryStage.getScene().equals(this.scenes.get(this.lastSceneIndex()))) {
	    		this.setScene();
	    	}
        }
        /*while (true) {
        	if(!this.primaryStage.getScene().equals(this.scenes.get(this.lastSceneIndex()))) {
        		this.setScene();
        	}
        }
	}*/

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

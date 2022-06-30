package utils.graphics;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Callback;
import utils.enums.Controller;
import utils.factories.ControllerFactory;
import utils.factories.ControllerFactoryImpl;

/**
 * Implementation of {@link StageManager}.
 */
public class StageManagerImpl<S> extends JFrame implements StageManager<S> {

	private static final long serialVersionUID = -2502020530541111808L;
	final private List<S> scenes;
	private JFXPanel mainStage;
	private FXMLLoader loader;
	private final JFrame frame;
	private final ControllerFactory<S> controlFactory;
	static GraphicsDevice device = GraphicsEnvironment
	        .getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	public StageManagerImpl(final String title) {
		this.scenes = new ArrayList<S>();
		this.frame = new JFrame(title);
		this.controlFactory = new ControllerFactoryImpl<>(this);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void addScene(final String fxmlUrl, final Controller c) {
		Platform.runLater(() -> {
			Parent root = null;
			this.loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlUrl));
			this.loader.setControllerFactory(this.controllerCallback(c));
			try {
				root = loader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (root != null) {
				this.scenes.add((S) new Scene(root));
				this.setScene();
			}
        });
	}
	
	@Override
	public S popScene() {
		var poppedScene = this.scenes.remove(this.lastSceneIndex());
		this.setScene();
		return poppedScene;
	}

	@Override
	public void run() {
		this.mainStage = new JFXPanel();
		this.mainStage.setMinimumSize(new Dimension(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight()));
		this.mainStage.setMaximumSize(new Dimension(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight()));
        this.frame.add(this.mainStage);
        this.frame.pack();
        //this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        device.setFullScreenWindow(frame);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
	}

	@Override
	public List<S> getScenes() {
		return this.scenes;
	}
	
	/**
	 * This method shows the actual scene.
	 */
	private void setScene() {
		this.mainStage.setScene((Scene) this.scenes.get(this.lastSceneIndex()));
	}
	
	/**
	 * This method calculates the index of the last added scene.
	 * @return the index of the last added scene
	 */
	private int lastSceneIndex() {
		return this.scenes.size() - 1;
	}
	
	/**
	 * This method chooses the right controller to be implemented.
	 * @return the right controller callback
	 */
	private Callback<Class<?>, Object> controllerCallback(final Controller controller) {
		switch(controller) {
			case MAIN_MENU:
				return this.controlFactory.createMainMenuController();
			case GAME_CREATION_MENU:
				return this.controlFactory.createGameCreationMenuController();
			default:
				return null;
		}
	}

}

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
import javafx.util.Callback;
import menu.mainmenu.control.MainMenuController;
import menu.mainmenu.control.MainMenuControllerImpl;

/**
 * Implementation of {@link StageManager}.
 */
public class StageManagerImpl<S> extends JFrame implements StageManager<S> {

	private static final long serialVersionUID = -2502020530541111808L;
	final private List<S> scenes;
	private JFXPanel mainStage;
	private FXMLLoader loader;
	private final JFrame frame;
	
	public StageManagerImpl(final String title) {
		this.scenes = new ArrayList<S>();
		this.frame = new JFrame(title);
	}

	class Prova<S> implements Callback {
		
		final StageManager<S> s;
		
		public Prova(final StageManager<S> s) {
			super();
			this.s = s;
		}
		
		@Override
		public Object call(Object param) {
			return new MainMenuControllerImpl<>(this.s);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void addScene(final String fxmlUrl) {
		Platform.runLater(() -> {
			Parent root = null;
			this.loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlUrl));
			Prova<S> a = new Prova<S>(this);
			this.loader.setControllerFactory(a);
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
		return this.scenes.remove(this.lastSceneIndex());
	}

	@Override
	public void setScene() {
		this.mainStage.setScene((Scene) this.scenes.get(this.lastSceneIndex()));
	}

	@Override
	public void run() {
		this.mainStage = new JFXPanel();
        this.frame.add(this.mainStage);
        this.frame.pack();
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
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

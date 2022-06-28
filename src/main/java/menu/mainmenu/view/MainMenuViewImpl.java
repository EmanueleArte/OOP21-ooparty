package menu.mainmenu.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MainMenuView}.
 */
public class MainMenuViewImpl<S> implements MainMenuView<S> {

	final private StageManager<S> stageManager;
	
	public MainMenuViewImpl(final StageManager<S> s) {
		super();
		this.stageManager = s;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void createMainMenu() {
		final String fxmlUrl = "menu/main_menu.fxml";
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlUrl));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (root != null) {
			this.stageManager.addScene((S) new Scene(root));
		} else {
			System.exit(1);
		}
        
        
	}

}

package menu.gamecreationmenu.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Implementation of {@link GameCreationMenuView}.
 */
public class GameCreationMenuViewImpl implements GameCreationMenuView {

	private Scene creationScene;
	private Stage primaryStage;
	private Scene backupScene;
	
	public GameCreationMenuViewImpl(final Stage s) {
		super();
		this.primaryStage = s;
	}
	
	/**
	 * This method shows the graphical interface of the game creation menu.
	 */
	private void showView() {
		this.backupScene = this.primaryStage.getScene();
		this.primaryStage.setScene(this.creationScene);
	}

	@Override
	public void startGameCreationMenu() {
		final String fxmlUrl = "creation_menu.fxml";
        Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlUrl));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        this.creationScene = new Scene(root);
        this.showView();
	}

}

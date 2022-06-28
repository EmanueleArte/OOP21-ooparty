package menu.gamecreationmenu.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Implementation of {@link MainMenuView}.
 */
public class CreationMenuViewImpl extends Application implements CreationMenuView {

	private Stage creationStage;
	private final Stage primaryStage;
	
	public CreationMenuViewImpl(final Stage s) {
		super();
		this.primaryStage = s;
	}
	
	/**
	 * This method shows the graphical interface of the main menu.
	 */
	private void showView() {
		this.primaryStage.hide();
		this.creationStage.show();
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		final String fxmlUrl = "main_menu.fxml";
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlUrl));
        final Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("OOParty");
        primaryStage.setMaximized(true);
        this.creationStage = primaryStage;
        this.creationStage.setOnCloseRequest(e -> System.exit(0));
        this.showView();
	}

	@Override
	public void run(final String[] args) {
        launch();
	}

}

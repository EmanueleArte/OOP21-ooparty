package menu.mainmenu.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenuViewImpl extends Application implements MainMenuView {

	private Stage primaryStage;
	static final Font fontButton = new Font(50);
	static final Font fontTitle = new Font(70);
	static final Insets insets = new Insets(40);
	
	public MainMenuViewImpl() {
		super();
	}
	
	/**
	 * This method shows the graphical interface of the main menu.
	 */
	private void showView() {
		this.primaryStage.show();
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		final String fxmlUrl = "main_menu.fxml";
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlUrl));
        final Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("OOParty");
        primaryStage.setMaximized(true);
        this.primaryStage = primaryStage;
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        this.showView();
	}

	@Override
	public void run(final String[] args) {
        launch();
	}

}

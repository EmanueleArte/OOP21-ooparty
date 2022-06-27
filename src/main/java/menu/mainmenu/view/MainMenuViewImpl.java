package menu.mainmenu.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenuViewImpl extends Application implements MainMenuView {

	private Stage primaryStage;
	static final Font fontButton = new Font(50);
	static final Font fontTitle = new Font(70);
	static final Insets insets = new Insets(40);

	/**
	 * This method shows the graphical interface of the main menu.
	 */
	private void showView() {
		this.primaryStage.show();
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		final Button gameButton = new Button("Create game");
		gameButton.setFont(MainMenuViewImpl.fontButton);
		final Button exitButton = new Button("Exit");
		exitButton.setFont(MainMenuViewImpl.fontButton);
        final Label gameTitle = new Label("OOParty");
        gameTitle.setFont(MainMenuViewImpl.fontTitle);
        final BorderPane menuPane = new BorderPane();
        BorderPane.setAlignment(gameTitle, Pos.CENTER);
        final VBox vbox = new VBox(gameButton, exitButton);
        VBox.setMargin(gameButton, MainMenuViewImpl.insets); 
        vbox.setAlignment(Pos.CENTER);
        menuPane.setTop(gameTitle);
        BorderPane.setMargin(gameTitle, MainMenuViewImpl.insets);
        menuPane.setCenter(vbox);
        final Scene scene = new Scene(menuPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("OOParty");
        primaryStage.setMaximized(true);
        this.primaryStage = primaryStage;
        this.showView();
	}
	
	@Override
	public void run(final String[] args) {
        launch();
    }

}

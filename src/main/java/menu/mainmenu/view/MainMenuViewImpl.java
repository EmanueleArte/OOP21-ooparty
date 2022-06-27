package menu.mainmenu.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenuViewImpl extends Application implements MainMenuView {

	private Stage primaryStage;

	@Override
	public void showView() {
		this.primaryStage.show();
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		final Button button = new Button("Create a new stage!");
        button.setFont(new Font(100));
        primaryStage.setScene(new Scene(button));
        primaryStage.setTitle("Hello");
        this.primaryStage = primaryStage;
	}
	
	@Override
	public void run(final String[] args) {
        launch();
    }

}

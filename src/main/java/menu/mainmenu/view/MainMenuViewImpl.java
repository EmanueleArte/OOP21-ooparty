package menu.mainmenu.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainMenuViewImpl extends Application implements MainMenuView {

	private Stage primaryStage;

	@Override
	public void showView() {
		this.primaryStage.show();
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
	}
	
	public static void run(final String[] args) {
        launch();
    }

}

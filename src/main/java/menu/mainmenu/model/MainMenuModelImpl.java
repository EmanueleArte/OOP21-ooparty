package menu.mainmenu.model;

import javafx.application.Platform;
import javafx.stage.Stage;

public class MainMenuModelImpl implements MainMenuModel {

	private final Stage primaryStage;
	
	public MainMenuModelImpl(final Stage stage) {
		this.primaryStage = stage;
	}

	@Override
	public void exit() {
		Platform.exit();
		System.exit(0);
	}

	@Override
	public void gameCreationMenu() {
		// TODO Auto-generated method stub
		
	}

}

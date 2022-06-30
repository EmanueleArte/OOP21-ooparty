package menu.gamecreationmenu.control;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import menu.gamecreationmenu.model.GameCreationMenuModel;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import utils.enums.PlayerColor;
import utils.graphics.StageManager;

/**
 * Implementation of {@link GameCreationMenuController}.
 */
public class GameCreationMenuControllerImpl<S> implements GameCreationMenuController<S> {

	private GameCreationMenuModel<S> gameCreationMenuModel;
	@FXML private Button returnMainMenuButton;
	@FXML private Button startGameButton;
	@FXML private Spinner numberOfPlayers;
	@FXML private TextField nickname1;
	@FXML private List<ComboBox<PlayerColor>> playerColors;
	
	public GameCreationMenuControllerImpl(final StageManager<S> s) {
		super();
		this.gameCreationMenuModel = new GameCreationMenuModelImpl<>(s);
	}
	
	@FXML
	private void initialize() {
		this.playerColors.forEach(color -> {
			color.setItems(FXCollections.observableArrayList(PlayerColor.values()));
			color.getSelectionModel().selectFirst();
		});
		//this.color1.setItems(FXCollections.observableArrayList(PlayerColor.values()));
		//this.color1.getSelectionModel().selectFirst();
	}
	
	@Override
	public void returnToMainMenu() {
		this.gameCreationMenuModel.returnToMainMenu();
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

	

}

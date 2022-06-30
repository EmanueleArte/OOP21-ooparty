package menu.gamecreationmenu.control;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import menu.gamecreationmenu.model.GameCreationMenuModel;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import utils.IntSpinnerValueFactory;
import utils.enums.PlayerColor;
import utils.graphics.StageManager;

/**
 * Implementation of {@link GameCreationMenuController}.
 */
public class GameCreationMenuControllerImpl<S> implements GameCreationMenuController<S> {

	private GameCreationMenuModel<S> gameCreationMenuModel;
	@FXML private Button returnMainMenuButton;
	@FXML private Button startGameButton;
	@FXML private Spinner<Integer> numberOfPlayers;
	@FXML private List<TextField> PlayersNicknames;
	@FXML private List<ComboBox<PlayerColor>> playerColors;
	@FXML private List<VBox> playersForms;
	
	public GameCreationMenuControllerImpl(final StageManager<S> s) {
		super();
		this.gameCreationMenuModel = new GameCreationMenuModelImpl<>(s);
	}
	
	@FXML
	private void initialize() {
		this.gameCreationMenuModel.setNumberOfPlayersSpinner(this.numberOfPlayers);
		this.gameCreationMenuModel.fillColorsBoxes(this.playerColors);
	}
	
	@Override
	public void returnToMainMenu() {
		this.gameCreationMenuModel.returnToMainMenu();
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPlayersForms() {
		this.gameCreationMenuModel.showForms(this.playersForms, this.numberOfPlayers.getValue());
	}

	

}

package menu.gamecreationmenu.control;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import menu.gamecreationmenu.model.GameCreationMenuModel;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import utils.enums.PlayerColor;
import utils.graphics.StageManager;

/**
 * Implementation of {@link GameCreationMenuController}.
 */
public class GameCreationMenuControllerImpl<S> implements GameCreationMenuController<S> {

	private final GameCreationMenuModel<S> gameCreationMenuModel;
	@FXML private Button returnMainMenuButton;
	@FXML private Button startGameButton;
	@FXML private Spinner<Integer> numberOfPlayers;
	@FXML private Spinner<Integer> turnsNumber;
	@FXML private List<TextField> playersNicknames;
	@FXML private List<ComboBox<PlayerColor>> playerColors;
	@FXML private List<VBox> playersForms;
	@FXML private Label noticeLabel;
	
	public GameCreationMenuControllerImpl(final StageManager<S> s) {
		super();
		this.gameCreationMenuModel = new GameCreationMenuModelImpl<>(s);
	}
	
	@FXML
	private void initialize() {
		this.gameCreationMenuModel.setNumberOfPlayersSpinner(this.numberOfPlayers);
		this.gameCreationMenuModel.setTurnsNumberSpinner(this.turnsNumber);
		this.gameCreationMenuModel.fillColorsBoxes(this.playerColors);
		this.numberOfPlayers.getValueFactory().valueProperty().addListener(value -> this.showPlayersForms());
		this.gameCreationMenuModel.setNotice(this.noticeLabel);
		this.showPlayersForms();
	}
	
	@Override
	public void returnToMainMenu() {
		this.gameCreationMenuModel.returnToMainMenu();
	}

	@Override
	public void startGame() {
		this.gameCreationMenuModel.startGame(this.playersNicknames, this.playerColors, this.turnsNumber);
	}

	@Override
	public void showPlayersForms() {
		this.gameCreationMenuModel.showForms(this.playersForms, this.numberOfPlayers.getValue());
	}

	@Override
	public void clearNotice() {
		this.gameCreationMenuModel.clearNotice();
	}
	
}

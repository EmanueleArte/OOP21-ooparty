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
 * This class models the game creation menu view controller.
 * 
 * @param <S> the scenes of the stage
 */
public class GameCreationMenuViewController<S> {

    private final GameCreationMenuModel<S> gameCreationMenuModel;
    @FXML
    private Spinner<Integer> numberOfPlayers;
    @FXML
    private Spinner<Integer> turnsNumber;
    @FXML
    private List<TextField> playersNicknames;
    @FXML
    private List<ComboBox<PlayerColor>> playerColors;
    @FXML
    private List<VBox> playersForms;
    @FXML
    private Label noticeLabel;

    public GameCreationMenuViewController(final StageManager<S> s) {
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

    /**
     * This method returns to the main menu of the game.
     */
    @FXML
    private void returnToMainMenu() {
        this.gameCreationMenuModel.returnToMainMenu();
    }

    /**
     * This method starts a new game.
     */
    @FXML
    private void startGame() {
        this.gameCreationMenuModel.startGame(this.playersNicknames, this.playerColors, this.turnsNumber);
    }

    /**
     * This method shows only the necessary players forms.
     */
    private void showPlayersForms() {
        this.gameCreationMenuModel.showForms(this.playersForms, this.numberOfPlayers.getValue());
    }

    /**
     * This method clears the notice.
     */
    private void clearNotice() {
        this.gameCreationMenuModel.clearNotice();
    }

}

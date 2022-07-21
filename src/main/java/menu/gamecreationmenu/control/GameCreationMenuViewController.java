package menu.gamecreationmenu.control;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import menu.gamecreationmenu.model.GameCreationMenuModel;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import utils.NoticeUserAbstr;
import utils.enums.Notice;
import utils.enums.PlayerColor;
import utils.graphics.StageManager;

/**
 * This class models the game creation menu view controller.
 * 
 * @param <S> the scenes of the stage
 */
public class GameCreationMenuViewController<S> extends NoticeUserAbstr {

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

    /**
     * Builds a new {@link GameCreationMenuViewController}.
     * 
     * @param s the {@link utils.graphics.StageManager}.
     */
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
        if (!this.gameCreationMenuModel.startGame(this.playersNicknames, this.playerColors, this.turnsNumber)) {
            this.showNotice(Notice.GAME_CREATION_ERROR.getNotice());
        }
    }

    /**
     * This method shows only the necessary players forms.
     */
    private void showPlayersForms() {
        this.showForms(this.numberOfPlayers.getValue());
    }

    /**
     * This method shows only the necessary players forms.
     * 
     * @param nPlayers the selected number of players
     */
    private void showForms(final Integer nPlayers) {
        for (int i = GameCreationMenuModelImpl.N_MIN_PLAYERS; i < GameCreationMenuModelImpl.N_MAX_PLAYERS; i++) {
            var form = playersForms.get(i);
            if (i >= nPlayers) {
                this.hideForm(form);
            } else {
                this.showForm(form);
            }
        }
        this.gameCreationMenuModel.setActualNPlayers(nPlayers);
    }

    /**
     * This method shows a player form.
     * 
     * @param form the player form
     */
    private void showForm(final VBox form) {
        form.setVisible(true);
        form.setManaged(true);
    }

    /**
     * This method hides a player form.
     * 
     * @param form the player form
     */
    private void hideForm(final VBox form) {
        form.setVisible(false);
        form.setManaged(false);
    }

}

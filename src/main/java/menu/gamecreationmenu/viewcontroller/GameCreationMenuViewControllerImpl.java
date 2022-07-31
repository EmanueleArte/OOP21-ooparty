package menu.gamecreationmenu.viewcontroller;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import menu.MenuController;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import utils.NoticeUserAbstr;
import utils.controller.GenericController;
import utils.GuiUtils;
import utils.enums.Notice;
import utils.enums.PlayerColor;

/**
 * Extension of {@link NoticeUserAbstr} and implementation of
 * {@link GameCreationMenuViewController}.
 */
public class GameCreationMenuViewControllerImpl extends NoticeUserAbstr implements GameCreationMenuViewController {

    private MenuController menuController;
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
     * Builds a new {@link GameCreationMenuViewControllerImpl}.
     */
    public GameCreationMenuViewControllerImpl() {
    }

    @FXML
    private void initialize() {
        GuiUtils.fillColorsBoxes(this.playerColors);
        this.setNumberOfPlayersSpinner();
        this.setTurnsNumberSpinner();
        this.numberOfPlayers.getValueFactory().valueProperty().addListener(value -> this.showPlayersForms());
        this.showPlayersForms();
    }

    /**
     * This method returns to the main menu of the game.
     */
    @FXML
    private void returnToMainMenu() {
        this.menuController.exit();
    }

    /**
     * This method starts a new game.
     */
    @FXML
    private void startGame() {
        this.menuController.goNext();
    }

    @Override
    public final void setController(final GenericController controller) throws IllegalArgumentException {
        if (controller instanceof MenuController) {
            this.menuController = (MenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MenuController");
        }
    }

    @Override
    public final List<PlayerColor> getColorsValues() {
        final List<PlayerColor> valuesList = new ArrayList<>();
        this.playerColors.forEach(element -> valuesList.add(element.getValue()));
        return valuesList;
    }

    @Override
    public final List<String> getPlayersNicknames() {
        final List<String> valuesList = new ArrayList<>();
        this.playersNicknames.forEach(element -> valuesList.add(element.getText()));
        return valuesList;
    }

    @Override
    public final int getTurnsNumber() {
        return this.turnsNumber.getValue();
    }

    @Override
    public final int getActualNumberOfPlayers() {
        return this.numberOfPlayers.getValue();
    }

    @Override
    public final void showError() {
        this.showNotice(Notice.GAME_CREATION_ERROR.getNotice());
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
                GuiUtils.hideForm(form);
            } else {
                GuiUtils.showForm(form);
            }
        }
    }

    /**
     * This method sets the value factory for the number of players spinner.
     */
    private void setNumberOfPlayersSpinner() {
        GuiUtils.setSpinnerControls(this.numberOfPlayers, GameCreationMenuModelImpl.N_MIN_PLAYERS,
                GameCreationMenuModelImpl.N_MAX_PLAYERS);
    }

    /**
     * This method sets the value factory for the number of turns spinner.
     */
    private void setTurnsNumberSpinner() {
        GuiUtils.setSpinnerControls(this.turnsNumber, GameCreationMenuModelImpl.N_MIN_TURNS,
                GameCreationMenuModelImpl.N_MAX_TURNS);
    }

}

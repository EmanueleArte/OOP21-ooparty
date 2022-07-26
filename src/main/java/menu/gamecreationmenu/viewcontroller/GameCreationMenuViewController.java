package menu.gamecreationmenu.viewcontroller;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import menu.gamecreationmenu.controller.GameCreationMenuController;
import menu.gamecreationmenu.model.GameCreationMenuModelImpl;
import utils.IntSpinnerValueFactory;
import utils.NoticeUserAbstr;
import utils.enums.Notice;
import utils.enums.PlayerColor;

/**
 * This class models the game creation menu view controller.
 */
public class GameCreationMenuViewController extends NoticeUserAbstr {

    private GameCreationMenuController menuController;
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
     */
    public GameCreationMenuViewController() {
    }

    @FXML
    private void initialize() {
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
        this.menuController.setActualNumberOfPlayers(nPlayers);
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

    /**
     * This method sets the value factory for a generic number spinner.
     * 
     * @param spinner the spinner to be set
     * @param min     the min value
     * @param max     the max value
     */
    private void setSpinnerControls(final Spinner<Integer> spinner, final int min, final int max) {
        spinner.setValueFactory(new IntSpinnerValueFactory(min, max, min));
    }

    /**
     * This method fills the the combo box with colors which can be choose.
     */
    public final void fillColorsBoxes() {
        playerColors.forEach(colors -> {
            colors.setItems(FXCollections.observableArrayList(PlayerColor.values()));
            colors.getSelectionModel().selectFirst();
        });
    }

    /**
     * This method sets the value factory for the number of players spinner.
     */
    private void setNumberOfPlayersSpinner() {
        this.setSpinnerControls(this.numberOfPlayers, GameCreationMenuModelImpl.N_MIN_PLAYERS,
                GameCreationMenuModelImpl.N_MAX_PLAYERS);
    }

    /**
     * This method sets the value factory for the number of turns spinner.
     */
    private void setTurnsNumberSpinner() {
        this.setSpinnerControls(this.turnsNumber, GameCreationMenuModelImpl.N_MIN_TURNS,
                GameCreationMenuModelImpl.N_MAX_TURNS);
    }

    /**
     * Setter for menuController.
     * 
     * @param controller the {@link GameCreationMenuController}
     */
    public final void setGameCreationMenuController(final GameCreationMenuController controller) {
        this.menuController = controller;
    }

    /**
     * This method gets the players colors values.
     * 
     * @return the list of players colors
     */
    public List<PlayerColor> getColorsValues() {
        final List<PlayerColor> valuesList = new ArrayList<>();
        this.playerColors.forEach(element -> valuesList.add(element.getValue()));
        return valuesList;
    }

    /**
     * This method gets the players nicknames.
     * 
     * @return the list of players nicknames
     */
    public List<String> getPlayersNicknames() {
        final List<String> valuesList = new ArrayList<>();
        this.playersNicknames.forEach(element -> valuesList.add(element.getText()));
        return valuesList;
    }

    /**
     * This method gets the players nicknames.
     * 
     * @return the number of turns chosen
     */
    public int getTurnsNumber() {
        return this.turnsNumber.getValue();
    }

}

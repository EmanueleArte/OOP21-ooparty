package menu.gamecreationmenu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import game.player.Player;
import game.player.PlayerImpl;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import utils.IntSpinnerValueFactory;
import utils.enums.Notice;
import utils.enums.PlayerColor;
import utils.graphics.StageManager;

/**
 * Implementation of {@link GameCreationMenuModel}.
 */
public class GameCreationMenuModelImpl<S> implements GameCreationMenuModel<S> {

	public static final int nMinPlayers = 2;
	public static final int nMaxPlayers = 4;
	public static final int nMinTurns = 1;
	public static final int nMaxTurns = 20;
	private StageManager<S> stageManager;
	private int actualNPlayers;
	private Label noticeLabel;
	
	public GameCreationMenuModelImpl(final StageManager<S> s) {
		super();
		this.stageManager = s;
		this.actualNPlayers = GameCreationMenuModelImpl.nMinPlayers;
		this.noticeLabel = null;
	}

	@Override
	public void returnToMainMenu() {
		this.stageManager.popScene();
	}

	@Override
	public void startGame(final List<TextField> allPlayersNicknames, final List<ComboBox<PlayerColor>> allPlayerColors, 
			final Spinner<Integer> turnsNumber, final Label noticeLabel) {
		final List<String> playersNicknames = this.getNicknamesValues(allPlayersNicknames.subList(0, this.actualNPlayers));
		final List<PlayerColor> playersColors = this.getColorsValues(allPlayerColors.subList(0, this.actualNPlayers));
		if (!controlForms(playersNicknames, playersColors)) {
			if (this.noticeLabel == null) {
				this.noticeLabel = noticeLabel;
			}
			this.showNotice(Notice.GAME_CREATION_ERROR.getNotice());
		} else {
			// To complete with game constructor (parameters: playersList, stageManager, turnsNumber)
			this.createPlayersList(playersNicknames, playersColors);
		}
	}

	@Override
	public void fillColorsBoxes(final List<ComboBox<PlayerColor>> playerColors) {
		playerColors.forEach(colors -> {
			colors.setItems(FXCollections.observableArrayList(PlayerColor.values()));
 			colors.getSelectionModel().selectFirst();
		});
	}
		
	@Override
	public void setNumberOfPlayersSpinner(final Spinner<Integer> numberOfPlayers) {
		this.setSpinnerControls(numberOfPlayers, GameCreationMenuModelImpl.nMinPlayers, GameCreationMenuModelImpl.nMaxPlayers);
	}
	
	@Override
	public void setTurnsNumberSpinner(Spinner<Integer> turnsNumber) {
		this.setSpinnerControls(turnsNumber, GameCreationMenuModelImpl.nMinTurns, GameCreationMenuModelImpl.nMaxTurns);
	}

	@Override
	public void showForms(final List<VBox> playersForms, Integer nPlayers) {
		for (int i = GameCreationMenuModelImpl.nMinPlayers; i < GameCreationMenuModelImpl.nMaxPlayers; i++) {
			var form = playersForms.get(i);
			if (i >= nPlayers) {
				this.hideForm(form);
			} else {
				this.showForm(form);
			}
		}
		this.actualNPlayers = nPlayers;
	}
	
	@Override
	public void clearNotice() {
		this.noticeLabel.setText("");
	}
	
	/**
	 * This method shows a player form.
	 * @param form the player form
	 */
	private void showForm(final VBox form) {
		form.setVisible(true);
		form.setManaged(true);
	}
	
	/**
	 * This method hides a player form.
	 * @param form the player form
	 */
	private void hideForm(final VBox form) {
		form.setVisible(false);
		form.setManaged(false);
	}
	
	/**
	 * This method sets the value factory for a generic number spinner.
	 * @param spinner the spinner to be set
	 * @param min the min value
	 * @param max the max value
	 */
	private void setSpinnerControls(final Spinner<Integer> spinner, final int min, final int max) {
		spinner.setValueFactory(new IntSpinnerValueFactory(min, max, min));
	}
	
	/**
	 * This method shows a notice into the gui.
	 * @param notice the notice to show
	 */
	private void showNotice(final String notice) {
		this.noticeLabel.setText(notice);
	}
	
	/**
	 * This method controls that there aren't duplicates or blank nicknames into the forms information.
	 * @param playersNicknames the list of players nicknames
	 * @param playerColors the list of players colors
	 * @return true if there aren't any duplicates or blank nicknames else false
	 */
	private boolean controlForms(final List<String> playersNicknames, final List<PlayerColor> playerColors) {
		boolean formsCorrect = true;
		final int nDiffNicknames = playersNicknames
				.stream()
				.distinct()
				.collect(Collectors.toList())
				.size();
		final int nDiffColors = playerColors
				.stream()
				.distinct()
				.collect(Collectors.toList())
				.size();
		if (nDiffNicknames < this.actualNPlayers || nDiffColors < this.actualNPlayers 
				|| playersNicknames.contains("")) {
			formsCorrect = false;
		}
		return formsCorrect;
	}
	
	/**
	 * This method gets the players colors values.
	 * @param list the list of players colors combo box.
	 * @return the list of players colors
	 */
	private List<PlayerColor> getColorsValues(List<ComboBox<PlayerColor>> list) {
		final List<PlayerColor> valuesList = new ArrayList<>();
		list.forEach(element -> valuesList.add(element.getValue()));
		return valuesList;
	}
	
	/**
	 * This method gets the players nicknames values.
	 * @param list the list of players nicknames text fields.
	 * @return the list of players nicknames
	 */
	private List<String> getNicknamesValues(List<TextField> list) {
		final List<String> valuesList = new ArrayList<>();
		list.forEach(element -> valuesList.add(element.getText()));
		return valuesList;
	}
	
	/**
	 * This method creates the list of players that will join the game.
	 * @param playersNicknames the list of players nicknames
	 * @param playerColors the list of players colors
	 * @return the list of the players
	 */
	private List<Player> createPlayersList(final List<String> playersNicknames, final List<PlayerColor> playerColors) {
		final List<Player> playersList = new ArrayList<>();
		playersNicknames.forEach(nickname -> {
			playersList.add(new PlayerImpl(nickname, playerColors.get(playersNicknames.indexOf(nickname)).getColor()));
		});
		return playersList;
	}
	
}

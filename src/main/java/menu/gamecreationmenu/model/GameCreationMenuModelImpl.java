package menu.gamecreationmenu.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import utils.IntSpinnerValueFactory;
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
	
	public GameCreationMenuModelImpl(final StageManager<S> s) {
		super();
		this.stageManager = s;
		this.actualNPlayers = GameCreationMenuModelImpl.nMinPlayers;
	}

	@Override
	public void returnToMainMenu() {
		this.stageManager.popScene();
	}

	@Override
	public void startGame(final List<TextField> allPlayersNicknames, final List<ComboBox<PlayerColor>> allPlayerColors, 
			Spinner<Integer> turnsNumber) {
		//final List<TextField> playersNicknames = allPlayersNicknames.subList(0, this.actualNPlayers);
		//final List<ComboBox<PlayerColor>> playerColors = allPlayerColors.subList(0, this.actualNPlayers);
		if (!controlForms(allPlayersNicknames.subList(0, this.actualNPlayers), allPlayerColors.subList(0, this.actualNPlayers))) {
			System.out.println("There are some nicknames or/and colors duplicated.");
		}
	}
	
	/**
	 * This method controls that there aren't duplicates into the forms information.
	 * @param playersNicknames the list of players nicknames
	 * @param playerColors the list of players colors
	 * @return true if there aren't duplicates else false
	 */
	private boolean controlForms(final List<TextField> playersNicknames, final List<ComboBox<PlayerColor>> playerColors) {
		boolean formsCorrect = true;
		int[] presences = new int[this.actualNPlayers];
		Arrays.fill(presences, 0);
		final int nDiffNicknames = playersNicknames.stream()
				.distinct()
				.collect(Collectors.toList())
				.size();
		final int nDiffColors = playerColors.stream()
				.distinct()
				.collect(Collectors.toList())
				.size();
		if (nDiffNicknames < this.actualNPlayers || nDiffColors < this.actualNPlayers) {
			formsCorrect = false;
		}
		return formsCorrect;
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

}

package menu.gamecreationmenu.model;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
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
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillColorsBoxes(List<ComboBox<PlayerColor>> playerColors) {
		playerColors.forEach(color -> {
			color.setItems(FXCollections.observableArrayList(PlayerColor.values()));
			color.getSelectionModel().selectFirst();
		});
	}

	@Override
	public void setNumberOfPlayersSpinner(Spinner<Integer> numberOfPlayers) {
		numberOfPlayers.setValueFactory(new IntSpinnerValueFactory(GameCreationMenuModelImpl.nMinPlayers, 
				GameCreationMenuModelImpl.nMaxPlayers, GameCreationMenuModelImpl.nMinPlayers));
	}

	@Override
	public void showForms(List<VBox> playersForms, Integer nPlayers) {
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

}

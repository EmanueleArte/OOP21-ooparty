package menu.gamecreationmenu.model;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import utils.IntSpinnerValueFactory;
import utils.enums.PlayerColor;
import utils.graphics.StageManager;

/**
 * Implementation of {@link GameCreationMenuModel}.
 */
public class GameCreationMenuModelImpl<S> implements GameCreationMenuModel<S> {

	private StageManager<S> stageManager;
	
	public GameCreationMenuModelImpl(final StageManager<S> s) {
		super();
		this.stageManager = s;
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
		numberOfPlayers.setValueFactory(new IntSpinnerValueFactory(2, 4, 2));
	}

	

}

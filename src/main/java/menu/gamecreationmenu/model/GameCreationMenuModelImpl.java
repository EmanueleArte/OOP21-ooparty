package menu.gamecreationmenu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import game.player.Player;
import game.player.PlayerImpl;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import minigames.common.view.MinigameView;
import minigames.mastermind.view.MastermindViewImpl;
import utils.enums.PlayerColor;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link GameCreationMenuModel}.
 * 
 * @param <S> the scenes of the stage
 */
public class GameCreationMenuModelImpl<S> implements GameCreationMenuModel<S> {

    /**
     * Minimun number of players.
     */
    public static final int N_MIN_PLAYERS = 2;
    /**
     * Maximum number of players.
     */
    public static final int N_MAX_PLAYERS = 4;
    /**
     * Minimum number of turns.
     */
    public static final int N_MIN_TURNS = 1;
    /**
     * Maximum number of turns.
     */
    public static final int N_MAX_TURNS = 20;
    private final StageManager<S> stageManager;
    private int actualNPlayers;

    /**
     * Builds a new {@link GameCreationMenuModelImpl}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}.
     */
    public GameCreationMenuModelImpl(final StageManager<S> s) {
        super();
        this.stageManager = s;
        this.actualNPlayers = GameCreationMenuModelImpl.N_MIN_PLAYERS;
    }

    @Override
    public final void returnToMainMenu() {
        this.stageManager.popScene();
    }

    @Override
    public final boolean startGame(final List<String> allPlayersNicknames,
            final List<ComboBox<PlayerColor>> allPlayerColors, final int turnsNumber) {
        final List<String> playersNicknames = this
                .getNicknamesValues(allPlayersNicknames.subList(0, this.actualNPlayers));
        final List<PlayerColor> playersColors = this.getColorsValues(allPlayerColors.subList(0, this.actualNPlayers));
        if (!checkForms(playersNicknames, playersColors)) {
            return false;
        } else {
            // To complete with game constructor (parameters: playersList, stageManager,
            // turnsNumber)
            // Test minigames
            final MinigameView<S, Player> m = new MastermindViewImpl<>(this.stageManager);
            m.startMinigame(this.createPlayersList(playersNicknames, playersColors));
        }
        return true;
    }

    @Override
    public final void setActualNPlayers(final Integer nPlayers) {
        this.actualNPlayers = nPlayers;
    }

    @Override
    public final void fillColorsBoxes(final List<ComboBox<PlayerColor>> playerColors) {
        playerColors.forEach(colors -> {
            colors.setItems(FXCollections.observableArrayList(PlayerColor.values()));
            colors.getSelectionModel().selectFirst();
        });
    }

    /**
     * This method controls that there aren't duplicates or blank nicknames into the
     * forms information.
     * 
     * @param playersNicknames the list of players nicknames
     * @param playerColors     the list of players colors
     * @return true if there aren't any duplicates or blank nicknames else false
     */
    private boolean checkForms(final List<String> playersNicknames, final List<PlayerColor> playerColors) {
        boolean formsCorrect = true;
        final int nDiffNicknames = playersNicknames.stream().distinct().collect(Collectors.toList()).size();
        final int nDiffColors = playerColors.stream().distinct().collect(Collectors.toList()).size();
        if (nDiffNicknames < this.actualNPlayers || nDiffColors < this.actualNPlayers
                || playersNicknames.contains("")) {
            formsCorrect = false;
        }
        return formsCorrect;
    }

    /**
     * This method gets the players colors values.
     * 
     * @param list the list of players colors combo box.
     * @return the list of players colors
     */
    private List<PlayerColor> getColorsValues(final List<ComboBox<PlayerColor>> list) {
        final List<PlayerColor> valuesList = new ArrayList<>();
        list.forEach(element -> valuesList.add(element.getValue()));
        return valuesList;
    }

    /**
     * This method gets the players nicknames values.
     * 
     * @param list the list of players nicknames text fields.
     * @return the list of players nicknames
     */
    private List<String> getNicknamesValues(final List<TextField> list) {
        final List<String> valuesList = new ArrayList<>();
        list.forEach(element -> valuesList.add(element.getText()));
        return valuesList;
    }

    /**
     * This method creates the list of players that will join the game.
     * 
     * @param playersNicknames the list of players nicknames
     * @param playerColors     the list of players colors
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

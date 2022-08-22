package menu.gamecreationmenu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import game.player.Player;
import game.player.PlayerImpl;
import utils.enums.PlayerColor;

/**
 * Implementation of {@link GameCreationMenuModel}.
 */
public class GameCreationMenuModelImpl implements GameCreationMenuModel {

    /**
     * Minimum number of players.
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
    private int actualNPlayers;
    private int turnsNumber;
    private List<String> playersNicknames;
    private List<PlayerColor> playersColors;

    /**
     * Builds a new {@link GameCreationMenuModelImpl}.
     */
    public GameCreationMenuModelImpl() {
        this.actualNPlayers = GameCreationMenuModelImpl.N_MIN_PLAYERS;
    }

    @Override
    public final boolean startGame(final List<String> allPlayersNicknames, final List<PlayerColor> allPlayersColors,
            final int turnsNumber) {
        playersNicknames = allPlayersNicknames.subList(0, this.actualNPlayers);
        playersColors = allPlayersColors.subList(0, this.actualNPlayers);
        if (!checkForms(playersNicknames, playersColors)) {
            return false;
        } else {
            this.turnsNumber = turnsNumber;
        }
        return true;
    }

    @Override
    public final void setActualNPlayers(final Integer nPlayers) {
        this.actualNPlayers = nPlayers;
    }

    @Override
    public final List<Player> createPlayersList() {
        final List<Player> playersList = new ArrayList<>();
        this.playersNicknames.forEach(nickname -> {
            playersList.add(new PlayerImpl(nickname,
                    this.playersColors.get(this.playersNicknames.indexOf(nickname)).getColor()));
        });
        return playersList;
    }

    @Override
    public final int getTurnsNumber() {
        return this.turnsNumber;
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

}

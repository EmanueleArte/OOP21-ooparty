package game.gamehandler.controller;

import java.util.List;
import java.util.Optional;

import game.player.Player;
import utils.view.GenericViewController;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;
import game.map.GameMap;

public interface GameHandlerController {

    void start();

    <C> void setViewController(C viewController);

    GenericViewController getViewController();

    int getTurnNumber();

    Optional<TurnProgress> nextStep();

    Optional<PlayerTurnProgress> nextPlayerTurnStep();

    Optional<Player> getCurrentPlayer();

    List<Player> getPlayers();

    /**
     * 
     * @return the {@link GameMap} of the current game
     */
    GameMap getGameMap();

    List<Player> getLeaderboard();
}

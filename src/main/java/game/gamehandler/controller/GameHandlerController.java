package game.gamehandler.controller;

import java.util.Optional;

import game.player.Player;
import utils.GenericViewController;
import game.map.GameMap;

public interface GameHandlerController {

    void start();

    <C> void setViewController(C viewController);

    GenericViewController getViewController();

    int getTurnNumber();

    int nextStep();

    int nextPlayerTurnStep();

    Optional<Player> getCurrentPlayer();

    /**
     * 
     * @return the {@link GameMap} of the current game
     */
    GameMap getGameMap();
}

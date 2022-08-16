package game.gamehandler.controller;

import java.util.Optional;

import game.player.Player;
import utils.view.GenericViewController;

public interface GameHandlerController {

    void start();

    <C> void setViewController(C viewController);

    GenericViewController getViewController();

    int getTurnNumber();

    int nextStep();

    int nextPlayerTurnStep();

    Optional<Player> getCurrentPlayer();

}

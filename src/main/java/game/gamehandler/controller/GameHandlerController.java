package game.gamehandler.controller;

import utils.GenericViewController;

public interface GameHandlerController {

    void start();

    <C> void setViewController(C viewController);

    GenericViewController getViewController();

    int getTurnNumber();

    int nextStep();

    int nextPlayerTurnStep();

    String getCurrentPlayerName();

}
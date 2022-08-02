package game.gamehandler.model;

import java.util.List;

import game.player.Player;

public interface GameHandlerModel {

    void playTurn(Player player);

    void startNewTurn();

    void playMinigame();

    void showLeaderboard();

    List<Player> getPlayers();

    int nextStep();

    int nextPlayerTurnStep();

    int getTurnProgress();

    int getTurnNumber();

    String getCurrentPlayerName();
    
    void endGame();
}

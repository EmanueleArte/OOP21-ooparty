package game.gamehandler.model;

import java.util.List;

import game.player.Player;

public interface GameHandlerModel {

	void start();
	
	void playTurn(Player player);
	
	void playMinigame();

	void showLeaderboard();

    List<Player> getPlayers();
}

package game.gamehandler.model;

import game.player.Player;

public interface GameHandler {

	void start();
	
	void playTurn(Player player);
	
	void playMinigame();

	void showLeaderboard();
}

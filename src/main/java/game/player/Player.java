package game.player;

import javafx.scene.paint.Color;

/**
 * This interface models one player
 */
public interface Player {

	/**
	 * @return the name of the player
	 */
	String getNickname();
	
	/**
	 * @return the color of the player
	 */
	Color getColor();
	
	/**
	 * Moves the player forward
	 * @param n number of steps
	 */
	void moveForward(int n);
	
	/**
	 * Moves the player to a certain position
	 */
	void goTo();
	
	/**
	 * @return the player's position
	 */
	int getPosition();
	
	/**
	 * Increments the player's coins
	 * @param n coins to add
	 */
	void earnCoins(int n);
	
	/**
	 * Decrements the player's coins
	 * @param n coins to subtract
	 */
	void loseCoins(int n);
	
	/**
	 * Updates the player's coins
	 * @param n new amount of coins
	 */
	void updateCoins(int n);
	
	/**
	 * @return amount of player's coins
	 */
	int getCoinsCount();
	
	/**
	 * Make player earn a star
	 */
	void earnStar();
	
	/**
	 * Make player lose a star
	 */
	void loseStar();
	
	/**
	 * @return number of player'stars
	 */
	int getStarsCount();
}

package game.player;

import java.util.List;

import game.powerup.Powerup;

/**
 * This interface models one player
 */
public interface Player {

	/**
	 * resets player to default values, at end of turn
	 */
	void reset();
	
	/**
	 * @return the name of the player
	 */
	String getName();
	
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
	
	void setDicesNumber(int n);
	
	int getDicesNumber();
	
	void usePowerup(Powerup p);
	
	void addPowerup(Powerup p);
	
	List<Powerup> getPowerupsList();
}

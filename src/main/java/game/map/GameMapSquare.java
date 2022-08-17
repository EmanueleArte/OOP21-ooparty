package game.map;

import java.util.Set;

import game.player.Player;
import game.powerup.GenericPowerup;

/**
 * The interface of a game map square.
 */
public interface GameMapSquare {

    /**
     * Returns the set with the list of the player on this square.
     * @return a set with the list of the players on this square
     */
    Set<Player> getPlayers();

    /**
     * Adds a player in this square (he is located in this square).
     * @param p the player to be added
     */
    void addPlayer(Player p);

    /**
     * Removes a player from this square (he is no longer in this square).
     * @param p the player to be removed
     */
    void removePlayer(Player p);

    /**
     * 
     * @return the number of coins located in this square
     */
    int getCoinsNumber();

    /**
     * Adds the coins to the player p.
     * @param p the player that is going to receive the coins
     */
    void receiveCoins(Player p);

    /**
     * 
     * @return the amount of damage located in this square
     */
    int getDamage();

    /**
     * Makes the player p lose life points.
     * @param p the player that is going to lose life points
     * @param gameMap the map of the game
     */
    void receiveDamage(Player p, GameMap gameMap);

    /**
     * Adds a star to a player if that player has enough coins.
     * @param p the player that will receive the star
     */
    void receiveStar(Player p);

    /**
     * Adds a {@link GenericPowerup} to the player p and generates a new powerup on this square.
     * @param p the {@link Player} that will receive the powerup
     */
    void receivePowerUp(Player p);

    /**
     * 
     * @return the {@link GenericPowerup} on this square
     */
    GenericPowerup getPowerUp();

    /**
     * 
     * @return if this is a {@link CoinGameMapSquare}
     */
    boolean isCoinsGameMapSquare();

    /**
     * 
     * @return if this is a {@link StarGameMapSquare}
     */
    boolean isStarGameMapSquare();

    /**
     * 
     * @return if this is a {@link PowerUpGameMapSquare}
     */
    boolean isPowerUpGameMapSquare();

    /**
     * 
     * @return if this is a {@link DamageGameMapSquare}
     */
    boolean isDamageGameMapSquare();
}

package game.map;

import java.util.Set;

import game.player.Player;

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
     * Makes the special action of the special square. Every special square will implement this method in different ways.
     * @param p the {@link Player} that will be affected from the special action
     */
    void makeSpecialAction(Player p);

    /**
     * Returns the {@link GenericPowerup} on this square.
     * @return the {@link GenericPowerup} on this square
     */
    //GenericPowerup getPowerup();

    /**
     * Returns if this is a {@link CoinsGameMapSquare}.
     * @return if this is a {@link CoinsGameMapSquare}
     */
    boolean isCoinsGameMapSquare();

    /**
     * Returns if this is a {@link StarGameMapSquare}.
     * @return if this is a {@link StarGameMapSquare}
     */
    boolean isStarGameMapSquare();

    /**
     * Returns if this is a {@link PowerUpGameMapSquare}.
     * @return if this is a {@link PowerUpGameMapSquare}
     */
    boolean isPowerUpGameMapSquare();

    /**
     * Returns if this is a {@link DamageGameMapSquare}.
     * @return if this is a {@link DamageGameMapSquare}
     */
    boolean isDamageGameMapSquare();
}

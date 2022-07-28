package game.map;

import java.util.Set;

import game.player.Player;

public interface GameMapSquare {

    /**
     * Returns the set with the list of the player on this square.
     * @return a set with the list of the player on this square
     */
    Set<Player> getPlayers();

    void addPlayer(Player p);

    void removePlayer(Player p);

    int getCoinsNumber();

    void receiveCoins(Player p);

    int getDamage();

    void receiveDamage(Player p);

    boolean isCoinsGameMapSquare();

    boolean isStarGameMapSquare();

    boolean isPowerUpGameMapSquare();

    boolean isDamageGameMapSquare();
}

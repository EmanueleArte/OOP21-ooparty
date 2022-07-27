package game.map;

import java.util.Set;

import game.player.Player;

public interface GameMapBox {

    /**
     * Returns the set with the list of the player on this box.
     * @return a set with the list of the player on this box
     */
    Set<Player> getPlayers();

    void addPlayer(Player p);

    void removePlayer(Player p);

    int getCoinsNumber();

    void receiveCoins(Player p);
}

package game.map;

import java.util.List;

import game.player.Player;

public interface GameMap {

    List<GameMapSquare> getSquares();

    GameMapSquare getPlayerPosition(Player p);
}

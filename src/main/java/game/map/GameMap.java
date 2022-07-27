package game.map;

import java.util.List;

import game.player.Player;

public interface GameMap {

    List<GameMapBox> getBoxes();

    GameMapBox getPlayerPosition(Player p);
}

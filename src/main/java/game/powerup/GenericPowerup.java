package game.powerup;

import game.map.GameMap;
import game.player.Player;

public interface GenericPowerup {

    void usePowerup(Player target, GameMap gameMap);

    String getPowerupType();
}

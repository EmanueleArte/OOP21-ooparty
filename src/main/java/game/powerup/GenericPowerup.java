package game.powerup;

import game.player.Player;

public interface GenericPowerup {

    void usePowerup(Player target);

    String getPowerupType();
}

package game.powerup;

import game.map.GameMap;
import game.player.Player;

public class DoubleDicePowerup implements GenericPowerup {

    /**
     * The name of this powerup.
     */
    public static final String POWERUP_TYPE = "Double Dice Power-Up";

    @Override
    public final void usePowerup(final Player target, final GameMap gameMap) {
        target.setDicesNumber(2);
    }

    @Override
    public final String getPowerupType() {
        return POWERUP_TYPE;
    }

}

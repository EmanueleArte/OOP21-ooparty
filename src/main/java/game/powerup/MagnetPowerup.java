package game.powerup;

import game.player.Player;

/**
 * Implementation of the {@link GenericPowerup} interface.
 */
public class MagnetPowerup implements GenericPowerup {

    /**
     * The name of this powerup.
     */
    public static final String POWERUP_TYPE = "Magnet Power-Up";

    @Override
    public final void usePowerup(final Player target) {
        target.loseCoins(target.getCoinsCount());
    }

    @Override
    public final String getPowerupType() {
        return POWERUP_TYPE;
    }

    @Override
    public final boolean useOnSelf() {
        return false;
    }

}

package game.powerup;

import game.player.Player;

/**
 * Implementation of the {@link GenericPowerup} interface.
 */
public class DoubleDicePowerup implements GenericPowerup {

    /**
     * The name of this powerup.
     */
    public static final String POWERUP_TYPE = "Double Dice Power-Up";

    @Override
    public final void usePowerup(final Player target) {
        target.setDicesNumber(2);
    }

    @Override
    public final String getPowerupType() {
        return POWERUP_TYPE;
    }

    @Override
    public final boolean useOnSelf() {
        return true;
    }
}

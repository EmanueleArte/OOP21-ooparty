package game.powerup;

import game.player.Player;

public class GunPowerup implements GenericPowerup {

    /**
     * The name of this powerup.
     */
    public static final String POWERUP_TYPE = "Gun Power-Up";

    /**
     * The damage of the gun powerup.
     */
    public static final int GUN_DAMAGE = 50;

    @Override
    public final void usePowerup(final Player target) {
        target.loseLifePoints(GUN_DAMAGE);
    }

    @Override
    public final String getPowerupType() {
        return POWERUP_TYPE;
    }

}

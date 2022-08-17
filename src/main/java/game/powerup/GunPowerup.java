package game.powerup;

import game.player.Player;

public class GunPowerup implements GenericPowerup {

    /**
     * The name of this powerup.
     */
    public static final String POWERUP_TYPE = "Double Dice Power-Up";

    /**
     * The damage of the gun powerup.
     */
    public static final int GUN_DAMAGE = 30;

    @Override
    public final void usePowerup(final Player target) {
        target.loseLifePoints(GUN_DAMAGE);
    }

    @Override
    public String getPowerupType() {
        return POWERUP_TYPE;
    }

}

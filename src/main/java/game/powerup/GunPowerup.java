package game.powerup;

import game.player.Player;

public class GunPowerup implements GenericPowerup {

    /**
     * The damage of the gun powerup.
     */
    public static final int GUN_DAMAGE = 30;

    @Override
    public final void usePowerup(final Player target) {
        target.loseLifePoints(GUN_DAMAGE, null /*TODO cambiare il null*/);
    }

}

package game.powerup;

import game.player.Player;
import game.player.PlayerImpl;

public class MedikitPowerup implements GenericPowerup {

    /**
     * The name of this powerup.
     */
    public static final String POWERUP_TYPE = "Medikit Power-Up";

    @Override
    public final void usePowerup(final Player target) {
        target.addLifePoints(PlayerImpl.MAX_LIFE);
    }

    @Override
    public final String getPowerupType() {
        return POWERUP_TYPE;
    }

}

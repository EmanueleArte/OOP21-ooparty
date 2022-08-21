package game.powerup;

import game.player.Player;

/**
 * This interface models a generic power-up.
 */
public interface GenericPowerup {

    /**
     * This method makes the power-up apply its effect to a target player.
     * 
     * @param target the target {@link Player} of the power-up
     */
    void usePowerup(Player target);

    /**
     * Getter for the power-up type.
     * 
     * @return a {@link String} containing the power-up type of this power-up
     */
    String getPowerupType();

    /**
     * This method returns whether this power-up is used on self or others.
     * 
     * @return {@link Boolean} that contains true if this power-up is used on self
     */
    boolean useOnSelf();
}

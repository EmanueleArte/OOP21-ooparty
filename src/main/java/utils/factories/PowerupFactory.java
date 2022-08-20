package utils.factories;

import game.powerup.GenericPowerup;

/**
 * A factory for {@link GenericPowerup}.
 */
public interface PowerupFactory {

    /**
     * Returns a random {@link GenericPowerup}.
     * @return a random {@link GenericPowerup}
     */
    GenericPowerup getRandomPowerup();

}

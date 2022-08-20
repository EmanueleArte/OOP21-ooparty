package utils.factories;

import game.powerup.GenericPowerup;

public interface PowerupFactory {

    /**
     * Returns a random powerup.
     * @return a random powerup
     */
    GenericPowerup getRandomPowerup();

}

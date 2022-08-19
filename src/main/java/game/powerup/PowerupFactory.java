package game.powerup;

public interface PowerupFactory {

    /**
     * Returns a random powerup.
     * @return a random powerup
     */
    GenericPowerup getRandomPowerup();

}

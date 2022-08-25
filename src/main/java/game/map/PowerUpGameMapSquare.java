package game.map;

import game.player.Player;
import game.powerup.GenericPowerup;
import utils.factories.powerup.PowerupFactoryImpl;

/**
 * A game map square where you can get a {@link GenericPowerup}.
 */
public class PowerUpGameMapSquare extends GameMapSquareImpl {

    private GenericPowerup powerup;

    /**
     * Builder for {@link PowerUpGameMapSquare}.
     */
    public PowerUpGameMapSquare() {
        super();
        this.generateRandomPowerUp();
    }

    private void generateRandomPowerUp() {
        PowerupFactoryImpl powerupFactory = new PowerupFactoryImpl();
        this.powerup = powerupFactory.getRandomPowerup();
    }

    /**
     * Adds a {@link GenericPowerup} to the player p and generates a new powerup on this square.
     * @param p the {@link Player} that will receive the powerup
     */
    @Override
    public final void makeSpecialAction(final Player p) {
        p.addPowerup(this.powerup);
        this.generateRandomPowerUp();
    }

    @Override
    public final boolean isPowerUpGameMapSquare() {
        return true;
    }

    @Override
    public final String toString() {
        return "GameMapSquare [PowerUp]";
    }
}

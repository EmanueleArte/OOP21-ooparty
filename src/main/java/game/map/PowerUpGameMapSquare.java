package game.map;

import game.player.Player;
import game.powerup.GenericPowerup;
import game.powerup.PowerupFactoryImpl;

/**
 * A game map square where you can get a {@link GenericPowerup}.
 */
public class PowerUpGameMapSquare extends GameMapSquareImpl {

    private GenericPowerup powerup;

    public PowerUpGameMapSquare() {
        super();
        this.generateRandomPowerUp();
    }

    private void generateRandomPowerUp() {
        PowerupFactoryImpl powerupFactory = new PowerupFactoryImpl();
        this.powerup = powerupFactory.getRandomPowerup();
    }

    @Override
    public final void receivePowerup(final Player p) {
        p.addPowerup(this.powerup);
        this.generateRandomPowerUp();
    }

    @Override
    public final GenericPowerup getPowerup() {
        return this.powerup;
    }

    @Override
    public final boolean isCoinsGameMapSquare() {
        return false;
    }

    @Override
    public final boolean isStarGameMapSquare() {
        return false;
    }

    @Override
    public final boolean isPowerUpGameMapSquare() {
        return true;
    }

    @Override
    public final boolean isDamageGameMapSquare() {
        return false;
    }

    @Override
    public final String toString() {
        return "GameMapSquare [PowerUp]";
    }
}

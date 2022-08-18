package game.map;

import java.util.Random;

import game.player.Player;
import game.powerup.DoubleDicePowerup;
import game.powerup.GenericPowerup;
import game.powerup.GunPowerup;

/**
 * A game map square where you can get a {@link GenericPowerup}.
 */
public class PowerUpGameMapSquare extends GameMapSquareImpl {
    private static final int POWERUPS_NUMBER = 2;

    private GenericPowerup powerup;

    public PowerUpGameMapSquare() {
        super();
        this.generateRandomPowerUp();
    }

    private void generateRandomPowerUp() {
        Random rand = new Random();
        switch (rand.nextInt(POWERUPS_NUMBER)) {
        case 0:
            this.powerup = new DoubleDicePowerup();
        case 1:
            this.powerup = new GunPowerup();
        default:
            this.powerup = new GunPowerup();
        }
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

package game.powerup;

import java.util.Random;

public class PowerupFactoryImpl implements PowerupFactory {

    private static final int POWERUPS_NUMBER = 3;

    @Override
    public final GenericPowerup getRandomPowerup() {
        Random rand = new Random();
        switch (rand.nextInt(POWERUPS_NUMBER)) {
        case 0:
            return new DoubleDicePowerup();
        case 1:
            return new GunPowerup();
        case 2:
            return new MedikitPowerup();
        default:
            return new GunPowerup();
        }
    }

}

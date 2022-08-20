package utils.factories;

import java.util.Random;

import game.powerup.DoubleDicePowerup;
import game.powerup.GenericPowerup;
import game.powerup.GunPowerup;
import game.powerup.MedikitPowerup;

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

package game.powerup;

import game.player.Player;

public class DoubleDicePowerup implements GenericPowerup {

    @Override
    public void usePowerup(final Player target) {
        target.setDicesNumber(2);
    }

}

package game.powerup;

import game.player.Player;

public class DoubleDicePowerup implements Powerup {

	@Override
	public void use(Player p) {
		System.out.println("Doppio dado!");
		p.setDicesNumber(2);
	}

}

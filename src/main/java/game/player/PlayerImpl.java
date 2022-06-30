package game.player;

import java.util.ArrayList;
import java.util.List;

import game.powerup.Powerup;

public class PlayerImpl implements Player {

	private final String name;
	private int position; // da modificare quando ci saranno le caselle
	private int coins;
	private int stars;
	private int dicesNumber;
	private final List<Powerup> powerups;

	public PlayerImpl(String name) {
		this.name = name;
		this.coins = 0;
		this.stars = 0;
		this.position = 0;
		this.dicesNumber = 1;
		this.powerups = new ArrayList<Powerup>();
	}

	@Override
	public void reset() {
		this.dicesNumber = 1;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void moveForward(int n) {
		this.position += n;
	}

	@Override
	public void goTo() {
		// da completare quando ci saranno le caselle
	}

	@Override
	public int getPosition() {
		// da modificare quando ci saranno le caselle
		return this.position;
	}

	@Override
	public void earnCoins(int n) {
		this.coins = getCoinsCount() + n;
	}

	@Override
	public void loseCoins(int n) {
		this.coins = getCoinsCount() - n;
		if (this.coins < 0) {
			this.coins = 0;
		}
	}

	@Override
	public void updateCoins(int n) {
		this.coins = n;
	}

	@Override
	public int getCoinsCount() {
		return this.coins;
	}

	@Override
	public void earnStar() {
		this.stars++;
	}

	@Override
	public void loseStar() {
		this.stars--;
	}

	@Override
	public int getStarsCount() {
		return this.stars;
	}

	@Override
	public void setDicesNumber(int n) {
		this.dicesNumber = n;
	}

	@Override
	public int getDicesNumber() {
		return this.dicesNumber;
	}

	@Override
	public void usePowerup(Powerup p) {
		if (getPowerupsList().contains(p)) {
			p.use(this);
			this.powerups.remove(p);
		}
	}

	@Override
	public void addPowerup(Powerup p) {
		this.powerups.add(p);
	}

	@Override
	public List<Powerup> getPowerupsList() {
		return List.copyOf(this.powerups);
	}
}

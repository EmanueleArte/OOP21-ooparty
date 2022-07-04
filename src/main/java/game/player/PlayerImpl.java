package game.player;

import javafx.scene.paint.Color;

/**
 * The implementation of {@link Player}
 */
public class PlayerImpl implements Player {

	private final String nickname;
	private final Color color;
	private int position; // da modificare quando ci saranno le caselle
	private int coins;
	private int stars;

	public PlayerImpl(final String nickname, final Color color) {
		this.nickname = nickname;
		this.color = color;
		this.coins = 0;
		this.stars = 0;
		this.position = 0;
	}

	@Override
	public String getNickname() {
		return this.nickname;
	}
	
	@Override
	public Color getColor() {
		return this.color;
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

}

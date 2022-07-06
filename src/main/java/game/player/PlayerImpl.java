package game.player;

import javafx.scene.paint.Color;

/**
 * The implementation of {@link Player}.
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

    public PlayerImpl(final String nickname) {
        this(nickname, null);
    }

    @Override
    public final String getNickname() {
        return this.nickname;
    }

    @Override
    public final Color getColor() {
        return this.color;
    }

    @Override
    public final void moveForward(final int n) {
        this.position += n;
    }

    @Override
    public void goTo() {
        // da completare quando ci saranno le caselle
    }

    @Override
    public final int getPosition() {
        // da modificare quando ci saranno le caselle
        return this.position;
    }

    @Override
    public final void earnCoins(final int n) {
        this.coins = getCoinsCount() + n;
    }

    @Override
    public final void loseCoins(final int n) {
        this.coins = getCoinsCount() - n;
        if (this.coins < 0) {
            this.coins = 0;
        }
    }

    @Override
    public final void updateCoins(final int n) {
        this.coins = n;
    }

    @Override
    public final int getCoinsCount() {
        return this.coins;
    }

    @Override
    public final void earnStar() {
        this.stars++;
    }

    @Override
    public final void loseStar() {
        this.stars--;
    }

    @Override
    public final int getStarsCount() {
        return this.stars;
    }

}

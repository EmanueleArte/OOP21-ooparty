package game.map;

import java.util.Random;

import game.player.Player;

/**
 * A game map square where you can earn coins.
 */
public class CoinsGameMapSquare extends GameMapSquareImpl {
    private int coinsNumber;

    public CoinsGameMapSquare() {
        super();
        this.generateNewCoins();
    }

    @Override
    public final int getCoinsNumber() {
        return this.coinsNumber;
    }

    @Override
    public final void receiveCoins(final Player p) {
        p.earnCoins(this.coinsNumber);
        this.generateNewCoins();
    }

    private void generateNewCoins() {
        this.coinsNumber = new Random().nextInt(GameMapSquareImpl.MAX_COINS) + 1;
    }

    @Override
    public final boolean isCoinsGameMapSquare() {
        return true;
    }

    @Override
    public final boolean isStarGameMapSquare() {
        return false;
    }

    @Override
    public final boolean isPowerUpGameMapSquare() {
        return false;
    }

    @Override
    public final boolean isDamageGameMapSquare() {
        return false;
    }

    @Override
    public final String toString() {
        return "GameMapSquare [Coin]";
    }
}

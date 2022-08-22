package game.map;

import java.util.Random;

import game.player.Player;

/**
 * A game map square where you earn coins.
 */
public class CoinsGameMapSquare extends GameMapSquareImpl {
    private int coinsNumber;

    /**
     * Builder for {@link CoinsGameMapSquare}.
     */
    public CoinsGameMapSquare() {
        super();
        this.generateNewCoins();
    }

    /**
     * Builder for {@link CoinsGameMapSquare}.
     * @param coinsNumber the amount of coins that will be contained in this square
     */
    public CoinsGameMapSquare(final int coinsNumber) {
        super();
        this.coinsNumber = coinsNumber;
    }

    /**
     * Adds the coins to the player p.
     * @param p the player that is going to receive the coins
     */
    @Override
    public final void makeSpecialAction(final Player p) {
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
    public final String toString() {
        return "GameMapSquare [Coin]";
    }
}

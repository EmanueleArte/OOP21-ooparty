package game.map;

import java.util.Random;

import game.player.Player;

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
    public boolean isCoinsGameMapSquare() {
        return true;
    }

    @Override
    public boolean isStarGameMapSquare() {
        return false;
    }

    @Override
    public boolean isPowerUpGameMapSquare() {
        return false;
    }

    @Override
    public boolean isDamageGameMapSquare() {
        return false;
    }
}

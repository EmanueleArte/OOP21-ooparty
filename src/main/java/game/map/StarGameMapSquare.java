package game.map;

import game.player.Player;

public class StarGameMapSquare extends GameMapSquareImpl {

    public StarGameMapSquare() {
        super();
    }

    /**
     * 
     */
    @Override
    public void receiveStar(final Player p) {
        if (this.checkEnoughCoins(p)) {
            p.earnStar();
            p.loseCoins(GameMapImpl.COINS_TO_BUY_STAR);
        }
    }

    private boolean checkEnoughCoins(final Player p) {
        return p.getCoinsCount() >= GameMapImpl.COINS_TO_BUY_STAR;
    }

    @Override
    public final boolean isCoinsGameMapSquare() {
        return false;
    }

    @Override
    public final boolean isStarGameMapSquare() {
        return true;
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
    public String toString() {
        return "GameMapSquare [Star]";
    }
}

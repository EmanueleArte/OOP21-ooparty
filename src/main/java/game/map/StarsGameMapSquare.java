package game.map;

import game.player.Player;

public class StarsGameMapSquare extends GameMapSquareImpl {

    public StarsGameMapSquare() {
        super();
    }

    /**
     * Adds a star to a player if that player has enough coins.
     * @param p the player that will receive the star
     */
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
}

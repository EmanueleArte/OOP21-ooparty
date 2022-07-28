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
    public boolean isCoinsGameMapSquare() {
        return false;
    }

    @Override
    public boolean isStarGameMapSquare() {
        return true;
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

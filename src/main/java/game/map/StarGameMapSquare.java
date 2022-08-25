package game.map;

import game.player.Player;

/**
 * A game map square where you can earn a star.
 */
public class StarGameMapSquare extends GameMapSquareImpl {

    /**
     * Builder for {@link StarGameMapSquare}.
     */
    public StarGameMapSquare() {
        super();
    }

    /**
     * Adds a star to a player if that player has enough coins.
     * @param p the player that will receive the star
     */
    @Override
    public void makeSpecialAction(final Player p) {
        if (this.checkEnoughCoins(p)) {
            p.earnStar();
            p.loseCoins(GameMapImpl.COINS_TO_BUY_STAR);
            p.setIsLastStarEarned(true);
        } else {
            p.setIsLastStarEarned(false);
        }
    }

    private boolean checkEnoughCoins(final Player p) {
        return p.getCoinsCount() >= GameMapImpl.COINS_TO_BUY_STAR;
    }

    @Override
    public final boolean isStarGameMapSquare() {
        return true;
    }

    @Override
    public final String toString() {
        return "GameMapSquare [Star]";
    }
}

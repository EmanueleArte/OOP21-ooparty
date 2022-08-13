package game.map;

import java.util.Random;

import game.player.Player;

/**
 * A game map square where you get damage.
 */
public class DamageGameMapSquare extends GameMapSquareImpl {
    private int damage;

    public DamageGameMapSquare() {
        super();
        this.generateNewDamage();
    }

    @Override
    public final int getDamage() {
        return this.damage;
    }

    @Override
    public final void receiveDamage(final Player p) {
        p.loseLifePoints(this.damage);
        this.generateNewDamage();
    }

    private void generateNewDamage() {
        this.damage = new Random().nextInt(GameMapSquareImpl.MAX_DAMAGE) + 1;
    }

    @Override
    public final boolean isCoinsGameMapSquare() {
        return false;
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
        return true;
    }

    @Override
    public final String toString() {
        return "GameMapSquare [Damage]";
    }
}

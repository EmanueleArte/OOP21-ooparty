package game.map;

import java.util.Random;

import game.player.Player;

/**
 * A game map square where you get damage.
 */
public class DamageGameMapSquare extends GameMapSquareImpl {
    private int damage;

    /**
     * Builder for {@link DamageGameMapSquare}.
     */
    public DamageGameMapSquare() {
        super();
        this.generateNewDamage();
    }

    /**
     * Builder for {@link DamageGameMapSquare}.
     * @param damage the damage that will be contained in this square
     */
    public DamageGameMapSquare(final int damage) {
        super();
        this.damage = damage;
    }

    /**
     * Makes the player p lose life points.
     * @param p the player that is going to lose life points
     */
    @Override
    public final void makeSpecialAction(final Player p) {
        p.loseLifePoints(this.damage);
        this.generateNewDamage();
    }

    private void generateNewDamage() {
        this.damage = new Random().nextInt(GameMapSquareImpl.MAX_DAMAGE) + 1;
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

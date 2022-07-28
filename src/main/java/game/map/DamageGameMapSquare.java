package game.map;

import java.util.Random;

import game.player.Player;

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
    public boolean isCoinsGameMapSquare() {
        return false;
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
        return true;
    }
}

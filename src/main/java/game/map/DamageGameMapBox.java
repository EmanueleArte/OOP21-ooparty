package game.map;

import java.util.Random;

import game.player.Player;

public class DamageGameMapBox extends GameMapBoxImpl {
    private int damage;

    public DamageGameMapBox() {
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
        this.damage = new Random().nextInt(GameMapBoxImpl.MAX_DAMAGE) + 1;
    }

}

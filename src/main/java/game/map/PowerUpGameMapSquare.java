package game.map;

//TODO aggiornare link nella javadoc
/**
 * A game map square where you can get a {@link PowerUp}.
 */
public class PowerUpGameMapSquare extends GameMapSquareImpl {
    //TODO usare la classe PowerUp di Roby

    public PowerUpGameMapSquare() {
        super();
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
        return true;
    }

    @Override
    public final boolean isDamageGameMapSquare() {
        return false;
    }

    @Override
    public final String toString() {
        return "GameMapSquare [PowerUp]";
    }
}

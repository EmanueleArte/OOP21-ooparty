package game.map;

public class PowerUpGameMapSquare extends GameMapSquareImpl {
    //TODO usare la classe PowerUp di Roby

    public PowerUpGameMapSquare() {
        super();
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
        return true;
    }

    @Override
    public boolean isDamageGameMapSquare() {
        return false;
    }

}

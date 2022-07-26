package game.map;

import java.util.Random;

public class StarsGameMapBox extends GameMapBoxImpl {
    private int starsNumber;

    public StarsGameMapBox() {
        super();
        this.starsNumber = new Random().nextInt(GameMapBoxImpl.MAX_STARS);
    }

    public int getStarsNumber() {
        return starsNumber;
    }

}

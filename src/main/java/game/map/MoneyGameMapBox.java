package game.map;

import java.util.Random;

public class MoneyGameMapBox extends GameMapBoxImpl {
    private int moneyNumber;

    public MoneyGameMapBox() {
        super();
        this.moneyNumber = new Random().nextInt(GameMapBoxImpl.MAX_MONEY);
    }
}

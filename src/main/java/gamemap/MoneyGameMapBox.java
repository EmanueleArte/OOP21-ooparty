package gamemap;

import java.util.Random;

public class MoneyGameMapBox extends GameMapBoxImpl {
    int moneyNumber;
    
    public MoneyGameMapBox() {
        super();
        this.moneyNumber = new Random().nextInt(10);
    }
}

package game.map;

import java.util.Random;

import game.player.Player;

public class MoneyGameMapBox extends GameMapBoxImpl {
    private int moneyNumber;

    public MoneyGameMapBox() {
        super();
        this.generateNewMoney();
    }

    public int getMoneyNumber() {
        return this.moneyNumber;
    }

    public void receiveMoney(final Player p) {
        p.updateCoins(this.moneyNumber);
        this.generateNewMoney();
    }

    private void generateNewMoney() {
        this.moneyNumber = new Random().nextInt(GameMapBoxImpl.MAX_MONEY); 
    }
}

package gamemap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import game.map.GameMap;
import game.map.GameMapImpl;
import game.map.CoinsGameMapBox;
import game.player.Player;
import game.player.PlayerImpl;

public class TestGameMapBoxes {

    private final GameMap map = new GameMapImpl(List.of(new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(),
                                                        new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(),
                                                        new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(),
                                                        new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(),
                                                        new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(),
                                                        new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox(), new CoinsGameMapBox()));
    private final Player p1 = new PlayerImpl("Giocatore 1");
    private final Player p2 = new PlayerImpl("Giocatore 2");

    @Test
    public void testMoneyBoxes() {
        int dice = 3;
        p1.moveForward(dice);
        int coinNum = map.getBoxes().get(dice).getCoinsNumber();
        p1.getPosition(this.map).receiveCoins(p1);
        assertEquals(coinNum, p1.getCoinsCount());
    }

    @Test
    public void testPlayerListInBox() {
        int dice = 3;
        p1.moveForward(dice);
        map.getBoxes().get(dice).addPlayer(p1);
        assertEquals(map.getPlayerPosition(p1), map.getBoxes().get(dice));
    }
}

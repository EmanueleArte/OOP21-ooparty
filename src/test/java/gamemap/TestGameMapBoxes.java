package gamemap;

import java.util.List;

import org.junit.jupiter.api.Test;

import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
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
    private final DiceModel<Player> dice = new DiceModelImpl<>();

    @Test
    public void testMoneyBoxes() {
        int n = dice.rollDice(p1);
        p1.moveForward(n);
    }
}

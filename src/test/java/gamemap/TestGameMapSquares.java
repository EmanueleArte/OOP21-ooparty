package gamemap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import game.map.GameMap;
import game.map.GameMapImpl;
import game.map.GameMapSquareImpl;
import game.map.PowerUpGameMapSquare;
import game.map.CoinsGameMapSquare;
import game.map.DamageGameMapSquare;
import game.player.Player;
import game.player.PlayerImpl;

public class TestGameMapSquares {

    private final GameMap gameMap = new GameMapImpl(List.of(new GameMapSquareImpl(), new DamageGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
                                                        new PowerUpGameMapSquare(), new PowerUpGameMapSquare(), new DamageGameMapSquare(), new PowerUpGameMapSquare(), new CoinsGameMapSquare(),
                                                        new CoinsGameMapSquare(), new DamageGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
                                                        new CoinsGameMapSquare(), new PowerUpGameMapSquare(), new DamageGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
                                                        new PowerUpGameMapSquare(), new CoinsGameMapSquare(), new DamageGameMapSquare(), new DamageGameMapSquare(), new CoinsGameMapSquare(),
                                                        new PowerUpGameMapSquare(), new CoinsGameMapSquare(), new DamageGameMapSquare(), new DamageGameMapSquare(), new PowerUpGameMapSquare()));
    private final Player p1 = new PlayerImpl("Giocatore 1");
    private final Player p2 = new PlayerImpl("Giocatore 2");

    @Test
    public void testMoneySquares() {
        int dice = 3;
        //p1.moveForward(dice, this.gameMap);   //ancora non va moveForward
        this.p1.goTo(this.gameMap, this.gameMap.getSquares().get(dice));
        assertTrue(this.p1.getPosition(this.gameMap).isCoinsGameMapSquare());
        assertFalse(this.p1.getPosition(this.gameMap).isDamageGameMapSquare());
        assertFalse(this.p1.getPosition(this.gameMap).isPowerUpGameMapSquare());
        assertFalse(this.p1.getPosition(this.gameMap).isStarGameMapSquare());
        int coinNum = gameMap.getSquares().get(dice).getCoinsNumber();
        p1.getPosition(this.gameMap).receiveCoins(p1);
        assertEquals(coinNum, p1.getCoinsCount());
    }

    @Test
    public void testPlayerListInSquare() {
        int dice = 3;
        p1.moveForward(dice, this.gameMap);
        gameMap.getSquares().get(dice).addPlayer(p1);
        assertEquals(gameMap.getPlayerPosition(p1), gameMap.getSquares().get(dice));
    }
}

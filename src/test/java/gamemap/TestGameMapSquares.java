package gamemap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import game.map.CoinsGameMapSquare;
import game.map.DamageGameMapSquare;
import game.map.GameMap;
import game.map.GameMapImpl;
import game.map.GameMapSquareImpl;
import game.map.PowerUpGameMapSquare;
import game.map.StarGameMapSquare;
import game.player.Player;
import game.player.PlayerImpl;

public class TestGameMapSquares {

    private final GameMap gameMap = new GameMapImpl(List.of(new GameMapSquareImpl(), new DamageGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
                                                        new PowerUpGameMapSquare(), new PowerUpGameMapSquare(), new DamageGameMapSquare(), new PowerUpGameMapSquare(), new StarGameMapSquare(),
                                                        new CoinsGameMapSquare(), new PowerUpGameMapSquare(), new DamageGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
                                                        new CoinsGameMapSquare(), new PowerUpGameMapSquare(), new DamageGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
                                                        new PowerUpGameMapSquare(), new CoinsGameMapSquare(), new DamageGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
                                                        new CoinsGameMapSquare(), new CoinsGameMapSquare(), new DamageGameMapSquare(), new DamageGameMapSquare(), new PowerUpGameMapSquare()));
    private final Player p1 = new PlayerImpl("Giocatore 1");
    private final Player p2 = new PlayerImpl("Giocatore 2");

    @Test
    public void testCoinsSquares() {
        this.gameMap.initializePlayers(List.of(p1, p2));
        int dice = 3;
        this.p1.moveForward(dice, this.gameMap);
        assertTrue(this.p1.getPosition(this.gameMap).isCoinsGameMapSquare());
        assertFalse(this.p1.getPosition(this.gameMap).isDamageGameMapSquare());
        assertFalse(this.p1.getPosition(this.gameMap).isPowerUpGameMapSquare());
        assertFalse(this.p1.getPosition(this.gameMap).isStarGameMapSquare());
        int coinNum = gameMap.getSquares().get(dice).getCoinsNumber();
        p1.getPosition(this.gameMap).receiveCoins(p1);
        assertEquals(coinNum, p1.getCoinsCount());
    }

    @Test
    public void testDamageSquares() {
        this.gameMap.initializePlayers(List.of(p1, p2));
        int dice = 7;
        this.p2.moveForward(dice, this.gameMap);
        assertTrue(this.p2.getPosition(this.gameMap).isDamageGameMapSquare());
        assertFalse(this.p2.getPosition(this.gameMap).isCoinsGameMapSquare());
        assertFalse(this.p2.getPosition(this.gameMap).isPowerUpGameMapSquare());
        assertFalse(this.p2.getPosition(this.gameMap).isStarGameMapSquare());
        int damageNum = gameMap.getSquares().get(dice).getDamage();
        this.p2.getPosition(this.gameMap).receiveDamage(p2);
        assertEquals(damageNum, PlayerImpl.MAX_LIFE - p2.getLifePoints());
    }

    @Test
    public void testStarGameSquares() {
        this.gameMap.initializePlayers(List.of(p1, p2));
        int dice = 9;
        this.p1.moveForward(dice, this.gameMap);
        this.p1.earnCoins(GameMapImpl.COINS_TO_BUY_STAR + 5);
        this.p2.moveForward(dice, this.gameMap);
        this.p2.getPosition(this.gameMap).receiveStar(p2);
        assertEquals(this.p2.getStarsCount(), 0);
        this.p1.getPosition(this.gameMap).receiveStar(p1);
        assertEquals(this.p1.getStarsCount(), 1);
    }

    @Test
    public void testPlayerListInSquare() {
        this.gameMap.initializePlayers(List.of(p1, p2));
        int dice = 3;
        this.p1.moveForward(dice, this.gameMap);
        gameMap.getSquares().get(dice).addPlayer(p1);
        assertEquals(gameMap.getPlayerPosition(p1), gameMap.getSquares().get(dice));
    }
}

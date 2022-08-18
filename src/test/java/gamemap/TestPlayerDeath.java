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

public class TestPlayerDeath {
    private final GameMap gameMap = new GameMapImpl(List.of(new GameMapSquareImpl(), new DamageGameMapSquare(), new GameMapSquareImpl(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
            new PowerUpGameMapSquare(), new PowerUpGameMapSquare(), new DamageGameMapSquare(), new PowerUpGameMapSquare(), new StarGameMapSquare(),
            new CoinsGameMapSquare(), new PowerUpGameMapSquare(), new GameMapSquareImpl(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
            new CoinsGameMapSquare(), new PowerUpGameMapSquare(), new DamageGameMapSquare(), new CoinsGameMapSquare(), new CoinsGameMapSquare(),
            new GameMapSquareImpl(), new CoinsGameMapSquare(), new DamageGameMapSquare(), new GameMapSquareImpl(), new CoinsGameMapSquare(),
            new CoinsGameMapSquare(), new GameMapSquareImpl(), new DamageGameMapSquare(), new DamageGameMapSquare(), new PowerUpGameMapSquare()));
    private final Player p1 = new PlayerImpl("Giocatore 1");
    private final Player p2 = new PlayerImpl("Giocatore 2");

    @Test
    public void testPlayerDeath() {
        this.gameMap.initializePlayers(List.of(this.p1, this.p2));
        this.p1.loseLifePoints(PlayerImpl.MAX_LIFE + 10);
        assertTrue(p1.isDead());
        this.p1.checkIfDeadAndRespawn(this.gameMap);
        assertFalse(this.p1.isDead());
        assertEquals(this.gameMap.getSquares().indexOf(this.p1.getPosition(this.gameMap)), 12);
    }
}

package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
import game.gamehandler.model.GameHandlerModel;
import game.gamehandler.model.GameHandlerModelImpl;
import game.player.Player;
import game.player.PlayerImpl;

class TestLeaderboard {

    @Test
    void startingLeaderboardTest() {
        final DiceModel dice = new DiceModelImpl();
        final List<Player> players = List.of(new PlayerImpl("Mario"), new PlayerImpl("Luigi"), new PlayerImpl("Alex"));
        final int turns = 5;
        final GameHandlerModel model = new GameHandlerModelImpl(dice, players, turns);

        assertEquals(players, model.getLeaderboard());
    }

    @Test
    void midGameLeaderboardTest() {
        final DiceModel dice = new DiceModelImpl();

        final Player mario = new PlayerImpl("Mario");
        final Player luigi = new PlayerImpl("Luigi");
        final Player alex = new PlayerImpl("Alex");
        final Player martino = new PlayerImpl("Martino");

        final List<Player> players = List.of(mario, luigi, alex, martino);
        final int turns = 5;
        final GameHandlerModel model = new GameHandlerModelImpl(dice, players, turns);

        model.getPlayers().get(0).earnCoins(20);
        model.getPlayers().get(1).earnCoins(50);
        model.getPlayers().get(2).earnCoins(10);
        model.getPlayers().get(3).earnCoins(20);

        model.getPlayers().get(2).earnStar();

        model.getPlayers().get(0).loseLifePoints(10);
        model.getPlayers().get(1).loseLifePoints(20);
        model.getPlayers().get(2).loseLifePoints(10);
        model.getPlayers().get(3).loseLifePoints(5);

        assertEquals(List.of(alex, luigi, martino, mario), model.getLeaderboard());
    }

}

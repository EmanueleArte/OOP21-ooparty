package utils.factories;

import java.util.List;
import java.util.Random;

import game.player.Player;
import minigames.common.controller.MinigameController;
import minigames.mastermind.controller.MastermindControllerImpl;
import minigames.memo.controller.MemoControllerImpl;
import minigames.whoriskswins.controller.WhoRisksWinsControllerImpl;
import utils.graphics.controller.StageManager;

public class MinigameFactoryImpl<S> {
    private static final int MINIGAMES_NUMBER = 3;

    private final StageManager<S> stageManager;
    private final List<Player> players;

    public MinigameFactoryImpl(final List<Player> players, final StageManager<S> s) {
        this.players = players;
        this.stageManager = s;
    }

    public final MinigameController createRandomMinigameController() {
        /*
        Random rand = new Random();
        switch (rand.nextInt(MinigameFactoryImpl.MINIGAMES_NUMBER)) {
        case 0:
            return this.createMastermindController();
        case 1:
            return this.createWhoRisksWinsController();
        case 2:
            return this.createMemoController();
        default:
            return null;
        }
        */
        return this.createMemoController();
    }

    public final MinigameController createMastermindController() {
        return new MastermindControllerImpl(this.stageManager, this.players);
    }

    public final MinigameController createWhoRisksWinsController() {
        return new WhoRisksWinsControllerImpl(this.stageManager, this.players);
    }

    public final MinigameController createMemoController() {
        return new MemoControllerImpl(this.stageManager, this.players);
    }
}

package utils.factories;

import java.util.List;
import java.util.Random;

import minigames.common.controller.MinigameController;
import minigames.mastermind.controller.MastermindControllerImpl;
import minigames.whoriskswins.controller.WhoRisksWinsControllerImpl;
import utils.graphics.stagemanager.StageManager;

public class MinigameFactoryImpl<S, P> {
    private static final int MINIGAMES_NUMBER = 2;

    private final StageManager<S> stageManager;
    private final List<P> players;

    public MinigameFactoryImpl(final List<P> players, final StageManager<S> s) {
        this.players = players;
        this.stageManager = s;
    }

    public final MinigameController createRandomMinigameController() {
        Random rand = new Random();
        switch (rand.nextInt(MinigameFactoryImpl.MINIGAMES_NUMBER)) {
        case 0:
            return this.createMastermindController();
        case 1:
            return this.createWhoRisksWinsController();
        default:
            return null;
        }
    }

    public final MinigameController createMastermindController() {
        return new MastermindControllerImpl(this.stageManager, this.players);
    }

    public final MinigameController createWhoRisksWinsController() {
        return new WhoRisksWinsControllerImpl(this.stageManager, this.players);
    }
}

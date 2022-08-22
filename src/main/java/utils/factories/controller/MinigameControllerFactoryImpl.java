package utils.factories.controller;

import java.util.List;
import java.util.Random;

import game.player.Player;
import minigames.common.controller.MinigameController;
import utils.graphics.controller.StageManager;

public class MinigameControllerFactoryImpl<S> implements MinigameControllerFactory<S> {
    private static final int MINIGAMES_NUMBER = 3;
    private final StageManager<S> stageManager;
    private final List<Player> players;

    public MinigameControllerFactoryImpl(final List<Player> players, final StageManager<S> s) {
        this.players = players;
        this.stageManager = s;
    }

    @Override
    public final MinigameController createRandomMinigameController() {
        /*
        Random rand = new Random();
        switch (rand.nextInt(MinigameControllerFactoryImpl.MINIGAMES_NUMBER)) {
        case 0:
            return this.stageManager.getControllerFactory().createMastermindController(this.players);
        case 1:
            return this.stageManager.getControllerFactory().createWhoRisksWinsController(this.players);
        case 2:
            return this.stageManager.getControllerFactory().createMemoController(this.players);
        default:
            return null;
        }
        */
        return this.stageManager.getControllerFactory().createMemoController(this.players);
    }
}


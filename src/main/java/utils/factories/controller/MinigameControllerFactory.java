package utils.factories.controller;

import minigames.common.controller.MinigameController;

public interface MinigameControllerFactory<S> {

    MinigameController createRandomMinigameController();

}
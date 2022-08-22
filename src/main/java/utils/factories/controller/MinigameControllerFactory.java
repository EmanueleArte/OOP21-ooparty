package utils.factories.controller;

import minigames.common.controller.MinigameController;

/**
 * This interface models a factory for a random minigame controller.
 * 
 * @param <S> the scenes of the stage
 */
public interface MinigameControllerFactory<S> {

    /**
     * This method creates a random {@link MinigameController}.
     * 
     * @return a random {@link MinigameController}
     */
    MinigameController createRandomMinigameController();

}

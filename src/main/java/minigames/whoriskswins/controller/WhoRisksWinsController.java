package minigames.whoriskswins.controller;

import minigames.common.controller.MinigameController;

/**
 * Extension of {@link MinigameController}.
 */
public interface WhoRisksWinsController extends MinigameController {

    /**
     * This method is called when the player stops the block that is falling.
     * 
     * @param blockY  the ordinate of the block
     * @param playerY the ordinate of the player avatar
     */
    void stopBlock(int blockY, int playerY);
}

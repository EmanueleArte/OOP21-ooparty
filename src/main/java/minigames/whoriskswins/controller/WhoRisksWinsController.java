package minigames.whoriskswins.controller;

import minigames.common.controller.MinigameController;

/**
 * This interface models the Who risks wins controller. Specialization of {@link MinigameController}.
 */
public interface WhoRisksWinsController extends MinigameController {

    /**
     * This method is called when the player stops the block that is falling.
     * 
     * @param blockY  the ordinate of the block
     * @param playerY the ordinate of the player avatar
     */
    void stopBlockFall(double blockY, double playerY);

    /**
     * This method gets the falling speed of the block.
     * 
     * @return the falling speed
     */
    int getFallingSpeed();
}

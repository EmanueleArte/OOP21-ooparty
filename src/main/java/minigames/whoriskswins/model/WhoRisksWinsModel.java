package minigames.whoriskswins.model;

import minigames.common.model.MinigameModel;

/**
 * This interface models the Who risks wins model. Specialization of
 * {@link MinigameModel}.
 */
public interface WhoRisksWinsModel extends MinigameModel {

    /**
     * This method stops the bolck's fall.
     * 
     * @param blockY  the ordinate of the block
     * @param playerY the ordinate of the player avatar
     */
    void stopBlockFall(double blockY, double playerY);

    /**
     * Getter for blockFallingSpeed.
     * 
     * @return the falling speed of the block
     */
    int getBlockFallingSpeed();

}

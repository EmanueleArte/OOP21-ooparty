package minigames.whoriskswins.model;

import java.util.List;
import java.util.Map;

import minigames.common.model.MinigameModelAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link WhoRisksWinsModel} and extension of
 * {@link MinigameModelAbstr}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public class WhoRisksWinsModelImpl<S, U> extends MinigameModelAbstr<S, U> implements WhoRisksWinsModel<S, U> {

    /**
     * Builds a new {@link WhoRisksWinsModelImpl}.
     * 
     * @param players the list of players
     * @param s       the {@link StageManager}
     */
    public WhoRisksWinsModelImpl(List<U> players, StageManager<S> s) {
        super(players, s);
    }

    @Override
    public List<U> gameResults() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void scoreMapper(U player, Integer score) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getScore() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Map<U, Integer> getPlayersClassification() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPlayersClassification(Map<U, Integer> playersClassification) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean runGame() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public StageManager<S> getStageManager() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<U> getPlayers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public U getCurrPlayer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void stopBlockFall(int blockY, int playerY) {
        // TODO Auto-generated method stub
        
    }

}

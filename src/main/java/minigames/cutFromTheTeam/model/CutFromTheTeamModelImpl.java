package minigames.cutFromTheTeam.model;

import java.util.List;

import game.dice.model.DiceModel;
import game.player.Player;
import minigames.common.model.MinigameModelAbstr;

public class CutFromTheTeamModelImpl extends MinigameModelAbstr implements CutFromTheTeamModel {

    public CutFromTheTeamModelImpl(final List<Player> players, final DiceModel diceModel) {
        super(players, diceModel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean runGame() {
        // TODO Auto-generated method stub
        return false;
    }

}

package game.powerupmenu.model;

import utils.graphics.controller.StageManager;

public class PowerupMenuModelImpl implements PowerupMenuModel {

    private final StageManager<?> s;

    public PowerupMenuModelImpl(final StageManager<?> s) {
        this.s = s;

    }

    @Override
    public final void returnToGame() {
        this.s.popScene();
    }

}

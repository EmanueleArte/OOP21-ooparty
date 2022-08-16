package game.powerupmenu.controller;

import game.powerupmenu.model.PowerupMenuModel;
import game.powerupmenu.model.PowerupMenuModelImpl;
import game.powerupmenu.view.PowerupMenuViewControllerImpl;
import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewUtils;

public class PowerupMenuControllerImpl extends GenericControllerAbstr implements PowerupMenuController {

    private final PowerupMenuModel model;
    private PowerupMenuViewControllerImpl viewController;

    public <S> PowerupMenuControllerImpl(final StageManager<S> s) {
        super(s);
        this.model = new PowerupMenuModelImpl();
    }

    @Override
    public final GenericViewController getViewController() {
        return this.getViewController();
    }

    @Override
    public final <C> void setViewController(final C viewController) throws IllegalArgumentException {
        if (viewController instanceof PowerupMenuViewControllerImpl) {
            this.viewController = (PowerupMenuViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of PowerupMenuViewControllerImpl");
        }
    }

    @Override
    public final void start() {
        GenericViewUtils.createScene(this.getStageManager(), this, PowerupMenuViewControllerImpl.class, "game/powerup.fxml");
        //this.viewController.initialize(p.getColor());
    }

}

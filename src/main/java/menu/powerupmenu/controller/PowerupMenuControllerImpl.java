package menu.powerupmenu.controller;

import menu.powerupmenu.model.PowerupMenuModel;
import menu.powerupmenu.model.PowerupMenuModelImpl;
import menu.powerupmenu.view.PowerupMenuViewControllerImpl;
import utils.view.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewUtils;

public class PowerupMenuControllerImpl extends GenericControllerAbstr implements PowerupMenuController {

    private final PowerupMenuModel model;
    private PowerupMenuViewControllerImpl viewController;

    public <S> PowerupMenuControllerImpl(final StageManager<S> s) {
        super(s);
        this.model = new PowerupMenuModelImpl(s);
    }

    @Override
    public final GenericViewController getViewController() {
        return this.viewController;
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
        GenericViewUtils.createScene(this.getStageManager(), this, PowerupMenuViewControllerImpl.class, "game/powerups.fxml");
        //this.viewController.initialize(p.getColor());
    }

    @Override
    public final void returnToGame() {
        this.model.returnToGame();
    }

}

package menu.powerupmenu.controller;

import java.util.Optional;

import game.player.Player;
import menu.powerupmenu.model.PowerupMenuModel;
import menu.powerupmenu.view.PowerupMenuViewController;
import utils.view.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;

/**
 * Implementation for the {@link PowerupMenuController} interface.
 */
public class PowerupMenuControllerImpl extends GenericControllerAbstr implements PowerupMenuController {

    private final PowerupMenuModel model;
    private PowerupMenuViewController viewController;

    /**
     * Constructor for this class.
     * 
     * @param <S> the scenes of the stage
     * @param s     the {@link StageManager}
     * @param model the {@link PowerupMenuModel} to use
     */
    public <S> PowerupMenuControllerImpl(final StageManager<S> s, final PowerupMenuModel model) {
        super(s);
        this.model = model;
    }

    @Override
    public final GenericViewController getViewController() {
        return this.viewController;
    }

    @Override
    public final void setViewController(final GenericViewController viewController) throws IllegalArgumentException {
        if (viewController instanceof PowerupMenuViewController) {
            this.viewController = (PowerupMenuViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of PowerupMenuViewController");
        }
    }

    @Override
    public final void start(final Player currentPlayer) {
        this.getStageManager().getGui().getViewFactory().createPowerupMenuView(this);
        this.model.setCurrentPlayer(currentPlayer);
        this.viewController.initializeScene(this.model.getCurrentPlayer().get().getPowerupList());
    }

    @Override
    public final void returnToGame() {
        this.getStageManager().popScene();
    }

    @Override
    public final void usePowerup(final String powerupType, final String targetName) {
        Optional<Player> target = this.model.getPlayers().stream().filter(x -> x.getNickname().equals(targetName))
                .findFirst();
        target.ifPresent(a -> {
            this.model.getCurrentPlayer().get().usePowerup(powerupType, target.get());
            this.returnToGame();
        });
    }

    @Override
    public final void updateTargetsList(final String powerupType) {
        this.viewController.setTargetsList(
                this.model.getCurrentPlayer().get().getPowerupList().stream()
                        .filter(x -> x.getPowerupType().equals(powerupType)).findFirst().get(),
                this.model.getPlayers(), this.model.getCurrentPlayer().get());
    }
}

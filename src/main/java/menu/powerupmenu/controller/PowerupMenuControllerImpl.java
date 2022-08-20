package menu.powerupmenu.controller;

import java.util.List;
import java.util.Optional;

import game.map.GameMap;
import game.player.Player;
import menu.common.controller.MenuController;
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

    private Player currentPlayer;
    private final List<Player> players;

    public <S> PowerupMenuControllerImpl(final StageManager<S> s, final List<Player> players) {
        super(s);
        this.model = new PowerupMenuModelImpl(s);
        this.players = players;
    }

    @Override
    public final GenericViewController getViewController() {
        return this.viewController;
    }

    @Override
    public final void setViewController(final GenericViewController viewController) throws IllegalArgumentException {
        if (viewController instanceof PowerupMenuViewControllerImpl) {
            this.viewController = (PowerupMenuViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of PowerupMenuViewControllerImpl");
        }
    }

    @Override
    public final void start(final Player currentPlayer) {
        GenericViewUtils.createScene(this.getStageManager(), this, "game/powerups.fxml");
        this.viewController.initialize(currentPlayer.getPowerupList(), this.players);
        this.currentPlayer = currentPlayer;
    }

    @Override
    public final void returnToGame() {
        this.model.returnToGame();
    }

    @Override
    public final void usePowerup(final String powerupType, final String targetName) {
        Optional<Player> target = this.players.stream().filter(x -> x.getNickname().equals(targetName)).findFirst();
        target.ifPresent(a -> {
            this.currentPlayer.usePowerup(powerupType, target.get());
            this.returnToGame();
        });
    }

}

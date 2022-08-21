package menu.powerupmenu.view;

import game.powerup.GenericPowerup;

import java.util.List;

import game.player.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import menu.powerupmenu.controller.PowerupMenuController;
import menu.powerupmenu.controller.PowerupMenuControllerImpl;
import utils.controller.GenericController;

/**
 * Implementation of the {@link PowerupMenuViewController} interface.
 */
public class PowerupMenuViewControllerImpl implements PowerupMenuViewController {

    private PowerupMenuController controller;

    @FXML
    private Button noPowerup;
    @FXML
    private ComboBox<String> powerupSelector;
    @FXML
    private HBox targetsList;

    @FXML
    public final void onPowerupSelected() {
        this.controller.updateTargetsList(this.powerupSelector.getValue());
    }

    @Override
    public final void setController(final GenericController controller) {
        if (controller instanceof PowerupMenuControllerImpl) {
            this.controller = (PowerupMenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of PowerupMenuController");
        }
    }

    @Override
    public final void setTargetsList(final GenericPowerup powerup, final List<Player> players,
            final Player currentPlayer) {
        this.targetsList.getChildren().clear();
        players.forEach(p -> {
            if ((powerup.useOnSelf() && p.equals(currentPlayer))
                    || (!powerup.useOnSelf() && !p.equals(currentPlayer))) {
                Button b = new Button(p.getNickname());
                b.setOnAction(a -> this.controller.usePowerup(this.powerupSelector.getValue(), p.getNickname()));
                b.setTextFill(p.getColor());
                this.targetsList.getChildren().add(b);
            }
        });
    }

    @Override
    public final void initializeScene(final List<GenericPowerup> powerups) {
        powerups.forEach(p -> {
            this.powerupSelector.getItems().add(p.getPowerupType());
        });
    }

    @Override
    @FXML
    public final void close() {
        this.controller.returnToGame();
    }
}

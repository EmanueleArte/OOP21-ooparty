package menu.powerupmenu.view;

import java.util.List;

import game.player.Player;
import game.powerup.GenericPowerup;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Font;
import menu.powerupmenu.controller.PowerupMenuController;
import menu.powerupmenu.controller.PowerupMenuControllerImpl;
import utils.view.GenericViewController;
import utils.controller.GenericController;

public class PowerupMenuViewControllerImpl implements GenericViewController {

    private PowerupMenuController controller;

    @FXML
    private Group powerupList;
    @FXML
    private Button noPowerup;
    @FXML
    private ComboBox<String> targetSelector;

    @Override
    public final void setController(final GenericController controller) {
        if (controller instanceof PowerupMenuControllerImpl) {
            this.controller = (PowerupMenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of PowerupMenuController");
        }
    }

    public final void initialize(final List<GenericPowerup> powerups, final List<Player> players) {
        players.forEach(p -> {
            this.targetSelector.getItems().add(p.getNickname());
        });
        powerups.forEach(p -> {
            Button b = new Button(p.getPowerupType());
            b.setLayoutY((powerups.indexOf(p) + 1) * 20);
            b.setFont(Font.font("Berlin Sans FB", 12));
            b.setOnAction(e -> {
                this.controller.usePowerup(p.getPowerupType(), this.targetSelector.getValue());
            });
            this.powerupList.getChildren().add(b);
        });
    }

    @FXML
    public final void close() {
        this.controller.returnToGame();
    }
}

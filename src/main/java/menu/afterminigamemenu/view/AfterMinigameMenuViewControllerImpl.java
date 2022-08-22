package menu.afterminigamemenu.view;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import game.player.Player;
import game.powerup.GenericPowerup;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import menu.common.controller.MenuController;
import utils.controller.GenericController;
import utils.enums.OrdinalNumber;
import utils.factories.PowerupFactoryImpl;

/**
 * ViewController for the after minigame menu.
 */
public class AfterMinigameMenuViewControllerImpl implements AfterMinigameMenuViewController {

    private static final int VBOX_WIDTH = 200;
    private static final int VBOX_HEIGHT = 200;
    private static final int MAX_COINS_FROM_MINIGAME = 16;

    private MenuController menuController;
    @FXML
    private List<VBox> vBoxes;
    @FXML
    private Text endGameText;

    @Override
    public final void setController(final GenericController controller) throws IllegalArgumentException {
        if (controller instanceof MenuController) {
            this.menuController = (MenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MenuController");
        }
    }

    @Override
    public final void makeLeaderboard(final List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            VBox v = this.vBoxes.get(i);

            this.setVBoxStyle(v, players.get(i));
            this.setPositionAndNickname(v, players.get(i).getNickname(), i);

            Label coinsEarned = (Label) v.getChildren().get(2);
            coinsEarned.setText(this.earnCoins(players, i) + " coins earned");

            if (i < players.size() / 2) {
                Label powerupGot = (Label) v.getChildren().get(3);
                powerupGot.setText("Got " + this.getPowerup(players, i).getPowerupType());
            }
        }
    }

    private GenericPowerup getPowerup(final List<Player> players, final int i) {
        PowerupFactoryImpl powerupFactory = new PowerupFactoryImpl();
        GenericPowerup powerup = powerupFactory.getRandomPowerup();
        players.get(i).addPowerup(powerup);
        return powerup;
    }

    private int earnCoins(final List<Player> players, final int i) {
        Random r = new Random();
        int coins = r.nextInt(MAX_COINS_FROM_MINIGAME / (i + 1)) + (MAX_COINS_FROM_MINIGAME / (i + 2));
        players.get(i).earnCoins(coins);
        return coins;
    }

    private String getPositionFromIndex(final int i) {
        Optional<OrdinalNumber> o = OrdinalNumber.intToOrdinalNumber(i + 1);
        if (o.isPresent()) {
            return o.get().getTextFormat();
        }
        return "";
    }

    @FXML
    private void exitMenu() {
        this.menuController.exit();
    }

    @Override
    public final void makeEndGameLeaderboard(final List<Player> players) {
        this.endGameText.setText("Game End");
        for (int i = 0; i < players.size(); i++) {
            VBox v = this.vBoxes.get(i);
            this.setVBoxStyle(v, players.get(i));
            this.setPositionAndNickname(v, players.get(i).getNickname(), i);
        }
    }

    private void setVBoxStyle(final VBox v, final Player p) {
        v.setBorder(Border.stroke(p.getColor()));
        v.setPrefSize(VBOX_WIDTH, VBOX_HEIGHT);
    }

    private void setPositionAndNickname(final VBox vBox, final String playerNickname, final int i) {
        Label positionLabel = (Label) vBox.getChildren().get(0);
        positionLabel.setText(this.getPositionFromIndex(i));

        Label playerNicknameLabel = (Label) vBox.getChildren().get(1);
        playerNicknameLabel.setText(playerNickname);
    }
}

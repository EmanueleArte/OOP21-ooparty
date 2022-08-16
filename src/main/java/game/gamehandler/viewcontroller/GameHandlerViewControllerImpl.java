package game.gamehandler.viewcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.dice.controller.DiceControllerImpl;
import game.dice.view.DiceViewImpl;
import game.gamehandler.controller.GameHandlerController;
import game.player.Player;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.util.Duration;
import utils.controller.GenericController;
import utils.enums.OrdinalNumber;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;
import utils.graphics.controller.StageManager;
import utils.graphics.controller.StageManagerImpl;
import utils.view.GenericViewController;

public class GameHandlerViewControllerImpl implements GenericViewController {

    private GameHandlerController controller;

    @FXML
    private Group banner;
    @FXML
    private Text bannerText;
    @FXML
    private Group avatars;
    @FXML
    private HBox rankPlayersContainer;

    private final Map<Player, Group> playerToAvatar = new HashMap<Player, Group>();

    @Override
    public final void setController(final GenericController controller) {
        if (controller instanceof GameHandlerController) {
            this.controller = (GameHandlerController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of GameHandlerController");
        }
    }

    public final void initialize(final List<Player> players) {
        List<Group> avatarsList = new ArrayList<Group>();
        this.avatars.getChildren().forEach(c -> {
            avatarsList.add((Group) c);
        });
        players.forEach(p -> {
            this.playerToAvatar.put(p, avatarsList.get(players.indexOf(p)));
            avatarsList.get(players.indexOf(p)).getChildren().forEach(c -> {
                if (c instanceof Circle) {
                    Circle head = (Circle) c;
                    head.setFill(p.getColor());
                }
                if (c instanceof Polygon) {
                    Polygon body = (Polygon) c;
                    body.setFill(p.getColor());
                }
            });
        });
        avatarsList.forEach(a -> {
            if (!this.playerToAvatar.values().contains(a)) {
                a.setVisible(false);
            }
        });

        initializeRank(players);
    }

    @FXML
    protected final void onEnter(final KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            this.nextStep();
        }
    }

    private void nextStep() {
        int progress = this.controller.nextStep();
        if (progress == TurnProgress.SHOW_BANNER.getProgress()) {
            this.showBanner("Turn " + this.controller.getTurnNumber());
        } else if (progress == TurnProgress.HIDE_BANNER.getProgress()) {
            this.hideBanner();
        } else if (progress == TurnProgress.PLAYERS_TURNS.getProgress()) {
            int playerProgress = this.controller.nextPlayerTurnStep();
            if (playerProgress == PlayerTurnProgress.SHOW_BANNER.getProgress()) {
                this.showBanner(this.controller.getCurrentPlayer().get().getNickname() + "'s turn");
            } else if (playerProgress == PlayerTurnProgress.HIDE_BANNER.getProgress()) {
                this.hideBanner();
            } else if (playerProgress == PlayerTurnProgress.MOVE_PLAYER.getProgress()) {
                this.movePlayer(this.controller.getCurrentPlayer().get(), 10);
            }
        }
    }

    private void showBanner(final String text) {
        bannerText.setText(text);
        FadeTransition fade = new FadeTransition(Duration.millis(1000), banner);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    private void hideBanner() {
        FadeTransition fade = new FadeTransition(Duration.millis(1000), banner);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
    }

    private void movePlayer(final Player p, final int movement) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this.playerToAvatar.get(p));
        transition.setDuration(Duration.millis(1000));
        transition.setByX(this.playerToAvatar.get(p).getLayoutX() + movement * 10);
        transition.play();
    }

    public void rollDice() {
        System.out.println("Dado tirato");
    }

    private void initializeRank(final List<Player> players) {
        System.out.println("init rank");
        players.forEach(p -> {
            VBox box = new VBox();
            Label nicknameLabel = new Label(p.getNickname());
            Label coinsLabel = new Label("Coins: " + p.getCoinsCount());
            Label starsLabel = new Label("Stars: " + p.getStarsCount());
            Label hpLabel = new Label("Hp: " + p.getLifePoints());
            Label rankLabel = new Label(OrdinalNumber.values()[players.indexOf(p)].getTextFormat());

            String cssVBoxLayout = "-fx-border-color: " + toHexString(p.getColor()) + ";\n"
                    + "-fx-border-insets: 5;\n"
                    + "-fx-border-width: 3;\n";

            box.setStyle(cssVBoxLayout);
            box.getChildren().addAll(nicknameLabel, coinsLabel, starsLabel, hpLabel, rankLabel);
            rankPlayersContainer.getChildren().add(box);
        });

        rankPlayersContainer.setSpacing(20);
    }

    private static String toHexString(final Color color) {
        int r = ((int) Math.round(color.getRed()     * 255)) << 24;
        int g = ((int) Math.round(color.getGreen()   * 255)) << 16;
        int b = ((int) Math.round(color.getBlue()    * 255)) << 8;
        int a = ((int) Math.round(color.getOpacity() * 255));

        return String.format("#%08X", (r + g + b + a));
      }
}

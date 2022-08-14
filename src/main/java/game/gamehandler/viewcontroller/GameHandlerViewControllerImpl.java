package game.gamehandler.viewcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import game.gamehandler.controller.GameHandlerController;
import game.map.GameMap;
import game.map.GameMapImpl;
import game.player.Player;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
import utils.GenericViewController;

public class GameHandlerViewControllerImpl implements GenericViewController {

    private static final int SQUARE_WIDTH = 75;
    private static final int SQUARE_HEIGHT = 75;
    private static final int MAP_WIDTH = 11;
    private static final int MAP_HEIGHT = 8;
    private static final int PLAYER_X_START = -825;
    private static final int PLAYER_Y_START = -600;
    private static final int COIN_DIM = 20;


    private GameHandlerController controller;

    @FXML
    private Group banner;
    @FXML
    private Text bannerText;
    @FXML
    private Group avatars;
    @FXML
    private HBox rankPlayersContainer;
    @FXML
    private GridPane mapGrid;
    @FXML
    private StackPane stackPaneContainer;

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

        GameMap map = new GameMapImpl();
        initializeMap(map);

        final List<Point2D> squarePositions = mapGrid.getChildren()
                .stream()
                .filter(l -> l instanceof Label)
                .map(l -> new Point2D(
                        mapGrid.getLayoutX() + GridPane.getRowIndex(l) * SQUARE_WIDTH,
                        mapGrid.getLayoutY() + GridPane.getColumnIndex(l) * SQUARE_HEIGHT))
                .collect(Collectors.toList());

        /*avatarsList.forEach(a -> {
            a.setLayoutX(PLAYER_X_START);
            a.setLayoutY(PLAYER_Y_START);
        });*/
        avatarsList.forEach(a -> System.out.println(a.isVisible() + ": " + a.getLayoutX() + " " + a.getLayoutY()));
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
                    + "-fx-border-width: 2;\n";
            box.setStyle(cssVBoxLayout);

            box.setPrefWidth(250);

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

    private void initializeMap(final GameMap map) {
         map.getSquares().stream().map(s -> {
            var label = new Label();
            //label.setText(map.getSquares().indexOf(s) + "");
            label.setId(map.getSquares().indexOf(s) + "");

            label.setPrefWidth(SQUARE_WIDTH);
            label.setPrefHeight(SQUARE_HEIGHT);
            label.setAlignment(Pos.CENTER);

            String cssLabelLayout = "-fx-border-color: black;\n"
                    + "-fx-border-insets: 2;\n"
                    + "-fx-border-width: 1;\n"
                    + "-fx-margin: 2px;\n";
            label.setStyle(cssLabelLayout);

            return label;
        }).forEach(l -> {
            mapGrid.getChildren().add(l);
            var index = Integer.parseInt(l.getId());
            var row = 0;
            var col = 0;
            if (index < MAP_WIDTH) {
                row = 0;
                col = index;
            } else if (index < MAP_WIDTH + MAP_HEIGHT - 1) {
                row = index - MAP_WIDTH + 1;
                col = MAP_WIDTH - 1;
            } else if (index < 2 * MAP_WIDTH + MAP_HEIGHT - 2) {
                row = MAP_HEIGHT - 1;
                col = MAP_WIDTH - index + 16;
            } else {
                row = MAP_HEIGHT - index + 26;
                col = 0;
            }

            if (row == 0 && col == 0) {
                l.setText("Start");
            }

            GridPane.setRowIndex(l, row);
            GridPane.setColumnIndex(l, col);
            GridPane.setHalignment(l, HPos.CENTER);
            GridPane.setValignment(l, VPos.CENTER);

            if (map.getSquares().get(index).isCoinsGameMapSquare()) {
                var coin = new Image("game/coin.png");
                ImageView view = new ImageView(coin);
                view.setFitHeight(GameHandlerViewControllerImpl.COIN_DIM);
                view.setPreserveRatio(true);
                l.setGraphic(view);
            }
        });

        map.getSquares().forEach(l -> {

            /*var coin = new Image("game/coin.png");
            ImageView view = new ImageView(coin);
            view.setFitHeight(80);
            view.setPreserveRatio(true);
            l.setGraphic(view);*/
            /*String coinLayout = "-fx-border-color: yellow;\n"
                    + "-fx-border-insets: 20;\n"
                    + "-fx-border-width: 10;\n"
                    + "-fx-margin: 2px;\n"
                    + "-fx-border-radius: 10px;\n";
            coin.setStyle(coinLayout);

            this.mapGrid.getChildren().add(coin);
            var index = Integer.parseInt(coin.getId());
            var row = 0;
            var col = 0;
            if (index < MAP_WIDTH) {
                row = 0;
                col = index;
            } else if (index < MAP_WIDTH + MAP_HEIGHT - 1) {
                row = index - MAP_WIDTH + 1;
                col = MAP_WIDTH - 1;
            } else if (index < 2 * MAP_WIDTH + MAP_HEIGHT - 2) {
                row = MAP_HEIGHT - 1;
                col = MAP_WIDTH - index + 16;
            } else {
                row = MAP_HEIGHT - index + 26;
                col = 0;
            }

            GridPane.setRowIndex(coin, row);
            GridPane.setColumnIndex(coin, col);
            GridPane.setHalignment(coin, HPos.CENTER);
            GridPane.setValignment(coin, VPos.CENTER);*/
        });
    }
}

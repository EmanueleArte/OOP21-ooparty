package minigames.yourethebobomb.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import minigames.common.view.MinigameViewControllerAbstr;
import minigames.yourethebobomb.controller.YoureTheBobombController;
import utils.controller.GenericController;

/**
 * Implementation of {@link YoureTheBobombViewController} and extension of
 * {@link MinigameViewControllerAbstr}.
 */
public class YoureTheBobombViewControllerImpl extends MinigameViewControllerAbstr
        implements YoureTheBobombViewController {

    @FXML
    private List<Button> tiles;
    @FXML
    private Button closeGame;

    private YoureTheBobombController controller;
    private Map<Button, Integer> tileValues;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setController(final GenericController controller) throws IllegalArgumentException {
        if (!(controller instanceof YoureTheBobombController)) {
            throw new IllegalArgumentException("The parameter must be an instance of CutFromTheTeamController");
        }
        this.controller = (YoureTheBobombController) controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startNextTurn() {
        throw new UnsupportedOperationException("This method must not be called on this minigame");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final List<Integer> tiles) {
        this.tiles.forEach(b -> b.setDisable(true));
        this.tileValues = tiles.stream().peek(i -> this.tiles.get(i).setDisable(false))
                .collect(Collectors.toMap(i -> this.tiles.get(i), i -> i));
        this.tiles.stream().filter(b -> !this.tileValues.containsKey(b)).forEach(b -> b.setText("Boomm"));
        this.closeGame.setDisable(true);
        this.controller.updateCurrentPlayerLabel();
    }

    @FXML
    private void pickTile(final ActionEvent event) {
        if (!(event.getTarget() instanceof Button)) {
            throw new IllegalCallerException("This method must be called by a button");
        }
        final var button = (Button) event.getTarget();
        this.controller.pickTile(this.tileValues.get(button));
        this.controller.updateCurrentPlayerLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enableCloseButton() {
        this.closeGame.setDisable(false);
        this.tiles.forEach(b -> b.setDisable(true));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onEnter(final KeyEvent ke) {
    }

    @FXML
    private void closeGame() {
        this.controller.closeGame();
    }

}

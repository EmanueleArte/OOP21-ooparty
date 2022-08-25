package minigames.cutfromtheteam.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import minigames.common.view.MinigameViewControllerAbstr;
import minigames.cutfromtheteam.controller.CutFromTheTeamController;
import utils.controller.GenericController;

/**
 * Implementation of {@link CutFromTheTeamViewController} and extension of
 * {@link MinigameViewControllerAbstr}.
 */
public class CutFromTheTeamViewControllerImpl extends MinigameViewControllerAbstr
        implements CutFromTheTeamViewController {

    @FXML
    private List<Button> ropes;
    @FXML
    private Button buttonToEnableExit;

    private CutFromTheTeamController controller;
    private Map<Button, Boolean> ropeValues = new HashMap<>();

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
    public void setController(final GenericController controller) throws IllegalArgumentException {
        if (!(controller instanceof CutFromTheTeamController)) {
            throw new IllegalArgumentException("The parameter must be an instance of CutFromTheTeamController");
        }
        this.controller = (CutFromTheTeamController) controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final List<Boolean> ropes) {
        this.ropeValues = this.ropes.stream().collect(Collectors.toMap(b -> b, b -> ropes.get(this.ropes.indexOf(b))));
        this.buttonToEnableExit.setDisable(true);
        this.controller.updateCurrentPlayerLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enableCloseButton() {
        this.buttonToEnableExit.setDisable(false);
        this.ropes.forEach(b -> b.setDisable(true));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onEnter(final KeyEvent ke) {
    }

    @FXML
    private void pickRope(final ActionEvent event) {
        if (!(event.getTarget() instanceof Button)) {
            throw new IllegalCallerException("This method must be called by a button");
        }
        final var button = (Button) event.getTarget();
        button.setText(this.ropeValues.get(button) ? "Boooommm" : "Fiuuu");
        button.setDisable(true);
        this.controller.pickRope(this.ropeValues.get(button));
        this.controller.nextTurn();
        this.controller.updateCurrentPlayerLabel();
    }

    @FXML
    private void closeGame() {
        this.controller.closeGame();
    }

}

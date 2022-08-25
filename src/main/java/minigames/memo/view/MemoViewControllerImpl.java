package minigames.memo.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import minigames.common.view.MinigameViewControllerAbstr;
import minigames.memo.controller.MemoController;
import utils.GuiUtils;
import utils.controller.GenericController;

/**
 * Implementation of {@link MemoViewController} and extension of
 * {@link MinigameViewControllerAbstr}.
 */
public class MemoViewControllerImpl extends MinigameViewControllerAbstr implements MemoViewController {

    @FXML
    private List<Button> cards;
    @FXML
    private Button buttonToEnableNextTurn;

    private MemoController memoController;
    private Map<Button, Integer> cardValues = new HashMap<>();
    private Optional<Button> lastCard = Optional.empty();
    private Optional<Button> firstButtonToHide = Optional.empty();
    private Optional<Button> secondButtonToHide = Optional.empty();
    private boolean cardsAreShown;

    public MemoViewControllerImpl() {
    }

    /**
     * This method is not usable for this minigame.
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
        if (controller instanceof MemoController) {
            this.memoController = (MemoController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MemoController");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final List<Integer> cards) {
        this.cardValues = this.cards.stream().filter(b -> this.cards.indexOf(b) < cards.size())
                .collect(Collectors.toMap(b -> b, b -> cards.get(this.cards.indexOf(b))));
        this.cards.stream().filter(b -> this.cards.indexOf(b) > cards.size() - 1).forEach(GuiUtils::hideNode);
        this.buttonToEnableNextTurn.setDisable(true);
        this.cardsAreShown = false;
        this.memoController.updateCurrentPlayerLabel();
    }

    @FXML
    private void pickCard(final ActionEvent event) throws InterruptedException {
        if (!(event.getTarget() instanceof Button)) {
            throw new IllegalCallerException("This method must be called by a button");
        }
        if (this.cardsAreShown) {
            return;
        }
        final var button = (Button) event.getTarget();
        button.setText("" + this.cardValues.get(button));
        button.setDisable(true);
        this.memoController.pickCard(this.cardValues.get(button));

        if (this.lastCard.isEmpty()) {
            this.lastCard = Optional.of(button);
            return;
        }

        final var tempLastCard = this.lastCard.get();
        this.lastCard = Optional.empty();

        if (this.memoController.nextTurn()) {
            return;
        }

        this.cardsAreShown = true;
        this.buttonToEnableNextTurn.setDisable(false);
        this.firstButtonToHide = Optional.of(button);
        this.secondButtonToHide = Optional.of(tempLastCard);
    }

    @FXML
    private void enableNextTurn(final ActionEvent event) {
        if (!(event.getTarget() instanceof Button)) {
            throw new IllegalCallerException("This method must be called by a button");
        }
        if (!this.cardsAreShown) {
            return;
        }
        this.memoController.updateCurrentPlayerLabel();
        this.buttonToEnableNextTurn.setDisable(true);

        this.firstButtonToHide.get().setText("");
        this.firstButtonToHide.get().setDisable(false);
        this.secondButtonToHide.get().setText("");
        this.secondButtonToHide.get().setDisable(false);
        this.firstButtonToHide = Optional.empty();
        this.secondButtonToHide = Optional.empty();
        this.cardsAreShown = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onEnter(final KeyEvent ke) {
    }

}

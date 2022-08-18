package minigames.memo.view;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import minigames.common.view.MinigameViewControllerAbstr;
import minigames.memo.controller.MemoController;
import utils.controller.GenericController;

public class MemoViewControllerImpl extends MinigameViewControllerAbstr implements MemoViewController {

    @FXML
    private List<Button> cards;
    private MemoController memoController;

    public MemoViewControllerImpl() {
    }

    @Override
    public void startNextTurn() {
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
     * This method wait for you to click a card.
     * 
     * @returns the value of the card chosen.
     */
    @Override
    public int pickCard() {
        return 0;
    }

    /**
     * Disable the buttons of the guessed pair of cards and display their values.
     */
    @Override
    public void delete(final int firstCard, final int secondCard) {
        final var cardValue = this.cards.get(firstCard);
        this.cards.stream().filter(i -> i.equals(cardValue)).forEach(b -> {
            b.setText("" + this.memoController.getCard(firstCard));
            b.setDisable(true);
        });
    }

    @Override
    protected void onEnter(final KeyEvent ke) {
    }

}

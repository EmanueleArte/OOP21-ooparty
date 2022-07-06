package minigames.mastermind.model;

import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.common.model.MinigameModelAbstr;
import utils.NoticeUser;
import utils.graphics.StageManager;

/**
 * Implementation of {@link NoticeUser} and extension of {@link minigames.common.model.MinigameModelAbstr}.
 */
public class MastermindModelImpl<S, U> extends MinigameModelAbstr<S, U> implements NoticeUser {

	private final List<Label> attempts;
	private Label noticeLabel;
	private TextField inputField;
	
	public MastermindModelImpl(final List<U> players, final StageManager<S> s, final List<Label> attempts) {
		super(players, s);
		this.attempts = attempts;
	}

	@Override
	public void runGame() {
		this.players.forEach(player -> {
			this.hideAttempts();
		});
	}

	@Override
	public void setNotice(final Label noticeLabel) {
		this.noticeLabel = noticeLabel;
	}

	@Override
	public void clearNotice() {
		this.noticeLabel.setText("");
	}
	
	@Override
	public void showNotice(final String notice) {
		this.noticeLabel.setText(notice);
	}
	
	/**
	 * This method sets the input field.
	 * @param inputField the {@link TextField} where a player puts his input
	 */
	public void setInputField(final TextField inputField) {
		this.inputField = inputField;
	}
	
	/**
	 * This method hides all attempts labels.
	 */
	private void hideAttempts() {
		this.attempts.forEach(attempt -> {
			attempt.setVisible(false);
			attempt.setManaged(false);
		});
	}
	
	/**
	 * This method gets the content of the input field.
	 * @return the {@link String} into the input field
	 */
	private String getGuessAttempt() {
		return this.inputField.getText();
	}

}

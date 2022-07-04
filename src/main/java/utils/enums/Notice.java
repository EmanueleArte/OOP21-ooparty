package utils.enums;

public enum Notice {
	GAME_CREATION_ERROR("There are some nicknames or/and colors duplicated or empty.");
	
	private final String notice;
	
	/**
	 * This method returns the corresponding advice string.
	 * @return the advice string
	 */
	public String getNotice() {
		return this.notice;
	}
	
	Notice(final String notice) {
		this.notice = notice;
	}
}

/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * Manages which predefined levels are unlocked for the player.
 * The first level is always available by default, while the rest
 * may be unlocked as the player progresses.  
 *
 * Persistence is not yet implemented, but placeholders exist for
 * loading and saving level availability across sessions.
 *
 * @author juad
 */
package domain;

public class LevelAvailableness {
	public static final int MAX_LEVELS = 40;
	private boolean[] levelAvailableness;

	public LevelAvailableness () {
		this.levelAvailableness = new boolean[MAX_LEVELS];
		this.levelAvailableness[0] = true;
		this.loadLevelsFromPreviousSessions();
	}

	/**
	 * Loads previously unlocked levels from storage.
	 * (Persistence not yet implemented.)
	 */
	private void loadLevelsFromPreviousSessions () {
		// TODO: Load saved level states once persistence is added.
	}

	/**
	 * Marks the specified level as available to the player.
	 *
	 * @param level Level number starting at 0.
	 */
	public void setLevelAsAvaialble (final int level) {
		this.levelAvailableness[level] = true;
	}

	/**
	 * Saves any changes made to the level availability state.
	 * (Persistence not yet implemented.)
	 */
	public void saveChanges () {
		System.out.println("TODO: saving changes with respect to levels: To be implemented...");
	}

	/**
	 * Returns the boolean array representing the availability
	 * status of all predefined levels.
	 *
	 * @return Array of unlocked levels.
	 */
	public boolean[] getAvailableLevels () {
		return this.levelAvailableness;
	}
}

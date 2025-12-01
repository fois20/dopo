/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * Acts as the communication bridge between the visual layer (views)
 * and the domain logic. Following the MVC pattern, this class exposes
 * high-level operations that the view can request without needing to
 * touch the underlying model or internal game mechanics.
 *
 * @author juad
 */
package domain;

import domain.map.LevelLoader;
import exceptions.BLogger;
import exceptions.SharedException;

public class Control {

	private LevelAvailableness levelAvailableness;
	private LevelLoader loader;
	private int levelNumber;

	public Control () {	
		this.levelAvailableness = new LevelAvailableness();
		this.loader = new LevelLoader();
	}

	/**
	 * Provides the view with the current list of which predefined
	 * levels are available to play.
	 *
	 * @return Boolean array where each index indicates whether a level is unlocked.
	 */
	public boolean[] pleaseProvideListOfAvailableLevels () {
		return this.levelAvailableness.getAvailableLevels();
	}

	/**
	 * Persists any changes made to the level availability configuration.
	 * Typically invoked when the application is closing.
	 */
	public void pleaseSaveChangesOnLevelAvailableness () {
		this.levelAvailableness.saveChanges();
	}

	/**
	 * Requests the loading of a predefined level. This method also stores
	 * the level number so the GUI can display the correct title or metadata.
	 *
	 * Any issue encountered during level loading is captured and logged.
	 *
	 * @param level Index of the level selected by the user (starting at 0).
	 */
	public void pleaseLoadPredefinedLevel (final int level) {
		this.levelNumber = level;

		try {
			this.loader.loadPredefinedLevel(level);
		} catch (final SharedException e) {
			BLogger.logError(BLogger.SEVERE, e);
		}
	}

	/**
	 * Returns the index of the current level that was requested for loading.
	 *
	 * @return Level number selected by the user.
	 */
	public int pleaseIndicateTheLevelNumber () {
		return this.levelNumber;
	}
}

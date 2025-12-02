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
import domain.map.BluePrint;
import domain.map.Drawable;
import domain.map.Loader;
import domain.map.chars.CharType;
import domain.map.chars.Character;
import domain.map.chars.CharacterFactory;
import domain.map.chars.Position;
import domain.map.tiles.Tile;
import domain.map.tiles.TileBehaviors;
import exceptions.BLogger;
import exceptions.SharedException;

public class Control {
	private LevelAvailableness levelAvailableness;
	private int level;
	private Loader loader;
	private BluePrint bp;
	
	private Character ch1;
	private Character ch2;
	
	private LevelContextualizer contextzr;

	public Control () {	
		this.levelAvailableness = new LevelAvailableness();
		this.loader = new Loader();
		this.contextzr = new LevelContextualizer();
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
		try {
			this.bp = this.loader.setBluePrintToBeUsed(level);
		} catch (final SharedException e) {
			BLogger.logError(BLogger.SEVERE, e);
		}
		this.level = level;
	}

	/**
	 * Returns the index of the current level that was requested for loading.
	 *
	 * @return Level number selected by the user.
	 */
	public int pleaseIndicateTheLevelNumber () {
		this.contextzr = this.loader.loadLevel();
		return this.level;
	}
	
	public BluePrint getBluePrint () {
		return this.bp;
	}
	
	public Tile getTileAt (final int row, final int col) {
		return this.contextzr.getTileAt(row, col);
	}
		
	public void setCharTypeOne (final CharType type) {
		this.ch1 = CharacterFactory.get(type);
	}
	
	public Character getCharacter1 () {
		return this.ch1;
	}
	
	public void characterTryingToMove (final MotionDirection towards, final Character ch) {
		ch.move(towards, this.contextzr);
	}
}



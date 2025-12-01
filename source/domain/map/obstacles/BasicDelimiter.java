/**    _
 *   ,' `,
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * BasicDelimiter represents the solid boundary tile used in the map.
 * It uses a fixed sprite and cannot be destroyed by any in-game action.
 *
 * This tile is typically placed around the edges of the level or in
 * locations where the player and enemies should not pass through.
 *
 * @author juad - 2025
 */
package domain.map.obstacles;

import domain.map.Tile;
import presentation.constants.Paths;

public class BasicDelimiter extends Tile {
	private static final String SPRITE_PATH = Paths.DELIMITER_BASIC;	
	
	public BasicDelimiter () {
		super(SPRITE_PATH);
	}	

	/**
	 * Indicates whether this tile can be destroyed.
	 *
	 * @return false, because delimiter tiles are solid boundaries.
	 */
	public boolean canBeDestroyed () {
		return false;
	}
}

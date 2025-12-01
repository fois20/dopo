/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * Represents an ice block obstacle. This tile behaves like a delimiter
 * but can be destroyed during gameplay. It has two visual states:
 * normal and broken.
 *
 * The tile uses the image paths defined in {@link Paths}.
 *
 * @author juad - 2025
 */
package domain.map.obstacles;

import domain.map.Tile;
import presentation.constants.Paths;

public class IceBlock extends Tile
{
	private static final String NORMAL_STATE_IMG_PATH = Paths.BLOCK_ICE_NORMAL_STATE;
	private static final String BROKEN_STATE_IMG_PATH = Paths.BLOCK_ICE_BROKEN_STATE;
	
	public IceBlock () {
		super(NORMAL_STATE_IMG_PATH, BROKEN_STATE_IMG_PATH);
	}

	/**
	 * Indicates whether this tile can be destroyed.
	 *
	 * @return true, because IceBlock tiles are breakable.
	 */
	@Override public boolean canBeDestroyed () {
		return true;
	}
}

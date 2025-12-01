/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * Factory class used to create Tile instances based on a character
 * identifier. This keeps map loading simple and avoids spreading tile
 * instantiation logic across the codebase.
 *
 * If the tile type is not recognized, this method returns null.
 *
 * @author juad
 */
package domain.map;

import domain.map.obstacles.BasicDelimiter;

public class TileFactory {	
	
	/**
	 * Creates and returns a Tile object according to the given type.
	 *
	 * The character should correspond to one of the identifiers defined
	 * in {@link TileId}. For example, {@link TileId.BASIC_DELIMITER} creates a
	 * {@link BasicDelimiter} tile.
	 *
	 * @param typeof Character indicating the tile type to create.
	 * @return	An instance of Tile matching the type, or null if no match exists.
	 */
	public static Tile createTile (final char typeof) {
		switch (typeof) {
			case TileId.BASIC_DELIMITER: { return new BasicDelimiter(); }
		}
		return null;
	}
}

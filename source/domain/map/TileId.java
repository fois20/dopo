/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * Defines the character identifiers used to represent different
 * types of tiles inside a map blueprint. These identifiers allow
 * the {@link LevelLoader} to translate simple characters into the
 * correct Tile objects during level construction.
 *
 * Each character corresponds to a specific tile type. For example,
 * a dot represents empty space while a hash represents a basic
 * delimiter block.
 *
 * @author juad
 */
package domain.map;

public final class TileId {
	public static final char EMPTY = '.';
	public static final char BASIC_DELIMITER = '#';

	/**
	 * Indicates whether the given character represents a delimiter tile.
	 *
	 * @param thing Character to evaluate.
	 * @return true if the character corresponds to a delimiter type.
	 */
	public static boolean isDelimiter (final char thing) {
		return (thing == BASIC_DELIMITER);
	}
}

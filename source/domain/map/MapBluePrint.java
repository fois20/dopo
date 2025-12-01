/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * The idea is simple: a MapBluePrint is just an immutable wrapper around a
 * programmer-defined array of strings. Each string represents a row of the map
 * and each character in that string represents a tile.
 *
 * This class also centralizes validation logic, ensuring no poor programmer
 * (including me) accidentally breaks the dimensions or formatting of a map.
 *
 * @author juad - 2025
 */
package domain.map;

import exceptions.SharedException;

public final class MapBluePrint {

	private static final String INVALID_ROW_DIMENSIONS = "ROWS";
	private static final String INVALID_COL_DIMENSIONS = "COLS";

	public static final int NUMER_OF_ROWS = 18;
	public static final int NUMER_OF_COLS = 18;

	private final String[] map;

	/**
	 * Private constructor — enforces creation through factory methods.
	 *
	 * @param map raw array of strings describing the map
	 */
	private MapBluePrint (final String[] map) {
		this.map = map;
	}

	/**
	 * Returns the internal map. No cloning is performed since the map is not meant
	 * to be modified after creation — treat it as read-only.
	 *
	 * @return string array representing the map
	 */
	public String[] getMap () {
		return this.map;
	}

	/**
	 * Retrieves the tile character located at a specific row and column.
	 *
	 * @param row vertical index (0-based)
	 * @param col horizontal index (0-based)
	 * @return character representing whatever lives at that position
	 */
	public char getThingAt (final int row, final int col) {
		return this.map[row].charAt(col);
	}

	/**
	 * Validates a BluePrint before using it. Right now, validation only ensures the
	 * map has the correct rectangular dimensions, but this method can be expanded
	 * with additional checks (characters allowed, boundaries closed, etc).
	 *
	 * @param bp blueprint to validate
	 * @throws SharedException if the blueprint has invalid structure
	 */
	public static void validateBluePrint (final MapBluePrint bp) throws SharedException {
		final String[] map = bp.getMap();

		if (map.length != NUMER_OF_ROWS) {
			throw new SharedException(SharedException.invalidMapDimensions(INVALID_ROW_DIMENSIONS));
		}

		for (int i = 0; i < NUMER_OF_ROWS; i++) {
			if (map[i].length() != NUMER_OF_COLS) {
				throw new SharedException(SharedException.invalidMapDimensions(INVALID_COL_DIMENSIONS));
			}
		}

		/* TODO: make this more powerful by adding more conditions */
	}

	/**
	 * Creates the map number one.
	 * This is your very first playable scenario—pure nostalgia and pure beauty.
	 * 
	 * The map returned is immutable and validated before being given to the caller.
	 *
	 * @return the first pre-defined map in the game
	 * @throws SharedException if the map fails validation (unlikely unless someone edit it)
	 */
	public static MapBluePrint getMap1 () throws SharedException {
		final String[] map = {
			"##################",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"#................#",
			"##################",
		};

		final MapBluePrint bp = new MapBluePrint(map);
		validateBluePrint(bp);
		return bp;
	}
}
/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * Loads levels for the game. This class takes a map description
 * provided either by the user or by a predefined blueprint, and
 * converts that description into a matrix of Tile objects.
 *
 * The predefined maps come from {@link MapBluePrint}, and each tile
 * character is transformed using {@link TileFactory}.
 *
 * This class is a key part of the map system since it performs the
 * translation from blueprint data into the actual objects used by
 * the game.
 *
 * @author juad - 2025
 */
package domain.map;

import exceptions.ProgrammerException;
import exceptions.SharedException;

public final class LevelLoader {	
	
	/**
	 * Loads a level based on a file provided by the user.
	 *
	 * This feature is not yet implemented.
	 *
	 * @param filePath	Path to the external level file.
	 * @return	A matrix of Tile objects or null until implemented.
	 */
	public Tile [][] loadLevelGivenByUser (final String filePath) {
		return null;
	}
	
	/**
	 * Loads one of the predefined levels.
	 *
	 * This method assumes the call comes from selecting a level
	 * in {@link presentation.SelectLevelView} through the {@link Controller}.
	 * Because of this assumption, any issue during loading is considered
	 * a programmer error and results in a {@link ProgrammerException}.
	 *
	 * @param level Level index starting at 0.
	 * @return	A Tile matrix representing the loaded map.
	 * @throws SharedException If any shared-level error occurs while loading.
	 */
	public Tile [][] loadPredefinedLevel (final int level) throws SharedException {
		MapBluePrint bp = null;

		switch (level) {
			case 0: { bp = MapBluePrint.getMap1(); break; }
			default: {
				throw new ProgrammerException(ProgrammerException.unimplementedLevel(level));
			}
		}

		final Tile [][] tiles = new Tile[MapBluePrint.NUMER_OF_ROWS][MapBluePrint.NUMER_OF_COLS];

		for (int row = 0; row < MapBluePrint.NUMER_OF_ROWS; row++) {
			for (int col = 0; col < MapBluePrint.NUMER_OF_COLS; col++) {
				final char id = bp.getThingAt(row, col);
				tiles[row][col] = TileFactory.createTile(id);
				System.out.print(id);
			}
			System.out.println("");
		}
		
		return tiles;
	}
}

package domain.map;

import domain.LevelContextualizer;
import exceptions.BLogger;
import exceptions.ProgrammerException;
import exceptions.SharedException;

public class Loader {
	private BluePrint bp;
	
	public BluePrint setBluePrintToBeUsed (final int level) throws SharedException {
		switch (level) {
			case 0: { this.bp = BluePrint.getMap1(); break; }
			default: {
				throw new ProgrammerException(ProgrammerException.unimplementedLevel(level));
			}
		}
		
		return this.bp;
	}

	public Drawable [][] loadLevelGivenByUser (final String filePath) {
		return null;
	}
	
	public LevelContextualizer loadLevel () {
		final LevelContextualizer lc = new LevelContextualizer();
		
		for (int row = 0; row < BluePrint.NUMBER_OF_ROWS; row++) {
			for (int col = 0; col < BluePrint.NUMBER_OF_COLS; col++) {
				final char id = this.bp.getLocatedAt(row, col);
				try {
					lc.setTileAt(row, col, TileFactory.get(id));
				} catch (final SharedException e) {
					BLogger.logError(BLogger.SEVERE, e);
				}
				System.out.print(id);
			}
			System.out.println("");
		}
		return lc;
	}
	
	public BluePrint getBluePrint () {
		return this.bp;
	}
}

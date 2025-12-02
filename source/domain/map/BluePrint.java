package domain.map;

import domain.map.chars.Position;
import exceptions.SharedException;

public class BluePrint {
	private static final String INVALID_ROWS_DIMENSIONS = "ROWS";
	private static final String INVALID_COLS_DIMENSIONS = "COLS";
	
	public static final int NUMBER_OF_ROWS = 18;
	public static final int NUMBER_OF_COLS = 18;
	
	private final String [] map;
	private final Position player1position;
		
	private BluePrint (final String [] map, final Position p1p) {
		this.map = map;
		this.player1position = p1p;
	}
	
	public String [] getMap () {
		return this.map;
	}
	
	public char getLocatedAt (final int row, final int col) {
		return this.map[row].charAt(col);
	}

	public Position getPlayer1Position () {
		return this.player1position;
	}
	
	public static void validateBluePrint (final BluePrint bp) throws SharedException {
		final String[] map = bp.getMap();

		if (map.length != NUMBER_OF_ROWS) {
			throw new SharedException(SharedException.invalidMapDimensions(INVALID_ROWS_DIMENSIONS));
		}

		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			if (map[i].length() != NUMBER_OF_COLS) {
				throw new SharedException(SharedException.invalidMapDimensions(INVALID_COLS_DIMENSIONS));
			}
		}

		/* TODO: make this more powerful by adding more conditions */
	}
	
	public static BluePrint getMap1 () throws SharedException {
		final String[] map = {
			"##################",
			"##**************##",
			"#*h.............*#",
			"#*.........hHh..*#",
			"#*...H..........*#",
			"#*..***....***..*#",
			"#*..*........*..*#",
			"#*..*.H......*..*#",
			"#*..*......h.*..*#",
			"#*..*........*.h*#",
			"#*..*........*..*#",
			"#*..*...H....*..*#",
			"#*..***....***..*#",
			"#*...........Hh.*#",
			"#*...H...H......*#",
			"#*..hhH.........*#",
			"##**************##",
			"##################",
		};
		
		final Position p1p = new Position(8, 13);
		final BluePrint bp = new BluePrint(map, p1p);
		validateBluePrint(bp);
		return bp;
	}	
}

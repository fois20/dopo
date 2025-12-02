package domain.map.tiles;

import presentation.constants.Paths;

public class BasicDelimiter extends Tile {
	private static final String FRONT_SPRITE_PATH = Paths.SPRITE_BASIC_DELIMITER_FRONT;

	public BasicDelimiter () {
		super(FRONT_SPRITE_PATH);
	}

	@Override public boolean isBreakable() {
		return false;
	}
	
	@Override public boolean isWalkable () {
		return false;
	}
}

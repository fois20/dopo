package domain.map.tiles;

import presentation.constants.Paths;

public class Snow extends Tile {
	private static final String FRONT_SPRITE_PATH = Paths.SPRITE_NONE;

	public Snow () {
		super(FRONT_SPRITE_PATH);
	}

	@Override public boolean isBreakable() {
		return false;
	}
	
	@Override public boolean isWalkable () {
		return true;
	}
}

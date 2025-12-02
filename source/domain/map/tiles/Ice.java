package domain.map.tiles;

import presentation.constants.Paths;

public class Ice extends Tile {
	private static final String FRONT_SPRITE_PATH = Paths.SPRITE_ICE_FRONT;
	private static final String BROKEN_SPRITE_PATH = Paths.SPRITE_ICE_BROKEN;

	public Ice() {
		super(FRONT_SPRITE_PATH, BROKEN_SPRITE_PATH);
	}
	
	@Override public boolean isBreakable() {
		return true;
	}
	
	@Override public boolean isWalkable () {
		return false;
	}
}
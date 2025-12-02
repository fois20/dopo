package domain.map.tiles;

import presentation.constants.Paths;

public class SmallSnowHeap extends Tile {
	private static final String SPRITE_FRONT_PATH = Paths.SPRITE_SMALL_SNOW_HEAP_FRONT;
	
	public SmallSnowHeap () {
		super(SPRITE_FRONT_PATH);
	}

	@Override public boolean isBreakable() {
		return false;
	}
	
	@Override public boolean isWalkable () {
		return true;
	}
}

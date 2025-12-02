package domain.map.chars.cream;

import domain.LevelContextualizer;
import domain.MotionDirection;
import domain.MotionEndsUp;
import domain.map.chars.Character;
import domain.map.chars.Position;
import domain.map.tiles.Tile;

public class IceCream extends Character {
	public IceCream (final String frontPath, final String backPath, final String leftPath, final String rightPath) {
		super(frontPath, backPath, leftPath, rightPath);
	}

	@Override
	public MotionEndsUp move(final MotionDirection towards, final LevelContextualizer lc) {	
		final Position finalxy = super.simulateMotion(towards);	
		final Tile tile = lc.getTileAt(finalxy.getY(), finalxy.getX());
		
		if (tile.isWalkable()) {
			this.pos = finalxy;
			return MotionEndsUp.JUST_MOVING;
		}
		// TODO: check for enemies and fruits
		
		System.out.println("cannot move: " + tile.getClass());
		return MotionEndsUp.GOT_BLOCKED_FUCKK;
	}
}
package domain.map.tiles;

import domain.map.DrawableAdapter;

public abstract class Tile extends DrawableAdapter {
	protected Tile (final String frontSpritePath) {
		super(frontSpritePath);
	}

	protected Tile (final String frontSpritePath, final String brokenSpritePath) {
		super(frontSpritePath, brokenSpritePath);
	}

	public abstract boolean isBreakable ();
	public abstract boolean isWalkable ();
}

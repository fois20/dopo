/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * A Tile represents a non-living map element. Some tiles can be destroyed
 * (like ice blocks), while others are eternal and immovable (like delimiters).
 * 
 * Each tile may have two possible sprites:
 *  - A normal/default sprite.
 *  - A broken/destroyed sprite (only for tiles that support destruction).
 *
 * @author juad - 2025
 */
package domain.map;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Tile {
	protected Image normalStateSprite;
	protected Image brokenStateSprite;

	/**
	 * Creates a tile that only has a normal/static sprite.
	 *
	 * @param normalStateImgPath path to the sprite representing the tile in its standard state
	 */
	public Tile (final String normalStateImgPath) {
		this.normalStateSprite = new ImageIcon(normalStateImgPath).getImage();
	}

	/**
	 * Creates a tile that can appear in two states: normal and broken.
	 * This constructor is normally used by destroyable objects.
	 *
	 * @param normalStateImgPath path to the sprite for the normal/default state
	 * @param brokenStateImgPath path to the sprite used when the tile is broken
	 */
	public Tile (final String normalStateImgPath, final String brokenStateImgPath) {
		this.normalStateSprite  = new ImageIcon(normalStateImgPath).getImage();
		this.brokenStateSprite  = new ImageIcon(brokenStateImgPath).getImage();
	}

	/**
	 * Retrieves the sprite representing the tile in its untouched/normal form.
	 *
	 * @return image for the normal state of the tile
	 */
	public Image getNormalStateSprite () {
		return this.normalStateSprite;
	}

	/**
	 * Retrieves the sprite representing the tile in its broken state.
	 * If the tile is not destroyable, this method simply returns the normal sprite.
	 *
	 * @return image for the tile's broken appearance (or normal sprite if not destroyable)
	 */
	public Image getBrokenStateSprite () {
		if (!this.canBeDestroyed()) {
			return this.normalStateSprite;
		}
		return this.brokenStateSprite;
	}

	/**
	 * Determines whether this tile type can be destroyed during gameplay.
	 * Subclasses override this to define their specific behavior.
	 *
	 * @return true if the tile can be destroyed, false otherwise
	 */
	public abstract boolean canBeDestroyed ();
}

/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * This class defines all the absolute or relative paths
 * to the project's graphical and typographical assets.
 *
 * Centralizing asset paths in a single class prevents inconsistencies,
 * duplication, and the classic “string scattered everywhere” problem.
 *
 * Asset categories include:
 *   - GIF animations (home screen, general ambience)
 *   - Custom TrueType fonts used by the GUI
 *   - Sprites for map tiles such as delimiters and blocks
 *   - etc
 *
 * Whenever assets are reorganized or renamed, this is the class
 * to update—no need to hunt through unrelated code.
 *
 * @author juad - 2025
 */
package presentation.constants;

public class Paths {
	public static final String GIF_HOME = "assets/gifs/home.gif";
	public static final String GIF_GENERAL = "assets/gifs/snow.gif";
	
	public static final String GUI_FONT = "assets/gui-font.ttf";
	
	public static final String SPRITE_NONE = "";
	public static final String SPRITE_SNOW_FRONT = "assets/tiles/floor/snow-front.png";
	public static final String SPRITE_SMALL_SNOW_HEAP_FRONT = "assets/tiles/floor/small-snow-heap-front.png";
	public static final String SPRITE_BIG_SNOW_HEAP_FRONT = "assets/tiles/floor/big-snow-heap-front.png";

	public static final String SPRITE_ICE_FRONT = "assets/tiles/ice/front.png";
	public static final String SPRITE_ICE_BROKEN = "assets/tiles/ice/broken.png";

	public static final String SPRITE_BASIC_DELIMITER_FRONT = "assets/tiles/delimiters/basic-front.png";
	
	public static final String SPRITE_CHAR_VANILLA_FRONT = "assets/characters/vanilla/front.png";
	public static final String SPRITE_CHAR_VANILLA_BACK = "assets/characters/vanilla/back.png";
	public static final String SPRITE_CHAR_VANILLA_LEFT = "assets/characters/vanilla/left.png";
	public static final String SPRITE_CHAR_VANILLA_RIGHT = "assets/characters/vanilla/right.png";

	public static final String SPRITE_CHAR_CHOCOLATE_FRONT = "assets/characters/chocolate/front.png";
	public static final String SPRITE_CHAR_CHOCOLATE_BACK = "assets/characters/chocolate/back.png";
	public static final String SPRITE_CHAR_CHOCOLATE_LEFT = "assets/characters/chocolate/left.png";
	public static final String SPRITE_CHAR_CHOCOLATE_RIGHT = "assets/characters/chocolate/right.png";

	public static final String SPRITE_CHAR_STRAWBERRY_FRONT = "assets/characters/strawberry/front.png";
	public static final String SPRITE_CHAR_STRAWBERRY_BACK = "assets/characters/strawberry/back.png";
	public static final String SPRITE_CHAR_STRAWBERRY_LEFT = "assets/characters/strawberry/left.png";
	public static final String SPRITE_CHAR_STRAWBERRY_RIGHT = "assets/characters/strawberry/right.png";
	
	public static final String SPRITE_CHAR_TROLL_FRONT = "assets/characters/troll.png";
	public static final String SPRITE_CHAR_TROLL_BACK = "assets/characters/back.png";
	public static final String SPRITE_CHAR_TROLL_LEFT = "assets/characters/left.png";
	public static final String SPRITE_CHAR_TROLL_RIGHT = "assets/characters/right.png";

	/* TODO: fix this whenever we get there */
	public static final String HDU_FONT = GUI_FONT;
}

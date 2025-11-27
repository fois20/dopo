/**
 * This class is implemented in order to have a quick and easy way to access
 * the path of different assets used in the project so whenever they change
 * their locations i will only need to modify these values (i didnt use a single comma)
 * 
 * @author juand
 */
package assets;

import presentation.Character;

public class Routes
{
	/**
	 * Constant stuff: no variantios, just what they are
	 */
	public static final String CONSTANT_FONT      = "assets/constant/font.ttf";
	public static final String CONSTANT_HOME_GIF  = "assets/constant/home-animation.gif";
	public static final String CONSTANT_PANEL_GIF = "assets/constant/snow-falling.gif";
	
	/**
	 * Ice blocks: ice blocks and all of its animations
	 */
	public static final String ICEBLOCK_SOLID = "assets/ice-blocks/solid.png";

	/**
	 * Delimiters: All three maps have different delimiters
	 */
	public static final String DELIMITER_A = "assets/delimiters/del-A.png";

	/**
	 * Floor variations: Differ from the tipical snow representation {@link BadColors#GAME_SNOW)
	 */
	public static final String FLOOR_VAR_SNOW_HEAP = "assets/floor-vars/snow-heap.png";
	
	public static final String VANILLA_PATH    = "assets/characters/vanilla/";
	public static final String CHOCOLAYT_PATH  = "assets/characters/chocolate/";
	public static final String STRAWBERRY_PATH = "assets/characters/strawberry/";	
	
	public static final String FRONT = "front.png";
	public static final String BACK  = "back.png";
	public static final String LEFT  = "left.png";
	public static final String RIGHT = "right.png";
	
	public static String getPathFor (final String character)
	{
		switch (character)
		{
			case Character.VANILLA: { return VANILLA_PATH; }
			case Character.CHOCOLATE: { return CHOCOLAYT_PATH; }
			case Character.STRAWBERRRY: { return STRAWBERRY_PATH; }
		}
		
		// TODO: throw a prohrammer expcetion
		return null;
	}
}

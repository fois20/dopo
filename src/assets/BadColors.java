/**
 * This class is implemented in order to have an easy and quick access
 * to different colors used throughtout the project, i mean there are not
 * a lot but it helps whenever i want to change smth
 * 
 * @author juand
 */
package assets;

import java.awt.Color;

public class BadColors
{
	/**
	 * All colors related to the gui are defined here
	 */
	public static final Color PANEL_BACKGROUND;
	public static final Color PANEL_BORDERS;

	/**
	 * All colors related to the game are defined here
	 */
	public static final Color GAME_PINK;
	public static final Color GAME_BEIGE;
	public static final Color GAME_BROWN;
	public static final Color GAME_SNOW;
	public static final Color GAME_SCORE_FOREGROUND;

	static
	{
		PANEL_BACKGROUND  = new Color(248, 242, 226);
		PANEL_BORDERS = new Color(166, 119, 17);
		GAME_PINK  = new Color(254, 199, 197);
		GAME_BEIGE = PANEL_BACKGROUND;
		GAME_BROWN = new Color(200, 164, 98);
		GAME_SNOW   = new Color(246, 254, 254);
		GAME_SCORE_FOREGROUND  = new Color(247, 221, 85);
	}

	private BadColors () {}
}

/* This class is implemented in order to have an easy and quick access
 * to different colors used throughtout the project, i mean there are not
 * a lot but it helps whenever i want to change smth
 * 
 * @author juan diego patino munoz
 */
package presentation;

import java.awt.Color;

public class BadColors
{
	public static final Color BACKGROUND;
	public static final Color BORDER;
	public static final Color PINK_CREAM;
	public static final Color BEIGE_CREAM;
	public static final Color BROWN_CREAM;
	public static final Color GAME_SNOW;
	public static final Color GAME_SCORE;
	
	static
	{
		BACKGROUND = new Color(248, 242, 226);
		BORDER = new Color(166, 119, 17);
		PINK_CREAM = new Color(254, 199, 197);
		BEIGE_CREAM  = BACKGROUND;
		BROWN_CREAM = new Color(200, 164, 98);
		GAME_SNOW = new Color(246, 254, 254);
		GAME_SCORE = new Color(247, 221, 85);
	}
	
	private BadColors () {}
}

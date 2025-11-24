/**                       
 * <pre>
 *                        .|
 *                        | |       Arch class :)
 *                        |'|            ._____
 *                ___    |  |            |.   |' .---"|
 *        _    .-'   '-. |  |     .--'|  ||   | _|    |
 *     .-'|  _.|  |    ||   '-__  |   |  |    ||      |
 *     |' | |.    |    ||       | |   |  |    ||      |
 *  ___|  '-'     '    ""       '-'   '-.'    '`      |____
 * jgs~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * </pre>
 *
 * This class is the level architecter, the one which creates the struct of each
 * level by assigning matrices, values and paths, please give ur respect
 *
 * @author juand
 */
package presentation;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class LevelArch
{
	public static final int LEVEL_1 = 0;
	public static final int LEVEL_2 = 1;
	public static final int LEVEL_3 = 2;

	public static LevelArch getMap (final int no)
	{
		switch (no)
		{
			case LEVEL_1: return map1();
			case LEVEL_2: return map2();
			case LEVEL_3: return map3();
		}
		return noMap();
	}

	private static LevelArch map1  ()
	{
		final int [][] map = {
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
				{4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4},
				{4, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 1, 4},
				{4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4},
				{4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4},
				{4, 1, 0, 0, 1, 1, 1, 2, 0, 1, 1, 1, 0, 0, 1, 4},
				{4, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 4},
				{4, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 4},
				{4, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 2, 1, 4},
				{4, 1, 0, 0, 1, 0, 0, 2, 0, 0, 0, 1, 0, 0, 1, 4},
				{4, 1, 0, 2, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 4},
				{4, 1, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 1, 4},
				{4, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1, 4},
				{4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 4},
				{4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4},
				{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			};

		return new LevelArch(map, Assets.DELIMITER_LEVEL_1, Assets.SNOW_HEAP, 120);
	}

	private static LevelArch map2 ()
	{
		return null;
	}

	private static LevelArch map3 ()
	{
		return null;
	}

	private static LevelArch noMap ()
	{
		return null;
	}

	private Image delimiter;
	private Image iceBlock;
	private Image variation;
	private Color snowColor;

	private int [][] map;
	private int      givenTime;

	/**
	 * Creates the architecture by using the blueprints defined above
	 *
	 * @param map map information {@link MapMeaning.java}
	 * @param del path to the image which will represent the delimiter for this map
	 * @param var path to the image which will represent the variation floor for this map
	 * @param time time given for this level
	 */
	public LevelArch (final int [][] map, final String del, final String var, final int time)
	{
		this.map = map;
		this.delimiter = new ImageIcon(del).getImage();
		this.variation = new ImageIcon(var).getImage();

		this.iceBlock = new ImageIcon(Assets.ICE_BLOCK).getImage();
		this.snowColor = BadColors.GAME_SNOW;

		this.givenTime = time;
	}

	public int [][] getMap () { return this.map; }
	public Image getDelimiter () { return this.delimiter; }
	public Image getFloor () { return this.iceBlock; }
	public Image getVariant () { return this.variation; }
	public Color getSnowColor () { return this.snowColor; }
	public int getTime () { return this.givenTime; }
}

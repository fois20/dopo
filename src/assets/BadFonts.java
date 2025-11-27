/**
 * Since my project does not have all of the sprites from the original project
 * i need to improvise, so i use hovering to let the user to know they're over
 * a button, i need fonts as well ymwim?
 * 
 * @author juand
 */
package assets;

import java.awt.Font;
import java.io.File;

public class BadFonts
{
	public static final Font TINY;
	public static final Font SMALL;
	public static final Font MEDIUM;
	public static final Font BIG;
	public static final Font HDU;

	static
	{
		Font base = new Font("Arial", Font.BOLD, 20);
		try
		{
			base = Font.createFont(Font.TRUETYPE_FONT, new File(Routes.CONSTANT_FONT));
		} catch (final Exception e) {}

		TINY     = base.deriveFont(10f);
		SMALL       = base.deriveFont(15f);
		MEDIUM = SMALL.deriveFont(Font.BOLD).deriveFont(19.5f);
		BIG       = base.deriveFont(25f);
		HDU   = base.deriveFont(Font.BOLD).deriveFont(35f);
	}	

	private BadFonts () {}
}

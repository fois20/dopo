/**
 * Since my project does not have all of the sprites from the original project
 * i need to improvise, so i use hovering to let the user to know they're over
 * a button, i need fonts as well ymwim?
 * 
 * @author juan diego patino munoz
 */
package assets;

import java.awt.Font;
import java.io.File;

public class BadFonts
{
	public static final Font SMALL;
	public static final Font MID;
	public static final Font MID_HOVER;
	public static final Font BIG;
	public static final Font IN_GAME;

	static
	{
		Font base = new Font("Arial", Font.BOLD, 20);
		try
		{
			base = Font.createFont(Font.TRUETYPE_FONT, new File(Routes.CONSTANT_FONT));
		} catch (final Exception e) {}

		SMALL     = base.deriveFont(10f);
		MID       = base.deriveFont(15f);
		MID_HOVER = MID.deriveFont(Font.BOLD).deriveFont(19.5f);
		BIG       = base.deriveFont(25f);
		IN_GAME   = base.deriveFont(Font.BOLD).deriveFont(35f);
	}	

	private BadFonts () {}
}

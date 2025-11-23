package presentation;

import java.awt.Font;
import java.io.File;

public class BadFonts
{
	public static final Font BIG;

	public static final Font MID;
	public static final Font MID_HOVER;
	
	public static final Font SMALL;
	
	static
	{
		Font base = new Font("Arial", Font.BOLD, 20);
		try
		{
			base = Font.createFont(Font.TRUETYPE_FONT, new File(Assets.FONT));
		} catch (final Exception e) {}
		
		BIG = base.deriveFont(25f);

		MID = base.deriveFont(15f);
		MID_HOVER = MID.deriveFont(Font.BOLD).deriveFont(19.5f);

		SMALL = base.deriveFont(10f);
	}	
	
	private BadFonts () {}
}

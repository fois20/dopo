package presentation;

import java.awt.Font;
import java.io.File;

public class BadFont
{
	public static final Font BIG_BUTTON;

	public static final Font MID_BUTTON;
	public static final Font MID_BUTTON_ON_HOVER;
	
	static
	{
		Font base = new Font("Arial", Font.BOLD, 20);
		try
		{
			base = Font.createFont(Font.TRUETYPE_FONT, new File("assets/font.ttf"));
		} catch (final Exception e) {}
		
		BIG_BUTTON = base.deriveFont(25f);

		MID_BUTTON = base.deriveFont(15f);
		MID_BUTTON_ON_HOVER = MID_BUTTON.deriveFont(Font.BOLD).deriveFont(19.5f);
	}	
	
	private BadFont () {}
}

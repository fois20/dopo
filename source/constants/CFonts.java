/**    _
 *   ,' `,.			Creates the {@link Font} object that will be used throughtout the project
 *   >-.(__)		and its different variations
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * @author juad - 2025
 */
package constants;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import exceptions.ProgrammerException;

public class CFonts
{
	public static Font TINY;
	public static Font SMALL;
	public static Font MEDIUM;
	public static Font BIG;
	public static Font HDU;
	
	public static void initFonts () throws ProgrammerException
	{
		Font base = new Font("Arial", Font.BOLD, 20);
		try
		{
			base = Font.createFont(Font.TRUETYPE_FONT, new File(CPaths.FONT));
		} catch (final FontFormatException | IOException e)
		{
			throw new ProgrammerException(ProgrammerException.loadingResource("fonts"));
		}
		
		TINY = base.deriveFont(10f);
		SMALL = base.deriveFont(15f);
		MEDIUM = base.deriveFont(Font.BOLD).deriveFont(19.5f);
		BIG = base.deriveFont(25f);
		HDU = base.deriveFont(Font.BOLD).deriveFont(35f);	
	}	
}

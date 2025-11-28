/**    _
 *   ,' `,.			This class defines components that are too repetitive in the visual
 *   >-.(__)		part so it's possible to create a method which deefines all compoenents
 *  (_,-' |			and returns it
 *    `.  |
 *      `.| hjw
 *        `
 *
 * @author juad - 2025
 */

package presentation;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import constants.CColors;

public class Generics
{
	/** Creates a golden panel (basically the only panel style used in the project)
	 * 
	 * @param borderThickness thickness of the border (see @link constants.COthers)}
	 * @return panel avec le style
	 */
	public static JPanel goldenPanel (final int borderThickness)
	{
		final JPanel panel = new JPanel();
		panel.setBackground(CColors.PANEL_BACKGROUND);
		panel.setBorder(BorderFactory.createLineBorder(CColors.PANEL_BORDER, borderThickness));
		return panel;
	}
	
	/** Creates a golden button (basically the most exploted button in the project)
	 * 
	 * @param msg button's title
	 * @param font font to be used (see {@link constants.CFonts})
	 * @param borderThickness border's thickness (see {@link constants.COthers})
	 * @return the button, what else?
	 */
	public static JButton goldenButton (final String msg, final Font font, final int borderThickness)
	{
		final JButton button = new JButton(msg);
		button.setName(msg);
		button.setFont(font);
		button.setBackground(CColors.PANEL_BACKGROUND);
		button.setBorder(BorderFactory.createLineBorder(CColors.PANEL_BORDER, borderThickness));
		button.setFocusPainted(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return button;
	}
	
	/** This does not create anything but add a tipical style to buttons
	 * 
	 * @param button button which is gonna be stylized
	 * @param before font if no hover
	 * @param after font on hover
	 */
	public static void addStyleToButtonHoverIncreaseFontSize (final JButton button, final Font before, final Font after)
	{
		button.addMouseListener(new MouseAdapter() {
			@Override public void mouseEntered (final MouseEvent e) { button.setFont(after); }
			@Override public void mouseExited (final MouseEvent e) { button.setFont(before); }
		});
	}
}
/* This class implements generic components or at least stuff that is repetitive
 * and boring to do over and over again
 * 
 * @author juan diego patino munoz
 */
package presentation;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Generics
{
	public static JPanel createGoldPanel (final int thickness)
	{
		final JPanel panel = new JPanel();
		panel.setBackground(BadColors.BACKGROUND);
		panel.setBorder(BorderFactory.createLineBorder(BadColors.BORDER, thickness));
		return panel;
	}
	
	public static JButton createButton (final String message, final Font font, final int thickness)
	{
		final JButton button = new JButton(message);
		button.setName(message);
		button.setFont(font);
		button.setBackground(BadColors.BACKGROUND);
		button.setBorder(BorderFactory.createLineBorder(BadColors.BORDER, thickness));
		button.setFocusPainted(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		return button;
	}
	
	public static void addHoverEffectOnButton (final JButton button, final Font before, final Font after)
	{
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered (final MouseEvent e) { button.setFont(after); }

			@Override
			public void mouseExited (final MouseEvent e) { button.setFont(before); }
		});
	}
}

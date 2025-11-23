/* Implements the view which shows the user the available munimodes and the option
 * to go back to the main view (HomeView.java)
 * 
 * @author juan diego patino munoz
 */
package presentation;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectModeView extends BiPanel
{
	public SelectModeView (final Nav nav)
	{
		super(nav);
	}

	@Override
	protected void setUpInformationalContainer()
	{
		this.info = Generics.createGoldPanel(4);
		this.info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		
		final JLabel title = new JLabel("PICK A MODE!");
		title.setFont(BadFonts.BIG);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		final JPanel modes = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
		modes.setOpaque(false);
		this.setUpButtons(modes);
		
		this.info.add(Box.createVerticalStrut(15));
		this.info.add(title);
		this.info.add(Box.createVerticalStrut(15));
		this.info.add(modes);
		this.info.add(Box.createVerticalStrut(15));
	}

	@Override
	protected void indicateBackAction ()
	{
		this.backBtn.addActionListener(e -> {
			this.nav.setView(ViewId.HOME);
		});
	}

	private void setUpButtons (final JPanel panel)
	{
		final ButtonInfo [] info = {
			new ButtonInfo("P vs M", ViewId.PICK_FLAVOUR, 0),
			new ButtonInfo("P vs P", null, 1),
			new ButtonInfo("M vs M", null, 2)
		};
		
		final Dimension size = new Dimension(150, 60);
		
		for (int i = 0; i < info.length; i++)
		{	
			final JButton button = Generics.createButton(info[i].getName(), BadFonts.MID, 1);
			Generics.addHoverEffectOnButton(button, BadFonts.MID, BadFonts.MID_HOVER);
			button.setPreferredSize(size);
			button.setMaximumSize(size);
			button.setMinimumSize(size);
			
			final int nthOpt = info[i].getPosition();
			button.addActionListener(e -> {
				final String view = info[nthOpt].getViewId();
				if (view == null)
				{
					this.nav.unimplementedSorry(button.getName());
					return;
				}
				
				this.nav.setView(view);
			});
			panel.add(button);
		}
	}
}
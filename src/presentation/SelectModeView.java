/**
 * Implements the view which shows the user the available munimodes and the option
 * to go back to the main view
 * 
 * @author juand
 */
package presentation;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import assets.BadFonts;
import domain.BadIceCreamException;

public class SelectModeView extends BiPanel
{
	private static final String TITLE = "PICK A MODE!";

	private Nav nav;

	public SelectModeView (final Nav nav)
	{
		super();
		this.nav = nav;
	}

	@Override
	protected void setUpInformationalContainer()
	{
		this.info = Generics.createGoldPanel(Constants.MED_BORDER_THICKNESS);
		this.info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

		final JLabel title = new JLabel(TITLE);
		title.setFont(BadFonts.BIG);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);

		final JPanel modes = new JPanel(new FlowLayout(FlowLayout.CENTER, Constants.MED_PADDING, Constants.MED_PADDING));
		modes.setOpaque(false);
		this.setUpButtons(modes);

		this.info.add(Box.createVerticalStrut(Constants.MED_VERTICAL_GAP));
		this.info.add(title);
		this.info.add(Box.createVerticalStrut(Constants.MED_VERTICAL_GAP));
		this.info.add(modes);
		this.info.add(Box.createVerticalStrut(Constants.MED_VERTICAL_GAP));
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
			final JButton button = Generics.createButton(info[i].getName(), BadFonts.SMALL, 1);
			Generics.addHoverEffectOnButton(button, BadFonts.SMALL, BadFonts.MEDIUM);
			button.setPreferredSize(size);
			button.setMaximumSize(size);
			button.setMinimumSize(size);

			final int nthOpt = info[i].getPosition();
			button.addActionListener(e -> {
				try
				{
					final String view = info[nthOpt].getViewId();
					if (view == null)
					{
						throw new BadIceCreamException(BadIceCreamException.ACTION_NO_IMPLEMENTED);
					}
					this.nav.setView(view);
				} catch (final BadIceCreamException ex) { this.nav.error(ex.getMessage()); }
			});
			panel.add(button);
		}
	}
}

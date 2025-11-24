/**
 * Implements the pick a fkng flavour view, it can either show one or two panels
 * depending on the number of players (the number of player is chosen in {@link SelectModeView.java}
 * 
 * @author juand
 */
package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PickFlavourView extends BiPanel
{
	private static final String TITLE = "PICK UR FLAVOUR!";

	private Nav nav;
	
	public PickFlavourView (final Nav nav)
	{
		super();
		this.nav = nav;
	}

	@Override
	protected void setUpInformationalContainer()
	{
		this.info = Generics.createGoldPanel(4);
		this.info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		
		final JLabel title = new JLabel(TITLE);
		title.setFont(BadFonts.BIG);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		this.info.add(Box.createVerticalStrut(15));
		this.info.add(title);
		this.info.add(Box.createVerticalStrut(15));
		
		final JPanel flavs = new JPanel(new FlowLayout(FlowLayout.CENTER, Constants.MED_PADDING, Constants.MED_PADDING));
		flavs.setOpaque(false);
		
		this.showButtons(flavs);
		this.info.add(flavs);
		this.info.add(Box.createVerticalStrut(Constants.MED_VERTICAL_GAP));
	}

	@Override
	protected void indicateBackAction()
	{
		this.backBtn.addActionListener(e -> {
			this.nav.setView(ViewId.SELECT_MODE);
		});
	}
	
	private void showButtons (final JPanel panel)
	{
		final Color [] colors = {
			BadColors.BROWN_CREAM,
			BadColors.BEIGE_CREAM,
			BadColors.PINK_CREAM,
		};
		
		final String [] shortNames = { "C", "V", "S" };
		
		final ButtonInfo[] info = {
			new ButtonInfo(Character.CHOCOLATE, ViewId.SELECT_LEVEL, 0),
			new ButtonInfo(Character.VANILLA, ViewId.SELECT_LEVEL, 1),
			new ButtonInfo(Character.STRAWBERRRY, ViewId.SELECT_LEVEL, 2)
		};
		
		for (int i = 0; i < 3; i++)
		{	
			final JButton button = Generics.createButton(info[i].getName(), BadFonts.MID, Constants.MED_BORDER_THICKNESS);
			
			final int nthOpt = info[i].getPosition();
			button.addMouseListener(new MouseAdapter () {
				@Override
				public void mouseEntered (final MouseEvent e)
				{
					button.setFont(BadFonts.BIG);
					button.setText(shortNames[nthOpt]);
				}

				@Override
				public void mouseExited (final MouseEvent e)
				{
					button.setFont(BadFonts.MID);
					button.setText(info[nthOpt].getName());
				}
			});
			
			button.addActionListener(e -> {
				this.nav.setView(info[nthOpt].getViewId());
				this.nav.setFlavourP1(info[nthOpt].getName());
			});
			
			button.setPreferredSize(new Dimension(120, 90));
			button.setBackground(colors[i]);
			
			panel.add(button);
		}
	}
}

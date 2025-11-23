/* Implements the pick a fkng flavour view, it can either show one or two panels
 * depending on the number of players (the number of player is chosen en SelectModeView.java)
 * 
 * @author juan diego patino munoz
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
	private JButton lastPicked;
	
	public PickFlavourView (final Nav nav)
	{
		super(nav);
		this.lastPicked = null;
	}

	@Override
	protected void setUpInformationalContainer()
	{
		this.info = Generics.createGoldPanel(4);
		this.info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		
		final JLabel title = new JLabel("PICK UR FLAVOUR!");
		title.setFont(BadFonts.BIG);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		this.info.add(Box.createVerticalStrut(15));
		this.info.add(title);
		this.info.add(Box.createVerticalStrut(15));
		
		final JPanel flavs = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
		flavs.setOpaque(false);
		
		this.showButtons(flavs);
		this.info.add(flavs);
		this.info.add(Box.createVerticalStrut(15));
	}

	@Override
	protected void indicateBackAction()
	{
		this.backBtn.addActionListener(e -> {
			this.nav.setView(ViewId.HOME);
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
			new ButtonInfo("Chocolate", null, 0),
			new ButtonInfo("Vanilla", null, 1),
			new ButtonInfo("Strawberry", null, 2)
		};
		
		for (int i = 0; i < 3; i++)
		{	
			final JButton button = Generics.createButton(info[i].getName(), BadFonts.MID, 2);
			
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
			
			button.setPreferredSize(new Dimension(120, 90));
			button.setBackground(colors[i]);
			
			panel.add(button);
		}
	}
}

/*
public class PickFlavourView extends BiPanel
{
	public static boolean SINGLE_PLAYER = true;
	
	public PickFlavourView (final Nav nav)
	{
		super(nav);
	}

	@Override
	protected void setUpInformationalContainer()
	{
		this.info = Generics.createGoldPanel(4);
		this.info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		
		final JLabel title = new JLabel("PICK UR FLAVOUR!");
		title.setFont(BadFonts.BIG);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		this.info.add(Box.createVerticalStrut(15));
		this.info.add(title);
		this.info.add(Box.createVerticalStrut(15));
		
		for (int i = 0; i < (SINGLE_PLAYER ? 1 : 2); i++)
		{
			final JPanel flavs = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
			flavs.setOpaque(false);
			
			final JLabel subtitle = new JLabel(String.format("flavour for player %d:", i + 1));
			subtitle.setFont(BadFonts.MID);
			subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);	
			
			flavs.add(Box.createVerticalStrut(15));
			flavs.add(subtitle);
			flavs.add(Box.createVerticalStrut(15));
			
			this.showButtons(flavs);
			
			this.info.add(flavs);
			this.info.add(Box.createVerticalStrut(15));
			
			System.out.println("hi");
		}
	}

	@Override
	protected void indicateBackAction()
	{
		this.backBtn.addActionListener(e -> {
			SINGLE_PLAYER = true;
			this.nav.setView(ViewId.HOME);
		});
	}
	
	private void showButtons (final JPanel panel)
	{
		final Color [] colors = {
			BadColors.BROWN_CREAM,
			BadColors.BEIGE_CREAM,
			BadColors.PINK_CREAM,
		};
		
		for (int i = 0; i < 3; i++)
		{	
			final JButton flav = Generics.createButton("", BadFonts.BIG, 2);
			
			final JPanel placeholder = new JPanel();
			placeholder.setPreferredSize(new Dimension(80, 80));
			placeholder.setBackground(colors[i]);
			
			flav.add(placeholder);
			panel.add(flav);
		}
	}
}*/
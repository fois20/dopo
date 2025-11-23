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

public class SelectModeView extends AnimatedBackgroundPanel
{
	private JPanel mainContainer;
	private JPanel selectionBox;
	private JPanel backBox;
	
	public SelectModeView (final BadIceCreamGUI main)
	{
		super(Assets.SNOW_ANIMATION);
		this.setLayout(new GridBagLayout());
		this.setUpMainContainer(main);
		this.add(this.mainContainer);
	}
	
	private void setUpMainContainer (final BadIceCreamGUI main)
	{
		this.mainContainer = new JPanel();
		this.mainContainer.setLayout(new BoxLayout(this.mainContainer, BoxLayout.Y_AXIS));
		this.mainContainer.setOpaque(false);
		
		this.setUpModesContainer(main);
		this.setUpBackContainer(main);
		
		this.mainContainer.add(this.selectionBox);
        this.mainContainer.add(Box.createVerticalStrut(15));
		this.mainContainer.add(this.backBox);
	}
	
	private void setUpModesContainer (final BadIceCreamGUI main)
	{
		this.selectionBox = Generics.createGoldPanel(4);
		this.selectionBox.setLayout(new BoxLayout(selectionBox, BoxLayout.Y_AXIS));
		
		final JLabel title = new JLabel("PICK A MODE!");
		title.setFont(BadFonts.BIG);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		final JPanel playersContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
		playersContainer.setOpaque(false);
		this.setUpButtons(playersContainer, main);
		
		this.selectionBox.add(Box.createVerticalStrut(15));
		this.selectionBox.add(title);
		this.selectionBox.add(Box.createVerticalStrut(15));
		this.selectionBox.add(playersContainer);
		this.selectionBox.add(Box.createVerticalStrut(15));
	}
	
	private void setUpBackContainer (final BadIceCreamGUI main)
	{
		this.backBox = Generics.createGoldPanel(4);
		this.backBox.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		final JButton goBack = Generics.createButton("BACK", BadFonts.MID, 0);
		goBack.addActionListener(e -> {
			main.setView(ViewId.HOME);
		});
		this.backBox.add(goBack);
	}
	
	private void setUpButtons (final JPanel panel, final BadIceCreamGUI main)
	{
		final ButtonInfo [] info = {
			new ButtonInfo("P vs M", ViewId.PICK_FLAVOUR_1, 0),
			new ButtonInfo("P vs M", null, 1),
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
					main.unimplementedSorry(button.getName());
					return;
				}
				
				main.setView(view);
			});
			panel.add(button);
		}
	}
}

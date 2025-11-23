package presentation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectLevelView extends MonoPanel
{
	private static final String TITLE = "SELECT LEVEL";
	private static final int LEVEL_ROWS = 8;
	private static final int LEVEL_COLS = 5;
	private static final int BUTTON_DIMENSION = 50;

	// TODO: define this in another file
	public static final int NO_LEVELS =  40;
	
	private Nav nav;

	public SelectLevelView (final Nav nav)
	{
		super(TITLE);
		this.nav = nav;
	}

	@Override
	protected void setUpInformationalContainer()
	{
		this.info = Generics.createGoldPanel(Constants.NO_BORDER_THICKNESS);
		this.info.setLayout(new FlowLayout(FlowLayout.CENTER, Constants.TINY_PADDING, Constants.TINY_PADDING));
		
		final JPanel inner = Generics.createGoldPanel(Constants.NO_BORDER_THICKNESS);
		inner.setLayout(new GridLayout(LEVEL_ROWS, LEVEL_COLS, Constants.TINY_PADDING, Constants.TINY_PADDING));
		
		for (int i = 0; i < NO_LEVELS; i++)
		{
			final JButton button = Generics.createButton(
				Integer.toString(i + 1),
				BadFonts.MID,
				Constants.TINY_BORDER_THICKNESS
			);

			Generics.addHoverEffectOnButton(button, BadFonts.MID, BadFonts.MID_HOVER);
			button.setPreferredSize(new Dimension(BUTTON_DIMENSION, BUTTON_DIMENSION));
			
			button.setEnabled(false);
			inner.add(button);
		}
		this.info.add(inner);
	}

	@Override
	protected void indicateBackAction()
	{
		this.backBtn.addActionListener(e -> {
			this.nav.setView(ViewId.PICK_FLAVOUR);
		});
	}
}

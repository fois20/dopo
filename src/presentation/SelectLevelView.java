package presentation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import domain.LevelAvailableness;

public class SelectLevelView extends MonoPanel
{
	private static final String TITLE = "SELECT LEVEL";
	private static final int LEVEL_ROWS = 8;
	private static final int LEVEL_COLS = 5;
	private static final int BUTTON_DIMENSION = 50;

	public SelectLevelView (final Nav nav)
	{
		super(TITLE, nav);
	}

	@Override
	protected void setUpInformationalContainer()
	{
		this.info = Generics.createGoldPanel(Constants.NO_BORDER_THICKNESS);
		this.info.setLayout(new FlowLayout(FlowLayout.CENTER, Constants.TINY_PADDING, Constants.TINY_PADDING));
		
		final JPanel inner = Generics.createGoldPanel(Constants.NO_BORDER_THICKNESS);
		inner.setLayout(new GridLayout(LEVEL_ROWS, LEVEL_COLS, Constants.TINY_PADDING, Constants.TINY_PADDING));
		
		final boolean [] availableOnes = this.nav.getController().getLevelsAvailableness();

		for (int i = 0; i < LevelAvailableness.NO_LEVELS; i++)
		{
			final JButton button = Generics.createButton(
				Integer.toString(i + 1),
				BadFonts.MID,
				Constants.TINY_BORDER_THICKNESS
			);

			Generics.addHoverEffectOnButton(button, BadFonts.MID_HOVER, BadFonts.BIG);
			button.setPreferredSize(new Dimension(BUTTON_DIMENSION, BUTTON_DIMENSION));
			
			inner.add(button);
			if (!availableOnes[i])
			{
				button.setEnabled(false);
				continue;
			}
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

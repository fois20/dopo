/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 * This view allows the player to select a level before starting
 * the game. It renders a grid of level buttons indicating
 * which levels are available and disabled ones for locked levels.
 *
 * The view extends {@link MonoPanel} and reuses its layout, displaying the
 * informational content (level buttons) and a “go back” button in a single
 * panel. Buttons dynamically load the selected level via the controller.
 *
 * TODO: Enhance navigation by returning to the previous view instead of always going back to home.
 *       
 * @author juad - 2025
 */
package presentation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import domain.LevelAvailableness;
import presentation.constants.Fonts;
import presentation.constants.Paths;
import presentation.constants.Styles;
import presentation.constants.Titles;
import presentation.recycle.Generics;
import presentation.recycle.MonoPanel;

public class SelectLevelView extends MonoPanel {
	private static SelectLevelView INSTANCE = null;
	private static Intermediary INTER;
	
	private static final String WINDOW_TITLE = Titles.SELECT_LEVEL_GAMING;
	private static final String GIF = Paths.GIF_GENERAL;
	
	private static final int LEVEL_ROWS = 8;
	private static final int LEVEL_COLS = 5;
	private static final int BUTTON_DIMENSION = 50;
	
	private SelectLevelView () {
		super(GIF, "PICK A LEVEL!");
	}

	/**
	 * Initializes the information panel with a grid of level buttons.
	 * Disabled buttons indicate unavailable levels, and clicking an
	 * enabled button loads the corresponding level and navigates to
	 * the {@link LevelView}.
	 */
	@Override
	protected void setUpInformationPanel () {
		this.singlePanel = Generics.createGoldenPanel(Styles.BORDER_THICKNESS_NONE);
		this.singlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, Styles.PADDING_TINY, Styles.PADDING_TINY));
		
		final JPanel panel = Generics.createGoldenPanel(Styles.BORDER_THICKNESS_NONE);
		panel.setLayout(new GridLayout(LEVEL_ROWS, LEVEL_COLS, Styles.PADDING_TINY, Styles.PADDING_TINY));
		
		final boolean [] playable = INTER.getController().pleaseProvideListOfAvailableLevels();
		for (int i = 0; i < LevelAvailableness.MAX_LEVELS; i++) {
			final int levelnumber = i;
			final JButton button = Generics.createGoldenButton(
				Integer.toString(levelnumber),
				Fonts.MEDIUM,
				Styles.BORDER_THICKNESS_TINY
			);
			
			Generics.styleIncreaseFontSizeOnHover(button, Fonts.MEDIUM, Fonts.BIG);
			button.setPreferredSize(new Dimension(BUTTON_DIMENSION, BUTTON_DIMENSION));
			panel.add(button);
			
			if (!playable[i]) {
				button.setEnabled(false);
				continue;
			}

			button.addActionListener(e -> {
				INTER.getController().pleaseLoadPredefinedLevel(levelnumber);
				INTER.showThisView(ViewsId.LEVEL);
			});
		}
		this.singlePanel.add(panel);
	}

	/**
	 * Sets the action for the “go back” button. Currently returns to the
	 * {@link HomeView}, but this could be enhanced to return to the
	 * previous view dynamically.
	 */
	@Override protected void setUpGoBackButtonAction () {
		this.backButton.addActionListener(e -> {
			INTER.showThisView(ViewsId.HOME_VIEW);
		});
	}
	
	/**
	 * Returns the singleton instance of this view, setting the window title
	 * and initializing the intermediary reference.
	 *
	 * @param inter   intermediary used to communicate with the main frame
	 * @return        the unique instance of SelectLevelView
	 */
	public static SelectLevelView getInstance (final Intermediary inter) {
		if (INSTANCE == null) {
			INTER = inter;
			INSTANCE = new SelectLevelView();
		}
		INTER.setViewTitle(WINDOW_TITLE);
		return INSTANCE;
	}
}

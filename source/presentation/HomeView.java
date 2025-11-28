/**    _
 *   ,' `,.			
 *   >-.(__)		
 *  (_,-' |			
 *    `.  |
 *      `.| hjw
 *        `
 *
 * @author juad - 2025
 */

package presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.CFonts;
import constants.COthers;
import constants.CPaths;
import constants.CTitles;
import exceptions.UserException;

public class HomeView extends GifPanel
{
	private static final String GIF_PATH = CPaths.GIF_BAD_DOPO_CREAM;
	private static final String TITLE = CTitles.HOME_VIEW;
	
	private static final int MODAL_NUMBER_OF_BUTTONS = 4;
	private static final int MODAL_PANEL_HEIGHT = (int) (BadIceCream.WINDOW_HEIGHT / 3);
	private static final int MODAL_PANEL_WIDTH = (int) (BadIceCream.WINDOW_WIDTH / 2);
	
	private JPanel glass;
	private JPanel modal;
	
	private JButton startbutton; 
	
	public HomeView (final BadIceCream main)
	{
		super(GIF_PATH);
		this.setLayout(null);
		this.initGlass(main);
		this.initStartButton();
		main.setTitle(TITLE);
	}
	
	private void initGlass (final BadIceCream main)
	{
		this.glass = new JPanel(null);
		this.glass.setBackground(new Color(0, 0, 0, 150));
		this.initModal(main);
		
		this.glass.add(this.modal);
		main.setGlassPane(this.glass);
	}
	
	private void initStartButton ()
	{	
		this.startbutton = Generics.goldenButton("CLICK TO LICK", CFonts.BIG, COthers.BORDER_THICKNESS_BIG);
		this.startbutton.setBounds(
			(BadIceCream.WINDOW_WIDTH - 200) / 2,	
			(BadIceCream.WINDOW_HEIGHT - 60) / 2 + (int) ((BadIceCream.WINDOW_HEIGHT - 200) * 0.4),
			200,
			60
		);
		this.startbutton.addActionListener(e -> {
			this.glass.setVisible(true);
		});
		this.add(this.startbutton);
	}
	
	private void initModal (final BadIceCream main)
	{
		this.modal = Generics.goldenPanel(COthers.BORDER_THICKNESS_BIG);
		this.modal.setLayout(new GridLayout(MODAL_NUMBER_OF_BUTTONS, 1));
		this.modal.setBounds(
			(BadIceCream.WINDOW_WIDTH - MODAL_PANEL_WIDTH) / 2,
			MODAL_PANEL_HEIGHT,
			MODAL_PANEL_WIDTH,
			MODAL_PANEL_HEIGHT
		);

		this.initModalButtons(main);
	}	
	
	private void initModalButtons (final BadIceCream main)
	{
		final ButtonInfo [] info = {
			new ButtonInfo("PLAY", null, 0),
			new ButtonInfo("SCORES", null, 1),
			new ButtonInfo("HELP", null, 2),
			new ButtonInfo("CREDITS", null, 3)
		};
		
		for (int i = 0; i < MODAL_NUMBER_OF_BUTTONS; i++)
		{
			final JButton button = Generics.goldenButton(
				info[i].getName(),
				CFonts.SMALL,
				COthers.BORDER_THICKNESS_NONE
			);
			
			final int nthOpt = info[i].getIndex();
			button.addActionListener(e -> {
				try {
					final String jump = info[nthOpt].getJumpTo();
					if (jump == null)
					{
						throw new UserException(UserException.BUTTON_NO_IMPLEMENTED);
					}
					
					this.glass.setVisible(true);
					main.setView(jump);
				} catch (final UserException ex)
				{
					main.userError(ex.getMessage());
				}
			});
			
			Generics.addStyleToButtonHoverIncreaseFontSize(button, button.getFont(), CFonts.MEDIUM);
			this.modal.add(button);
		}
	}
}

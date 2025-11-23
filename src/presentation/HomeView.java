/* Implements the home view and its modal window which provides a serie
 * of buttons to perform different actions (play, scores, help and credits)
 * 
 * @author juan diego patino munoz
 */
package presentation;

import java.awt.Color;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeView extends GifPanel
{
	private static final int MODAL_WIN_HEIGHT = (int) (BadIceCreamGUI.WINDOW_HEIGHT / 3);
	private static final int MODAL_WIN_WIDTH = (int) (BadIceCreamGUI.WINDOW_WIDHT / 2);
	private static final int MODAL_NO_BUTTONS = 4;
	
	private JPanel glass;
	private JPanel modal;
	private JButton startBtn;
	
	public HomeView (final BadIceCreamGUI mwin)
	{
		super(Assets.HOME_ANIMATION);
		this.setLayout(null);
		this.initGlass(mwin);
		this.initStartButton();
	}

	private void initGlass (final BadIceCreamGUI main)
	{
		this.glass =  new JPanel(null);
		this.glass.setBackground(new Color(0, 0, 0, 150));
		this.glass.addMouseListener(new MouseAdapter() {});

		this.initModal(main);

		this.glass.add(this.modal);
		main.setGlassPane(this.glass);
	}
	
	private void initModal (final BadIceCreamGUI main)
	{
		this.modal = Generics.createGoldPanel(6);
		this.modal.setLayout(new GridLayout(MODAL_NO_BUTTONS, 1));
		
		this.modal.setBounds(
			(BadIceCreamGUI.WINDOW_WIDHT - MODAL_WIN_WIDTH) / 2,
			MODAL_WIN_HEIGHT,
			MODAL_WIN_WIDTH,
			MODAL_WIN_HEIGHT
		);

		this.initModalButtons(main);
	}
	
	private void initModalButtons (final BadIceCreamGUI main)
	{
		final ButtonInfo [] info = {
			new ButtonInfo("PLAY", ViewId.SELECT_MODE, 0),
			new ButtonInfo ("SCORES", null, 1),
			new ButtonInfo ("HELP", null, 2),
			new ButtonInfo ("CREDITS", null, 3)
		};
		
		for (int i = 0; i < MODAL_NO_BUTTONS; i++)
		{
			final JButton button = Generics.createButton(info[i].getName(), BadFonts.MID, 0);
			
			Generics.addHoverEffectOnButton(button, BadFonts.MID, BadFonts.MID_HOVER);
			
			final int nthOpt = info[i].getPosition();
			button.addActionListener(e -> {
				final String view = info[nthOpt].getViewId();
				
				if (view == null)
				{
					main.unimplementedSorry(button.getName());
					return;
				}
				
				this.glass.setVisible(false);
				main.setView(view);
			});
			
			button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.modal.add(button);
		}
	}
	
	private void initStartButton ()
	{
		this.startBtn = Generics.createButton("CLICK TO LICK", BadFonts.BIG, 5);

		this.startBtn.setBounds(
			(BadIceCreamGUI.WINDOW_WIDHT - 200) / 2,
			(BadIceCreamGUI.WINDOW_HEIGHT - 60) / 2 + (int) ((BadIceCreamGUI.WINDOW_HEIGHT - 200) * 0.40),
			200,
			60
		);
		
		this.startBtn.addActionListener(e -> this.glass.setVisible(true));
		this.add(this.startBtn);
	}		
}

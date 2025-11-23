package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.File;

enum ModalButtonInfo
{
	PLAY ("PLAY", ViewId.SELECT_MODE, 0),
	SCORES ("SCORES", null, 1),
	HELP ("HELP", null, 2),
	CREDITS ("CREDITS", null, 3);
	
	private String name;
	private String viewId;
	private int position;
	
	ModalButtonInfo (final String name, final String viewId, final int position)
	{
		this.name = name;
		this.viewId = viewId;
		this.position = position;
	}
	
	public String getName () { return this.name; }
	public String getViewId () { return this.viewId; }
	public int getPosition () { return this.position; }
}

public class HomeView extends JPanel
{
	private static final int MODAL_WIN_HEIGHT = (int) (BadIceCreamGUI.WINDOW_HEIGHT / 3);
	private static final int MODAL_WIN_WIDTH = (int) (BadIceCreamGUI.WINDOW_WIDHT / 2);
	
	private static final int MODAL_NO_BUTTONS = 4;
	
	private Image background;
	private JPanel glass;
	private JPanel modal;

	private JButton startBtn;
	private JButton [] buttons;
	
	public HomeView (final BadIceCreamGUI mwin)
	{
		this.setLayout(null);
		this.background = new ImageIcon("assets/home-animation.gif").getImage();	
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
		this.modal = new JPanel();
		this.modal.setLayout(new GridLayout(MODAL_NO_BUTTONS, 1));
		
		this.modal.setBounds(
			(BadIceCreamGUI.WINDOW_WIDHT - MODAL_WIN_WIDTH) / 2,
			MODAL_WIN_HEIGHT,
			MODAL_WIN_WIDTH,
			MODAL_WIN_HEIGHT
		);

		this.modal.setBackground(BadColors.BACKGROUND);
		this.modal.setBorder(BorderFactory.createLineBorder(BadColors.BORDER, 6));
		this.initModalButtons(main);
	}
	
	private void initModalButtons (final BadIceCreamGUI main)
	{
		final ModalButtonInfo [] info = {
			ModalButtonInfo.PLAY,
			ModalButtonInfo.SCORES,
			ModalButtonInfo.HELP,
			ModalButtonInfo.CREDITS
		};
		
		this.buttons = new JButton[MODAL_NO_BUTTONS];
		for (int i = 0; i < MODAL_NO_BUTTONS; i++)
		{
			final JButton button = new JButton(info[i].getName());
			button.setFont(BadFont.MID_BUTTON);
			
			button.setOpaque(false);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			
			this.buttons[i] = button;
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered (final MouseEvent e) { button.setFont(BadFont.MID_BUTTON_ON_HOVER); }

				@Override
				public void mouseExited (final MouseEvent e) { button.setFont(BadFont.MID_BUTTON); }
			});
			
			final int nthOpt = info[i].getPosition();
			this.buttons[i].addActionListener(e -> {
				final String action = info[nthOpt].getViewId();
				
				if (action == null)
				{
					main.unimplementedSorry(button.getName());
					return;
				}
				
				this.glass.setVisible(false);
				main.setView(action);
			});
			
			this.modal.add(button);
		}
	}
	
	private void initStartButton ()
	{
		this.startBtn = new JButton("CLICK TO LICK");
		
		this.startBtn.setFont(BadFont.BIG_BUTTON);
		this.startBtn.setFocusPainted(false);
		this.startBtn.setBackground(new Color(248, 242, 226));
		
		this.startBtn.setBorder(BorderFactory.createLineBorder(BadColors.BORDER, 3));

		this.startBtn.setBounds(
			(BadIceCreamGUI.WINDOW_WIDHT - 200) / 2,
			(BadIceCreamGUI.WINDOW_HEIGHT - 60) / 2 + (int) ((BadIceCreamGUI.WINDOW_HEIGHT - 200) * 0.40),
			200,
			60
		);
		
		this.startBtn.addActionListener(e -> this.glass.setVisible(true));
		this.add(this.startBtn);
	}
		
	@Override
	protected void paintComponent (final Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(this.background, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}

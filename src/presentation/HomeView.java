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

public class HomeView extends JPanel
{
	private static final int MODAL_WIN_HEIGHT = (int) (BadIceCreamGUI.WINDOW_HEIGHT / 3);
	private static final int MODAL_WIN_WIDTH = (int) (BadIceCreamGUI.WINDOW_WIDHT / 2);
	
	private static final int MODAL_NO_BUTTONS = 4;

	private Image background;
	private JPanel glass;
	private JPanel modal;

	private JButton startBtn;
	private JButton [] options;
	
	private JButton playBtn;
	private JButton scoreBtn;
	private JButton helpBtn;
	private JButton creditsBtn;
		
	public HomeView (final BadIceCreamGUI mwin)
	{
		this.setLayout(null);
		this.background = new ImageIcon("assets/home-animation.gif").getImage();	
		this.initGlass(mwin);
		this.initStartButton();
	}

	private void initGlass (final BadIceCreamGUI window)
	{
		this.glass =  new JPanel(null);
		this.glass.setBackground(new Color(0, 0, 0, 150));
		this.glass.addMouseListener(new MouseAdapter() {});

		this.initModal();	

		this.glass.add(this.modal);
		window.setGlassPane(this.glass);
	}
	
	private void initModal ()
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
		this.initModalButtons();
	}
	
	private void initModalButtons ()
	{
	    final String [] titles = {
	        "PLAY",
	        "SCORES",
	        "HELP",
	        "CREDITS"
	    };

	    this.options = new JButton[MODAL_NO_BUTTONS];
	    
	    for (int i = 0; i < MODAL_NO_BUTTONS; i++)
	    {
	        JButton btn = new JButton(titles[i]);
	        btn.setFont(BadFont.MID_BUTTON);

	        btn.setOpaque(false);
	        btn.setContentAreaFilled(false);
	        btn.setBorderPainted(false);
	        btn.setFocusPainted(false);

	        this.options[i] = btn;

	        btn.addMouseListener(new java.awt.event.MouseAdapter() {
	            @Override
	            public void mouseEntered(java.awt.event.MouseEvent e) {
	                btn.setFont(BadFont.MID_BUTTON_ON_HOVER);
	            }

	            @Override
	            public void mouseExited(java.awt.event.MouseEvent e) {
	                btn.setFont(BadFont.MID_BUTTON);
	            }
	        });

	        this.modal.add(btn);
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

package tests;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;

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

	private Image background;
	private JPanel glass;
	private JPanel modal;

	private JButton startBtn;
	private JButton playBtn;
	private JButton helpBtn;
	private JButton creditsBtn;
		
	public HomeView (final BadIceCreamGUI mwin)
	{
		this.setLayout(null);
		this.background = new ImageIcon("assets/home-animation.gif").getImage();	
		this.initGlass(mwin);
		this.initButton();
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
		this.modal.setBackground(new Color(248, 242, 226));
		this.modal.setBounds(0, 0, MODAL_WIN_WIDTH, MODAL_WIN_HEIGHT);
		this.modal.setBorder(BorderFactory.createLineBorder(new Color(166, 119, 17), 3));
	}
	
	private void initButton ()
	{
		this.startBtn = new JButton("CLICK TO LICK");
		Font font = new Font("Arial", Font.BOLD, 20);
		try
		{
			font = Font.createFont(
				Font.TRUETYPE_FONT,
				new File("assets/font.ttf")
			).deriveFont(24f);
		} catch (final Exception e) {}
		
		this.startBtn.setFont(font);
		this.startBtn.setFocusPainted(false);
		this.startBtn.setBackground(new Color(248, 242, 226));
		
		this.startBtn.setBorder(BorderFactory.createLineBorder(new Color(198, 146, 33), 3));

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

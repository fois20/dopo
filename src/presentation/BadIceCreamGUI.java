package presentation;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BadIceCreamGUI extends JFrame
{
	public static int WINDOW_HEIGHT = 800;
	public static int WINDOW_WIDHT = 800;
	
	private CardLayout panelStack;
	private JPanel     panel;
	
	public BadIceCreamGUI ()
	{	
		this.setDefaults();
		this.initObjs();
		
		this.setVisible(true);
		this.panelStack.show(this.panel, ViewId.HOME);
	}
	
	private void setDefaults ()
	{
		this.setSize(WINDOW_HEIGHT, WINDOW_WIDHT);
		this.setTitle("Bad Dopo Cream (An expensive clon of bad ice cream)");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initObjs ()
	{
		this.panelStack = new CardLayout();
		this.panel = new JPanel(this.panelStack);
		
		this.panel.add(new HomeView(this), ViewId.HOME);	
		this.add(this.panel);
	}
	
	public static void main (final String [] args)
	{
		final BadIceCreamGUI gui = new BadIceCreamGUI();
	}
}

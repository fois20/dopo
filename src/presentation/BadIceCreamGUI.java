/* This is the class where all starts, it creates the unique JFrame and all the
 * possible JPanels that will be used throughout the execution of the program
 * 
 * @author juan diego patino munoz
 */
package presentation;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BadIceCreamGUI extends JFrame implements Nav
{
	public static int WINDOW_HEIGHT = 800;
	public static int WINDOW_WIDHT = 800;
	
	private CardLayout panelStack;
	private JPanel panel;
	
	public BadIceCreamGUI ()
	{	
		this.setDefaults();
		this.initObjs();
		
		this.setVisible(true);
		this.setView(ViewId.HOME);
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
		this.panel.add(new SelectModeView(this), ViewId.SELECT_MODE);	
		this.panel.add(new PickFlavourView(this), ViewId.PICK_FLAVOUR);

		this.add(this.panel);
	}
	
	@Override
	public void unimplementedSorry (final String what)
	{
		JOptionPane.showMessageDialog(
			null,
			String.format("Sorry but '%s' is not implemented yet! Muning soon :)", what),
			"Bad way to go :(",
			JOptionPane.ERROR_MESSAGE
		);
	}
	
	@Override
	public void setView (final String viewId)
	{
		this.panelStack.show(this.panel, viewId);
	}
		
	public static void main (final String [] args)
	{
		new BadIceCreamGUI();
	}
}

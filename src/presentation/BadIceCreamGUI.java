/* This is the class where all starts, it creates the unique JFrame and all the
 * possible JPanels that will be used throughout the execution of the program
 * 
 * @author juan diego patino munoz
 */
package presentation;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import domain.Control;

public class BadIceCreamGUI extends JFrame implements Nav
{
	private static final String TITLE = "Bad Dopo Cream - An expensive clon";
	
	public static final int WINDOW_HEIGHT = 758;
	public static final int WINDOW_WIDHT = 735;
	
	private CardLayout panelStack;
	private JPanel panel;
	private Control control;
	
	public BadIceCreamGUI (final Control control)
	{	
		this.setDefaults();
		this.control = control;
		this.initObjs();	
		this.setVisible(true);
		
		this.setView(ViewId.HOME);
	}
	
	private void setDefaults ()
	{
		this.setSize(WINDOW_WIDHT, WINDOW_HEIGHT);
		this.setPreferredSize(new Dimension(WINDOW_WIDHT, WINDOW_HEIGHT));
		this.setTitle(TITLE);
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
		this.panel.add(new SelectLevelView(this), ViewId.SELECT_LEVEL);
		this.panel.add(new LevelView(this, MapBuilder.LEVEL_1), ViewId.LEVEL_ONE);

		this.add(this.panel);
	}
	
	@Override
	public void error (final String errmsg)
	{
		JOptionPane.showMessageDialog(
			null,
			errmsg,
			"Bad way to go :(",
			JOptionPane.ERROR_MESSAGE
		);
	}
	
	@Override
	public void setView (final String viewId)
	{
		this.panelStack.show(this.panel, viewId);
	}

	@Override
	public Control getController ()
	{		
		return this.control;
	}
		
	public static void main (final String [] args)
	{
		final Control controller = new Control();
		new BadIceCreamGUI(controller);
	}	
}

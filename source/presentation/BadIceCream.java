/**    _
 *   ,' `,.			This is the main class where all start, it defines and sets up the unique
 *   >-.(__)		JFrame that will be used throughtout the whole project
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * @author juad - 2025
 */

package presentation;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constants.CFonts;
import constants.CTitles;
import exceptions.ProgrammerException;

public class BadIceCream extends JFrame implements Intermediary
{
	private static final String TITLE = CTitles.WELCOME;
	
	public static final int WINDOW_HEIGHT = 758;
	public static final int WINDOW_WIDTH = 735;
	
	private CardLayout viewStack;
	private JPanel panel;
	private Map<String, JPanel> views;
	
	public BadIceCream ()
	{
		this.initResources();
		this.setDefaultConfigs();
		this.initObjects();
		
		/* XXX: if the {@link presentation.ViewsId#PRELUDE} is implemented chage this
		 * argument
		 */
		this.loadView(ViewsId.HOME);
		this.setVisible(true);
	}
	
	private void initResources ()
	{
		try { CFonts.initFonts(); }
		catch (final ProgrammerException e) { this.programmerError(e.getMessage()); }
	}
	
	private void setDefaultConfigs ()
	{
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TITLE);
	}
	
	private void initObjects ()
	{
		this.viewStack = new CardLayout();
		this.panel = new JPanel(this.viewStack);	
		this.views = new HashMap<String, JPanel>();
		this.add(this.panel);		
	}
	
	/** loadView makes sure no view is loaded twice, this is made for sure to save space
	 * but also not to load views prematurely
	 * 
	 * @param id view's id to be loaded {see @link ViewsId}
	 */
	private void loadView (final String id)
	{
		if (this.views.containsKey(id))
		{
			return;
		}
		
		JPanel view = null;
		switch (id)
		{
			case ViewsId.HOME: { view = new HomeView(this); break; }
		}
		
		if (view != null)
		{
			this.panel.add(view, id);
			this.views.put(id, view);
		}
	}

	/**
	 * Changes the title of the window
	 * 
	 * @param title title message to be set
	 */
	@Override public void changeTitle (final String title)
	{
		this.setTitle(title);
	}

	/**
	 * Shows an JDialog display an error message and its cause
	 * 
	 * @param errormessage error message (see {@link exceptions.UserException})
	 */
	@Override public void userError (final String errormessage)
	{
		/* XXX: It'd be nice to have a personalizated window
		 */
		JOptionPane.showMessageDialog(
			this,
			errormessage,
			"Did your ice cream melt?",
			JOptionPane.ERROR_MESSAGE
		);
	}

	/**
	 * Writes to a log file where programmer(s) can see the errors that
	 * happened during execution
	 * 
	 * @param errormessage error message (see {@link exceptions.ProgrammerException})
	 */
	@Override public void programmerError (final String errormessage)
	{
		System.out.println("ERROR: " + errormessage);
	}

	/**
	 * Displays the panel indicated by the given id
	 * 
	 * @param viewid view's id to be loaded {see @link ViewsId}
	 */
	@Override public void setView (final String viewid)
	{
		this.loadView(viewid);
	}

	public static void main (final String [] args)
	{
		new BadIceCream();
	}	
}

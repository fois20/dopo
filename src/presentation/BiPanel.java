/**
 * This is a custom view which has the feature of having an informational panel
 * where the child class can do whatever they want and the go back panel which
 * only conatins the 'back' button
 * 
 * @author juand
 */
package presentation;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import assets.Routes;
import assets.BadFonts;

public abstract class BiPanel extends GifPanel
{
	protected JPanel  main;
	protected JPanel  info;
	protected JPanel  back;
	protected JButton backBtn;

	public BiPanel ()
	{
		super(Routes.CONSTANT_PANEL_GIF);
		this.setLayout(new GridBagLayout());
		this.setUpMainContainer();
		this.add(this.main);
	}

	private void setUpMainContainer ()
	{
		this.main = new JPanel();
		this.main.setLayout(new BoxLayout(this.main, BoxLayout.Y_AXIS));
		this.main.setOpaque(false);

		this.setUpInformationalContainer();
		this.setUpGoBackContainer();

		this.main.add(this.info);
		this.main.add(Box.createVerticalStrut(Constants.MED_VERTICAL_GAP));
		this.main.add(this.back);
	}

	private void setUpGoBackContainer ()
	{
		this.back = Generics.createGoldPanel(Constants.MED_BORDER_THICKNESS);
		this.back.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.backBtn = Generics.createButton(Constants.GO_BACK_TEXT, BadFonts.MID, Constants.NO_BORDER_THICKNESS);
		this.indicateBackAction();
		this.back.add(this.backBtn);
	}

	/**
	 * This is abstract since the information of each panel may change (i mean it should 'cause
	 * if it does not, what's the point)
	 */
	protected abstract void setUpInformationalContainer ();

	/**
	 * This is abstract since the gobackbutton should go to different places for different
	 * views
	 */
	protected abstract void indicateBackAction ();	
}

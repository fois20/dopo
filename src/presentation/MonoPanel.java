/**
 * This is a custom view which has the feature of having a single panel which
 * contains both views, informational and goback panels
 * 
 * @author juand
 */
package presentation;

import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import assets.Routes;
import assets.BadFonts;

public abstract class MonoPanel extends GifPanel
{
	private JPanel main;

	protected JButton backBtn;
	protected JPanel info;
	protected Nav nav;

	public MonoPanel (final String title, final Nav nav)
	{
		super(Routes.CONSTANT_PANEL_GIF);
		this.nav = nav;
		this.setLayout(new GridBagLayout());
		this.setUpBasics(title);
		this.add(this.main);
	}

	private void setUpBasics (final String msg)
	{
		this.main = Generics.createGoldPanel(4);
		this.main.setLayout(new BoxLayout(this.main, BoxLayout.Y_AXIS));

		final JLabel title = new JLabel(msg);
		title.setFont(BadFonts.BIG);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);	

		this.setUpInformationalContainer();

		this.backBtn = Generics.createButton(Constants.GO_BACK_TEXT, BadFonts.SMALL, Constants.NO_BORDER_THICKNESS);
		this.backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.indicateBackAction();

		this.main.add(Box.createVerticalStrut(Constants.MED_VERTICAL_GAP));
		this.main.add(title);
		this.main.add(Box.createVerticalStrut(Constants.MED_VERTICAL_GAP));
		this.main.add(this.info);
		this.main.add(Box.createVerticalStrut(Constants.MED_VERTICAL_GAP));
		this.main.add(this.backBtn);
		this.main.add(Box.createVerticalStrut(Constants.MED_VERTICAL_GAP));
	}

	/**
	 * this method is abstract since each child will have a different implementation
	 * of the information panel
	 */
	protected abstract void setUpInformationalContainer ();	

	/**
	 * this method is abstract since each child has a different parent panel
	 * so it differs in implementation
	 */
	protected abstract void indicateBackAction ();
}

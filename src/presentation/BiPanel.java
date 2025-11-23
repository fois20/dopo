/* This is a custom view which has the feature of having an informational panel
 * where the child class can u whatever they want and the go back panel which
 * only conatins the 'back' button
 * 
 * @author juan diego patino munoz
 */
package presentation;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class BiPanel extends GifPanel
{
	protected JPanel main;
	protected JPanel info;
	protected JPanel back;
	protected JButton backBtn;
	protected Nav nav;
	
	public BiPanel (final Nav nav)
	{
		super(Assets.SNOW_ANIMATION);
		this.nav = nav;
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
        this.main.add(Box.createVerticalStrut(15));
		this.main.add(this.back);
	}

	private void setUpGoBackContainer ()
	{
		this.back = Generics.createGoldPanel(4);
		this.back.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.backBtn = Generics.createButton("BACK", BadFonts.MID, 0);
		this.indicateBackAction();
		this.back.add(this.backBtn);
	}
	
	protected abstract void setUpInformationalContainer ();
	protected abstract void indicateBackAction ();	
}

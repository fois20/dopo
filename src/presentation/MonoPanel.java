package presentation;

import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class MonoPanel extends GifPanel
{
	private JPanel main;
	
	protected JButton backBtn;
	protected JPanel info;
	protected Nav nav;
	
	public MonoPanel (final String title, final Nav nav)
	{
		super(Assets.SNOW_ANIMATION);
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

		this.backBtn = Generics.createButton(Constants.GO_BACK_TEXT, BadFonts.MID, Constants.NO_BORDER_THICKNESS);
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
	
	protected abstract void setUpInformationalContainer ();	
	protected abstract void indicateBackAction ();
}

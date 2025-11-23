package presentation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AnimatedBackgroundPanel extends JPanel
{
	protected Image background;
	
	public AnimatedBackgroundPanel (final String path)
	{
		this.background = new ImageIcon(path).getImage();
	}
	
	@Override
	protected void paintComponent (final Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(
			this.background,
			0,
			0,
			800,
			800,
			this
		);
	}
}

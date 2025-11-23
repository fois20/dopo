/* This class provides a simple template for other classes to use.
 * The main idea is to implement the background so the children
 * does not have to repeat the same code over and over again
 * 
 * @author juan diego patino munoz
 */
package presentation;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GifPanel extends JPanel
{
	protected Image background;
	
	public GifPanel (final String path)
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

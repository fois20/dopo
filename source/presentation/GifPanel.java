/**    _
 *   ,' `,.			This class is meant to be the parent of other panels that uses
 *   >-.(__)		a gif as background (see {@link HomeView} for example)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * @author juad - 2025
 */

package presentation;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GifPanel extends JPanel
{
	private Image background;
	
	public GifPanel (final String path)
	{
		this.background = new ImageIcon(path).getImage();
	}
	
	@Override protected void paintComponent (final Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(
			this.background,
			0,
			0,
			BadIceCream.WINDOW_WIDTH,
			BadIceCream.WINDOW_HEIGHT,
			this
		);
	}
}

/**    _
 *   ,' `,.			This view is the rendering part, most of the communication
 *   >-.(__)		happens here
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * @author juad - 2025
 */
package presentation;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import presentation.constants.Colors;

public class LevelView extends JPanel implements ActionListener, KeyListener
{
	private static LevelView INSTANCE;
	private static Intermediary INTER;
	
	private static final int NO_TILES = 18;
	private static final int TILE_SIZE = 45;
	
	private LevelView () {
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	private void buildMap () {
		this.setBackground(Colors.GAME_LIGHT_BLUE);
	}
	
	@Override public void addNotify () {
		super.addNotify();
		requestFocusInWindow();
	}

	@Override public void actionPerformed (final ActionEvent e) {
		this.repaint();
	}

	@Override public void keyPressed (final KeyEvent e) {
		this.repaint();
	}
	
	@Override public void paintComponent (final Graphics g) {	
		INTER.getController();		
		
		
		super.paintComponent(g);
	}

	@Override public void keyTyped (final KeyEvent e) {}
	@Override public void keyReleased (final KeyEvent e) {}
	
	public static LevelView getInstance (final Intermediary inter) {
		if (INSTANCE == null) {
			INTER = inter;
			INSTANCE = new LevelView();
			INTER.setViewTitle("Playing level " + (INTER.getController().pleaseIndicateTheLevelNumber()));
			INSTANCE.buildMap();
		}
		return INSTANCE;
	}
}

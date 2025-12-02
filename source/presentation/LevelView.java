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



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import domain.MotionDirection;
import domain.map.BluePrint;
import domain.map.Drawable;
import domain.map.chars.CharacterFactory;
import domain.map.chars.Character;
import presentation.constants.Colors;
import presentation.constants.Titles;

class TileView extends JPanel {
	public static final int TILE_DIMENSIONS = 45;
	
	private Intermediary inter;
	
	public TileView (final Intermediary inter) {
		this.inter = inter;
	}

	public void updateMap () {
		this.repaint();
	}
	
	@Override protected void paintComponent (final Graphics g) {
		super.paintComponent(g);
		this.setBackground(Colors.SNOW);
		
		for (int row = 0; row < BluePrint.NUMBER_OF_ROWS; row++) {
			for (int col = 0; col < BluePrint.NUMBER_OF_COLS; col++) {
				g.drawImage(
					this.inter.getController().getTileAt(row, col).getFrontSideSprite(),
					col * TILE_DIMENSIONS,
					row * TILE_DIMENSIONS,
					TILE_DIMENSIONS,
					TILE_DIMENSIONS,
					this
				);
			}
		}
	}	
}

class CharView extends JPanel {
	private Intermediary inter;
	
	private Character ch1;
	private Character ch2;

	public CharView (final Intermediary inter) {
		this.inter = inter;
		this.setOpaque(false);
		
		this.ch1 = inter.getController().getCharacter1();
		
		this.initCharOne();
	}
	
	private void initCharOne () {
		final int x = this.inter.getController().getBluePrint().getPlayer1Position().getX();
		final int y = this.inter.getController().getBluePrint().getPlayer1Position().getY();

		this.ch1.getPosition().setX(x);
		this.ch1.getPosition().setY(y);
	}
	
	public void updateMap () {
		this.repaint();
	}
	
	private void renderCharacter (final Graphics g, final Character ch) {
		final int charPixelX = this.ch1.getPosition().getX() * TileView.TILE_DIMENSIONS;
        final int charPixelY = this.ch1.getPosition().getY() * TileView.TILE_DIMENSIONS;

        g.drawImage(
            ch.getCurrentSprite(),
            charPixelX,
            charPixelY,
            TileView.TILE_DIMENSIONS,
            TileView.TILE_DIMENSIONS,
            this
        );
	}
	
	@Override protected void paintComponent (final Graphics g) {
		super.paintComponent(g);
		this.renderCharacter(g, ch1);
	}
}

public class LevelView extends JLayeredPane implements ActionListener, KeyListener {
	private static LevelView INSTANCE;
	private static Intermediary INTER;
	
	private TileView tilesLayer;
	private CharView charsLayer;
	
	private LevelView () {
		this.setPreferredSize(new Dimension(BaDopoCreamGUI.WINDOW_WIDTH, BaDopoCreamGUI.WINDOW_HEIGHT));

		this.tilesLayer = new TileView(INTER);
		this.charsLayer = new CharView(INTER);
		
		this.tilesLayer.setBounds(0, 0, BaDopoCreamGUI.WINDOW_WIDTH, BaDopoCreamGUI.WINDOW_HEIGHT);
		this.charsLayer.setBounds(0, 0, BaDopoCreamGUI.WINDOW_WIDTH, BaDopoCreamGUI.WINDOW_HEIGHT);
		
		this.add(this.tilesLayer, JLayeredPane.DEFAULT_LAYER);
		this.add(this.charsLayer, JLayeredPane.PALETTE_LAYER);
		
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	@Override public void addNotify () {
		super.addNotify();
		this.requestFocusInWindow();
	}
	
	@Override public void actionPerformed (final ActionEvent e) {
		this.charsLayer.updateMap();
	}
	
	@Override public void keyPressed (final KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP: {
				INTER.getController().characterTryingToMove(
					MotionDirection.UP,
					INTER.getController().getCharacter1()
				);
				break;
			}

			case KeyEvent.VK_DOWN: {
				INTER.getController().characterTryingToMove(
					MotionDirection.DOWN,
					INTER.getController().getCharacter1()
				);
				break;
			}

			case KeyEvent.VK_LEFT: {
				INTER.getController().characterTryingToMove(
					MotionDirection.LEFT,
					INTER.getController().getCharacter1()
				);
				break;
			}

			case KeyEvent.VK_RIGHT: {
				INTER.getController().characterTryingToMove(
					MotionDirection.RIGHT,
					INTER.getController().getCharacter1()
				);
				break;
			}
		}
		this.charsLayer.updateMap();
	}
	
	@Override public void keyTyped (final KeyEvent e) {}
	@Override public void keyReleased (final KeyEvent e) {}
	
	public static LevelView getInstace (final Intermediary inter) {
		if (INSTANCE == null) {
			INTER = inter;
			INSTANCE = new LevelView();
			INTER.setViewTitle(Titles.playingLevel(INTER.getController().pleaseIndicateTheLevelNumber()));
		}
		return INSTANCE;
	}
}

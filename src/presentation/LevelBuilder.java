/**
 * <pre>
 *                                _____,,,,--'-'
 *                      ___,,,---'._ o      -`(
 *            ___,,,---'            \   .--.  `\
 *  ___,,,---'                      |   \   \ `|    Builder class :)
 * |                                |o o |  |  |
 * |                                 \___'.-`.  '.
 * |                                      |   `---'
 * '^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^' LGB
 * <\pre>
 *
 * This single class handles everything (helped by {@link LevelArch}) related to the level graphical
 * representation; It's main job is to translate the information given by the builder and handle
 * events called from {@link domain.LevelBrain}.
 *
 * @author juand
 */
package presentation;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import domain.MoveTo;

import javax.swing.JPanel;

import assets.BadColors;
import assets.BadFonts;

public class LevelBuilder extends JPanel implements KeyListener
{
	private static final int NO_CHUNKS  = 16;
	private static final int CHUNK_SIZE = 45;

	/**
	 * Even though {@link domain.LevelBrain} has the values for the number of seconds
	 * remaining and the current score, this class also need them in order to update
	 * those values graphically
	 */
	private int seconds;
	private int score;

	private LevelArch builder;
	private Character ch1;
	private Character ch2;
	
	private Nav nav;

	/**
	 * It starts the level by taking the Navigator and the number of the map to be constructed
	 * and played
	 *
	 * @param nav navigator for communication
	 * @param nomap map's number (@see LevelArch)
	 * @param ch1 information about character 1
	 * @param ch2 information about character 2
	 */
	public LevelBuilder (final Nav nav, final int nomap, final Character ch1, final Character ch2)
	{
		this.builder = LevelArch.getMap(nomap);
		this.ch1 = ch1;
		this.ch2 = ch2;
		this.nav = nav;
		this.setBackground(BadColors.GAME_SNOW);

		this.nav.getController().setUpLevelContextCommunication(this, this.builder);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	@Override
	protected void paintComponent(final Graphics g)
	{
		super.paintComponent(g);

		final int [][] map = this.builder.getMap();

		for (int row = 0; row < NO_CHUNKS; row++)
		{
			for (int col = 0; col < NO_CHUNKS; col++)
			{
				this.decorateChunkDepeningOnMeaning(row, col, g, map);
			}
		}

		this.displayLevelInformation(g);
	}

	private void decorateChunkDepeningOnMeaning (final int row, final int col, final Graphics g, final int [][] map)
	{
		final int px_x = col * CHUNK_SIZE, px_y = row * CHUNK_SIZE;
		switch (map[row][col])
		{
			case MapMeaning.DELIMITER:     { g.drawImage(this.builder.getDelimiter(), px_x, px_y, CHUNK_SIZE, CHUNK_SIZE, this); break; }
			case MapMeaning.ICE_BLOCK:     { g.drawImage(this.builder.getFloor()    , px_x, px_y, CHUNK_SIZE, CHUNK_SIZE, this); break; }
			case MapMeaning.FLOOR_VARIANT: { g.drawImage(this.builder.getVariant() , px_x , px_y, CHUNK_SIZE, CHUNK_SIZE, this); break; }

			case MapMeaning.PLAYER_1_IS_HERE:
			{
				g.drawImage(this.ch1.getFront(), px_x, px_y, CHUNK_SIZE, CHUNK_SIZE, this);
				this.ch1.setFixedPosition(row, col);
				break;
			}
		}
	}

	private void displayLevelInformation (final Graphics g)
	{
		g.setFont(BadFonts.HDU);
		g.setColor(BadColors.GAME_SCORE_FOREGROUND);

		final String score = String.format("1P %05d", this.score);
		g.drawString(score, CHUNK_SIZE / 2, CHUNK_SIZE - 10);

		final int mins = this.seconds / 60;
		final int secs = this.seconds % 60;

		final String timer = String.format("%d:%02d", mins, secs);
		g.drawString(timer, CHUNK_SIZE * NO_CHUNKS -  CHUNK_SIZE * 2, CHUNK_SIZE - 10);
	}
	
	public void updateTimer (final int remaining)
	{
		this.seconds = remaining;
		this.repaint();
	}

	@Override
	public void keyPressed (final KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
			{
				this.nav.getController().canPlayerMove(this.ch1, MoveTo.ABOVE);
				break;
			}
			
			case KeyEvent.VK_DOWN:
			{
				break;
			}
			
			case KeyEvent.VK_LEFT:
			{
				break;
			}
			
			case KeyEvent.VK_RIGHT:
			{
				break;
			}
			
			case KeyEvent.VK_SPACE:
			{
				break;
			}
			
			case KeyEvent.VK_P: case KeyEvent.VK_ESCAPE:
			{
				break;
			}
		}
	}

	@Override public void keyTyped (final KeyEvent e) {}
	@Override public void keyReleased (final KeyEvent e) {}
}






















































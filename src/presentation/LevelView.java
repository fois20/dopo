package presentation;

import java.awt.Graphics;
import javax.swing.JPanel;

public class LevelView extends JPanel
{
	private static final int NO_CHUNKS = 16;
	private static final int CHUNK_SIZE = 45;
	
	private MapBuilder builder;
	private int seconds;
	private int score;
		
	public LevelView (final Nav nav, final int nomap)
	{
		this.builder = MapBuilder.getMap(nomap);
		this.setBackground(BadColors.GAME_SNOW);
		
		nav.getController().setUpLevelContextCommunication(this, this.builder);
		nav.getController().pauseTimer();
	}
	
	@Override
	protected void paintComponent(final Graphics g)
	{
	    super.paintComponent(g);

	    final int [][] blocks = this.builder.getPreInitIceBlocks();
	    final int [][] variants = this.builder.getFloorVariants();

	    for (int row = 0; row < NO_CHUNKS; row++)
	    {
	        for (int col = 0; col < NO_CHUNKS; col++)
	        {
	            final boolean isDelimiter = col == 0 || row == 0 || col == NO_CHUNKS - 1 || row == NO_CHUNKS - 1;
	            
	            if (isDelimiter)
	            {
	            	g.drawImage(this.builder.getDelimiter(), col * CHUNK_SIZE, row * CHUNK_SIZE, CHUNK_SIZE, CHUNK_SIZE, this);
	            }
	            
	            if (blocks[row][col] == 1)
	            {
	            	g.drawImage(this.builder.getFloor(), col * CHUNK_SIZE, row * CHUNK_SIZE, CHUNK_SIZE, CHUNK_SIZE, this);
	            }

	            if (variants[row][col] == 1)
	            {
	            	g.drawImage(this.builder.getVariant(), col * CHUNK_SIZE, row * CHUNK_SIZE, CHUNK_SIZE, CHUNK_SIZE, this);
	            }
	        }
	    }

	    this.displayLevelInformation(g);
	}

	private void displayLevelInformation (final Graphics g)
	{
		g.setFont(BadFonts.IN_GAME);
		g.setColor(BadColors.GAME_SCORE);
		
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
	
	
}

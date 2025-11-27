/**
 * <pre>
 *         .__---~~~(~~-_.
 *      _-'  ) -~~- ) _-" )_                 Brain class :)
 *     (  ( `-,_..`.,_--_ '_,)_
 *    (  -_)  ( -_-~  -_ `,    )
 *    (_ -_ _-~-__-~`, ,' )__-'))--___--~~~--__--~~--___--__..
 *    _ ~`_-'( (____;--==,,_))))--___--~~~--__--~~--__----~~~'`=__-~+_-_.
 *   (@) (@) `````      `-_(())_-~  mn
 * <\pre>
 * 
 * This is the logic behind of the visual {@link presenation.LevelBuilder} class, it allows
 * and forbids certain operations on certain conditions
 *
 * @author juand
 */
package domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import presentation.Character;

import presentation.LevelArch;

public class LevelBrain
{	
	private int   timeSeconds; 
	private int   score;	
	private Timer timer;
	private int [][] map;

	/**
	 * this constructor should only be called from {@link Control#setUpLevelContextCommunication}
	 * since it's the bridge between this class and the visual part
	 *
	 * @param builder basic logic/information of this level
	 */
	public LevelBrain (final Control controller, final LevelArch builder)
	{
		this.timeSeconds = builder.getTime();
		this.score = 0;
		this.map = builder.getMap();

		this.timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				controller.updateTimerBitch(timeSeconds--);

				if (timeSeconds == 0)
				{
					timer.stop();
				}
			}
		});
		
		this.timer.start();
	}
	
	public MotionEndsUpIn move (final Character ch, final MoveTo to)
	{	
		final int chrow = ch.getFixedRow(), chcol = ch.getFixedCol(); 
		int finalrow = chrow, finalcol = chcol;
		
		switch (to)
		{
			case ABOVE: { finalrow -= 1; break; }
			case BELLOW: { finalrow += 1; break; }
			case LEFT: { finalcol -= 1; break; }
			case RIGHT: { finalcol += 1; break; }
		}	
		
		// TODO: updte map
		ch.setFixedPosition(finalrow, finalcol);
		return MotionEndsUpIn.JUST_MOVED;
	}

	public void resumeTimer () { this.timer.start(); }
	public void pauseTimer () { this.timer.stop(); }
	
	public int [][] getMap () { return this.map; }
}

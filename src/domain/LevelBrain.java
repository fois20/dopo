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

import presentation.LevelArch;

public class LevelBrain
{	
	private int     timeSeconds; 
	private int     score;	
	private Timer   timer;
	private Control controller;

	/**
	 * this constructor should only be called from {@link Control#setUpLevelContextCommunication}
	 * since it's the bridge between this class and the visual part
	 *
	 * @param controller controller to make calls telling what to do to the visual part
	 * @param builder basic logic/information of this level
	 */
	public LevelBrain (final Control controller, final LevelArch builder)
	{
		this.controller = controller;
		this.timeSeconds = builder.getTime();
		this.score = 0;

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
	}

	public void resumeTimer () { this.timer.start(); }
	public void pauseTimer () { this.timer.stop(); }
}

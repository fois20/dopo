/**
 * This class defines an intermidiate between the visual and logic parts
 * of the project, basically it's a bridge used for communication
 * 
 * @author juand
 */
package domain;

import presentation.LevelView;
import presentation.MapBuilder;

public class Control
{	
	private LevelAvailableness levelAvailableness;
	private LevelView          levelView;
	private LevelContext       levelContext;

	/**
	 * Inits most of the fields (the ones which does not depend on other clases)
	 * so they can be used later on the execution
	 */
	public Control ()
	{
		this.levelAvailableness = new LevelAvailableness();
	}	

	/**
	 * The visual part needs to know what levels are blocked in order
	 * to remove actionListeners from the buttons and make them look
	 * blocked
	 */
	public boolean [] getLevelsAvailableness ()
	{
		return this.levelAvailableness.getLevelsAvailableness();
	}

	/**
	 * When a level is finally loaded, the communication becomes even more
	 * important since the visual part needs to know if it should perform
	 * certain operations based on the current logic of the game
	 *
	 * @param lvlview the loaded label (visual part)
	 * @param builder the basic information of the selected level
	 */
	public void setUpLevelContextCommunication (final LevelView lvlview, final MapBuilder builder)
	{
		this.levelContext = new LevelContext(this, builder);
		this.levelView = lvlview;
	}

	/**
	 * Whenever the logic detects a second has passed by, it shall call this method
	 * in order to let the user know a second has ellapsed by redrawing the visual
	 * components
	 *
	 * @param remaining time left
	 */
	public void updateTimerBitch (final int remaining)
	{
		this.levelView.updateTimer(remaining);
	}

	/**
	 * These methods are needed since the {@link presentation.BadIceCreamGUI#initObjs} method
	 * loads the all the panels at once so they constructors get called and it will fire
	 * the timer in the logic part, we do not what start the timer until the level is selected
	 * and we also need this to resume/paused the game whenever is paused/resumed
	 */
	public void resumeTimer () { this.levelContext.resumeTimer(); }
	public void pauseTimer () { this.levelContext.pauseTimer(); }
}

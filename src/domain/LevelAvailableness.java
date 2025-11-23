/**
 * This class makes sure of what levels shall be unlocked or locked depending
 * on whether the user passed previous levels
 *
 * @author juand
 */
package domain;

public class LevelAvailableness
{
	public static final int NO_LEVELS = 40;

	private boolean [] availableOnes;

	/**
	 * for now it only works at runtime so if a user passed the level one
	 * and then exits, the next time they open the app, they'll have to
	 * start from the very first level, so it'd be nice to store that information
	 */
	public LevelAvailableness ()
	{
		this.setUp();
	}

	/**
	 * if we implement the persistence for the levels we will have to
	 * change this code and parse the persistance file here somehow
	 */
	private void setUp ()
	{	
		this.availableOnes = new boolean[NO_LEVELS];
		this.availableOnes[0] = true;
		for (int i = 1; i < NO_LEVELS; i++) { this.availableOnes[i] = false; }
	}	

	public void setLevelAsAvailable (final int level) { this.availableOnes[level] = true; }
	public boolean [] getLevelsAvailableness () { return this.availableOnes; }	
}

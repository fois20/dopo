package domain;

public class LevelAvailableness
{
	public static final int NO_LEVELS = 40;

	private boolean [] levelsAvailableness;
	
	public LevelAvailableness ()
	{
		this.setUp();
	}
	
	private void setUp ()
	{	
		this.levelsAvailableness = new boolean[NO_LEVELS];
		this.levelsAvailableness[0] = true;
		for (int i = 1; i < NO_LEVELS; i++) { this.levelsAvailableness[i] = false; }
	}	
	
	public void setLevelAsAvailable (final int level)
	{
		this.levelsAvailableness[level] = true;
	}
	
	public boolean [] getLevelsAvailableness ()
	{
		return this.levelsAvailableness;
	}	
}

package domain;

public class Control
{	
	private LevelAvailableness levelAvailableness;

	public Control ()
	{
		this.levelAvailableness = new LevelAvailableness();
	}	
	
	public boolean [] getLevelsAvailableness ()
	{
		return this.levelAvailableness.getLevelsAvailableness();
	}
}

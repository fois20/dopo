package domain;

public class BadIceCreamException extends Exception
{
	public static final String ACTION_NO_IMPLEMENTED = "ACTION IS NOT IMPLEMENTED YET";
	
	public BadIceCreamException (final String message)
	{
		super(message);
	}
}

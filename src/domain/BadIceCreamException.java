/**
 * This is the class which implements the exception the project will
 * be using, it only extends from {@link Exception} class and defines
 * some useful error messages
 * 
 * @author juand
 */
package domain;

public class BadIceCreamException extends Exception
{
	public static final String ACTION_NO_IMPLEMENTED = "ACTION IS NOT IMPLEMENTED YET";

	/**
	 * Constructs a new exception with the specified detail message, The
	 * cause is always gonna be initialized.
	 *
	 * @param message specifying the cause of the exception
	 */
	public BadIceCreamException(final String message)
	{
		super(message);
	}
}

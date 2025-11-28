/**    _
 *   ,' `,.			This class defines the exception to be handled whenever
 *   >-.(__)		a user makes a mistake or the program wants to display
 *  (_,-' |			some informational message
 *    `.  |
 *      `.| hjw
 *        `
 *
 * @author juad - 2025
 */
package exceptions;

public class UserException extends Exception
{
	public static final String BUTTON_NO_IMPLEMENTED = "This button, does not have an action yet!";
	
	public UserException (final String message)
	{
		super(message);
	}
}

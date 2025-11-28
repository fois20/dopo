/**    _
 *   ,' `,.			This class defines the exception to be handled whenever
 *   >-.(__)		a programmer makes a mistake, so the program can log the
 *  (_,-' |			error without crashing or maybe it crashes but in a pretty way
 *    `.  |
 *      `.| hjw
 *        `
 *
 * @author juad - 2025
 */

package exceptions;

public class ProgrammerException extends Exception
{
	public ProgrammerException (final String message)
	{
		super(message);
	}
	
	public static String loadingResource (final String resource)
	{
		return "error while loading resource: " + resource;
	}
}

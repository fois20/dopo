/**    _
 *   ,' `,.			This interface is an Intermediary between the panels and the {@link BadIceCream}
 *   >-.(__)		class, so the views do not need a whole object to interact but rather only the
 *  (_,-' |			methods defined here
 *    `.  |
 *      `.| hjw
 *        `
 *
 * @author juad - 2025
 */
package presentation;

public interface Intermediary
{
	/** Changes the title of the window
	 * 
	 * @param title title message to be set
	 */
	void changeTitle (final String title);

	/** Shows an JDialog display an error message and its cause
	 * 
	 * @param errormessage error message (see {@link exceptions.UserException})
	 */
	void userError (final String errormessage);

	/** Writes to a log file where programmer(s) can see the errors that
	 * happened during execution
	 * 
	 * @param errormessage error message (see {@link exceptions.ProgrammerException})
	 */
	void programmerError (final String errormessage);

	/** Displays the panel indicated by the id given
	 * 
	 * @param viewid panel's id
	 */
	void setView (final String viewid);
}

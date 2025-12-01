/**    _
 *   ,' `,.
 *   >-.(__)
 *  (_,-' |
 *    `.  |
 *      `.| hjw
 *        `
 *
 * This class defines the application’s entry point.
 * Refer to the project’s README for requirements and
 * instructions on how to run the program properly.
 *
 * @author juad - 2025
 */
package presentation;

import domain.Control;

public class Main {
	public static void main (final String [] args) {
		BaDopoCreamGUI.getInstance(new Control());
	}
}

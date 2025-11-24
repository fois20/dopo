/**
 * This interface is written in order to avoid passing as argument the
 * BadIceCreamGUI object over and over again through different methods, even
 * the ones that does not use it but call one method that does
 *
 * @author juand
 */
package presentation;

import domain.Control;

public interface Nav
{
	void setView (final String viewId);
	void error (final String errmsg);
	Control getController ();
}

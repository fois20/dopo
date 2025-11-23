/* This interface is written in order to avoid passing as argument the
 * BadIceCreamGUI object over and over again through different methods, even
 * the ones that does not use it but call one method that does
 *
 * @author juan diego patino munoz
 */
package presentation;

public interface Nav
{
	void setView (final String viewId);
	void unimplementedSorry (final String what);
}

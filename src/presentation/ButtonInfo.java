/**
 * This class implements a simple context for the creation and implementation of buttons
 * in the program, info such as: name (button text), the id of the view where it has to
 * jump whenever it's clicked and a position within the array it belongs to since this
 * class is used by groups of bottons
 * 
 * @author juand
 */
package presentation;

public class ButtonInfo
{
	private String name;
	private String viewId;
	private int    position;
	
	public ButtonInfo (final String name, final String viewId, final int position)
	{
		this.name = name;
		this.viewId = viewId;
		this.position = position;
	}
	
	public String getName () { return this.name; }
	public String getViewId () { return this.viewId; }
	public int getPosition () { return this.position; }
}

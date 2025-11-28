/**    _
 *   ,' `,.			This is a way to contextualize the buttons when they're in a family
 *   >-.(__)		of buttons for example in the modal window of the {@link HomeView}
 *  (_,-' |
 *    `.  |			[start]			-> ("start", "START_VIEW", 0)
 *      `.| hjw		[recods]		-> ("recods", "RECODS_VIEW", 1)
 *        `			[credits]		-> ("credits", "CREDITS_VIEW", 2)
 *        
 *	note that field 'jumpTo' shall be a string already defined in {@link ViewsId}
 * @author juad - 2025
 */
package presentation;

public class ButtonInfo
{
	private String name;
	private String jumpTo;
	private int index;
	
	public ButtonInfo (final String name, final String jmp2, final int index)
	{
		this.name = name;
		this.jumpTo = jmp2;
		this.index = index;
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public String getJumpTo ()
	{
		return this.jumpTo;
	}
	
	public int getIndex ()
	{
		return this.index;
	}
}

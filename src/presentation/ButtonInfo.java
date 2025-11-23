package presentation;

public class ButtonInfo
{
	private String name;
	private String viewId;
	private int position;
	
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
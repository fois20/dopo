/**
 * This class is designed to have an clean way to determinate
 * the flavour of a player
 * 
 * @author juand
 */
package presentation;

public class Character
{
	public static final String CHOCOLATE = "chocolate";
	public static final String VANILLA = "vanilla";
	public static final String STRAWBERRRY = "strawberrry";
	
	public static final Character DUMMY1 = new Character(CHOCOLATE);
	public static final Character DUMMY2 = new Character(VANILLA);
	
	private String name;
	
	public Character (final String characterName)
	{
		this.name = characterName;
	}
	
	public String getName () { return this.name; }
}

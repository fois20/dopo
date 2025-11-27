/**
 * This class is designed to have an clean way to determinate
 * the flavour of a player
 * 
 * @author juand
 */
package presentation;

import java.awt.Image;
import javax.swing.ImageIcon;

import assets.Routes;

public class Character
{
	private static final int NO_SPRITES = 4;

	private static final int FRONT = 0;
	private static final int BACK = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	
	public static final String CHOCOLATE = "chocolate";
	public static final String VANILLA = "vanilla";
	public static final String STRAWBERRRY = "strawberrry";
	
	private String name;
	private String path;

	private Image [] sprites;
	private int fixedRow;
	private int fixedCol;
	

	public Character (final String characterName)
	{
		this.name = characterName;
		this.path = Routes.getPathFor(characterName);
		this.loadSprites();
	}
	
	private void loadSprites ()
	{
		this.sprites = new Image[NO_SPRITES];
		
		final String [] needed = {
			Routes.FRONT,
			Routes.BACK,
			Routes.LEFT,
			Routes.RIGHT
		};
		
		// TODO add a programmer execption (needed.length ==  NO_SPRITES)
		
		for (int i = 0; i < NO_SPRITES; i++)
		{
			this.sprites[i] = new ImageIcon(this.path + needed[i]).getImage();
		}
	}
	
	public void setFixedPosition (final int frow, final int fcol)
	{
		this.fixedCol = fcol;
		this.fixedRow = frow;
	}
	
	public String getName () { return this.name; }
	public Image getFront () { return this.sprites[FRONT]; }
	public Image getBack () { return this.sprites[BACK]; }
	public Image getLeft () { return this.sprites[LEFT]; }
	public Image getRight () { return this.sprites[RIGHT]; }
	public int getFixedRow () { return this.fixedRow; }
	public int getFixedCol () { return this.fixedCol; }
}

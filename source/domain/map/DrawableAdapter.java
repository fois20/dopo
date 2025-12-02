package domain.map;

import java.awt.Image;
import javax.swing.ImageIcon;
import presentation.constants.Paths;

public class DrawableAdapter implements Drawable {
	protected Image frontSprite;
	protected Image backSprite;
	protected Image leftSprite;
	protected Image rightSprite;
	protected Image brokenSprite;
	
    private static Image loadImage(final String path) {
        return new ImageIcon(path != null ? path : Paths.SPRITE_NONE).getImage();
    }

    private DrawableAdapter (final String frontPath, final String backPath, final String leftPath, final String rightPath, final String brokenPath) { 
        this.frontSprite = loadImage(frontPath);
        this.backSprite = loadImage(backPath);
        this.leftSprite = loadImage(leftPath);
        this.rightSprite = loadImage(rightPath);
        this.brokenSprite = loadImage(brokenPath);
    }
	
	public DrawableAdapter (final String frontPath, final String backPath, final String leftPath, final String rightPath) {
		this(frontPath, backPath, leftPath, rightPath, Paths.SPRITE_NONE);
	}
    
	public DrawableAdapter (final String frontPath, final String brokenPath) {
		this(frontPath, Paths.SPRITE_NONE, Paths.SPRITE_NONE, Paths.SPRITE_NONE, brokenPath);
	}

	public DrawableAdapter (final String frontPath) {
		this(frontPath, Paths.SPRITE_NONE, Paths.SPRITE_NONE, Paths.SPRITE_NONE, Paths.SPRITE_NONE);
	}

	public DrawableAdapter () {
		this(Paths.SPRITE_NONE); 
	}
	
	@Override public Image getFrontSideSprite () {
		return frontSprite;
	}
	
	@Override public Image getBackSideSprite () {
		return backSprite;
	}
	
	@Override public Image getRightSideSprite () {
		return rightSprite;
	}
	
	@Override public Image getLeftSideSprite () {
		return leftSprite;
	}
	
	@Override public Image getBrokenSideSprite () {
		return brokenSprite;
	}
}

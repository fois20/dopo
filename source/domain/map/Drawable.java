package domain.map;

import java.awt.Image;

public interface Drawable {
	Image getFrontSideSprite ();
	Image getBackSideSprite ();
	Image getRightSideSprite ();
	Image getLeftSideSprite ();
	Image getBrokenSideSprite ();
}

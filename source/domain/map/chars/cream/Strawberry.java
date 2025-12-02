package domain.map.chars.cream;

import presentation.constants.Paths;

public class Strawberry extends IceCream {
	private static final String SPRITE_FRONT_PATH = Paths.SPRITE_CHAR_STRAWBERRY_FRONT;
	private static final String SPRITE_BACK_PATH = Paths.SPRITE_CHAR_STRAWBERRY_BACK;
	private static final String SPRITE_LEFT_PATH = Paths.SPRITE_CHAR_STRAWBERRY_LEFT;
	private static final String SPRITE_RIGHT_PATH = Paths.SPRITE_CHAR_STRAWBERRY_RIGHT;
	
	public Strawberry () {
		super(SPRITE_FRONT_PATH, SPRITE_BACK_PATH, SPRITE_LEFT_PATH, SPRITE_RIGHT_PATH);
	}
}

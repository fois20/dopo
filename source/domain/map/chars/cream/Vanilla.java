package domain.map.chars.cream;

import presentation.constants.Paths;

public class Vanilla extends IceCream {
	private static final String SPRITE_FRONT_PATH = Paths.SPRITE_CHAR_VANILLA_FRONT;
	private static final String SPRITE_BACK_PATH = Paths.SPRITE_CHAR_VANILLA_BACK;
	private static final String SPRITE_LEFT_PATH = Paths.SPRITE_CHAR_VANILLA_LEFT;
	private static final String SPRITE_RIGHT_PATH = Paths.SPRITE_CHAR_VANILLA_RIGHT;
	
	public Vanilla () {
		super(SPRITE_FRONT_PATH, SPRITE_BACK_PATH, SPRITE_LEFT_PATH, SPRITE_RIGHT_PATH);
	}
}

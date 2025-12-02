package domain.map.chars.cream;
import presentation.constants.Paths;

public class Chocolate extends IceCream {
	private static final String SPRITE_FRONT_PATH = Paths.SPRITE_CHAR_CHOCOLATE_FRONT;
	private static final String SPRITE_BACK_PATH = Paths.SPRITE_CHAR_CHOCOLATE_BACK;
	private static final String SPRITE_LEFT_PATH = Paths.SPRITE_CHAR_CHOCOLATE_LEFT;
	private static final String SPRITE_RIGHT_PATH = Paths.SPRITE_CHAR_CHOCOLATE_RIGHT;
	
	public Chocolate () {
		super(SPRITE_FRONT_PATH, SPRITE_BACK_PATH, SPRITE_LEFT_PATH, SPRITE_RIGHT_PATH);
	}
}

package domain.map.chars.enemies;

import domain.LevelContextualizer;
import domain.MotionDirection;
import domain.MotionEndsUp;
import domain.map.chars.Character;
import presentation.constants.Paths;

public class Troll extends Character
{
	private static final String SPRITE_FRONT_PATH = Paths.SPRITE_CHAR_TROLL_FRONT;
	private static final String SPRITE_BACK_PATH = Paths.SPRITE_CHAR_TROLL_BACK;
	private static final String SPRITE_LEFT_PATH = Paths.SPRITE_CHAR_TROLL_LEFT;
	private static final String SPRITE_RIGHT_PATH = Paths.SPRITE_CHAR_TROLL_RIGHT;

	public Troll () {
		super(SPRITE_FRONT_PATH, SPRITE_BACK_PATH, SPRITE_LEFT_PATH, SPRITE_RIGHT_PATH);
	}

	@Override
	public MotionEndsUp move(MotionDirection towards, LevelContextualizer lc) {
		return null;
	}
}
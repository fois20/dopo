package domain.map.chars;

import java.awt.Image;

import domain.GoingDirection;
import domain.LevelContextualizer;
import domain.MotionDirection;
import domain.MotionEndsUp;
import domain.map.BluePrint;
import domain.map.DrawableAdapter;

public abstract class Character extends DrawableAdapter {
	protected Position pos;
	protected GoingDirection lastDirection;
	
	private Image [] renderings;
	private Image sprite;
	
	protected Character (final String frontSpritePath, final String backSpritePath, final String leftSpritePath, final String rightSpritePath) {
		super(frontSpritePath, backSpritePath, leftSpritePath, rightSpritePath);
		this.pos = new Position(0, 0);
		
		this.renderings = new Image [] {
			this.frontSprite,
			this.backSprite,
			this.leftSprite,
			this.rightSprite
		};
		this.lastDirection = GoingDirection.FRONT;
		this.setSprite();
	}	
	
	public Position getPosition () {
		return this.pos;
	}
	
	protected Position simulateMotion (final MotionDirection towards) {
		final GoingDirection trying = MotionDirection.turnIntoGoingDirection(towards);
		if (trying != this.lastDirection) {
			this.lastDirection = trying;
			this.setSprite();
			return this.pos;
		}
		
		final int currentx = this.pos.getX();
		final int currenty = this.pos.getY();
		Position simulated = new Position(currentx, currenty);

		switch (towards) {
			case UP: simulated.setY(currenty - 1); break;
			case DOWN: simulated.setY(currenty + 1); break;
			case LEFT: simulated.setX(currentx - 1); break;
			case RIGHT: simulated.setX(currentx + 1); break;
		}
		
		this.lastDirection = MotionDirection.turnIntoGoingDirection(towards);
		this.setSprite();
		return simulated;
	}
	
	private void setSprite () {
		this.sprite = this.renderings[this.lastDirection.getAsIndex()];
	}
	
	public Image getCurrentSprite () {
		return this.sprite;
	}
	
	public abstract MotionEndsUp move (final MotionDirection towards, final LevelContextualizer lc);
}

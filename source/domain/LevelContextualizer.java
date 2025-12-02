package domain;

import domain.map.BluePrint;
import domain.map.tiles.Tile;

public class LevelContextualizer {
	private Tile [][] tiles;
	private Character [][] chars;
	
	public LevelContextualizer () {
		this.tiles = new Tile [BluePrint.NUMBER_OF_ROWS][BluePrint.NUMBER_OF_COLS];
		this.chars = new Character [BluePrint.NUMBER_OF_ROWS][BluePrint.NUMBER_OF_COLS];
	}
	
	public void setTileAt (final int row, final int col, final Tile tile) {
		this.tiles[row][col] = tile;
	}
	
	public void setCharAt (final int row, final int col, final Character ch) {
		this.chars[row][col] = ch;
	}
	
	public Tile getTileAt (final int row, final int col) {
		return this.tiles[row][col];
	}

	public Character getChatAt (final int row, final int col) {
		return this.chars[row][col];
	}
}

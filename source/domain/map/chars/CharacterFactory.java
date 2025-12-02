package domain.map.chars;

import domain.map.chars.cream.Chocolate;
import domain.map.chars.cream.Strawberry;
import domain.map.chars.cream.Vanilla;
import exceptions.BLogger;
import exceptions.ProgrammerException;

public class CharacterFactory {
	public static Character get (final CharType type) {
		switch (type) {
			case VANILLA: { return new Vanilla(); }
			case CHOCOLATE: { return new Chocolate(); }
			case STRAWBERRY: { return new Strawberry(); }
			case TROLL: { return new Chocolate(); }
		}
		
		BLogger.logError(BLogger.SEVERE, new ProgrammerException(ProgrammerException.unreachable("CharacterFactory")));
		return null;
	}
}

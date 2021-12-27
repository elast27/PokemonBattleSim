package main.move;

import main.pokemon.Pokemon;

@FunctionalInterface
public interface StatusMoveEffect {
	void apply(Pokemon p);
}

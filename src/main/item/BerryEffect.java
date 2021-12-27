package main.item;

import main.move.Move;

@FunctionalInterface
public interface BerryEffect {
	boolean apply(Move m);
}

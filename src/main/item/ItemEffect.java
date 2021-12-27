package main.item;

import main.move.Move;

@FunctionalInterface
public interface ItemEffect {
	boolean apply(Move m);
}

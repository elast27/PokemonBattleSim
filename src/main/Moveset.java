package main;

public class Moveset {
	private Move move1;
	private Move move2;
	private Move move3;
	private Move move4;
	
	public Move getMove(int idx) {
		switch(idx) {
		case 0:
			return move1;
		case 1:
			return move2;
		case 2:
			return move3;
		case 3:
			return move4;
		default: return null;
		}
	}
	
	public Move[] getMoves() {
		Move[] list = {move1, move2, move3, move4};
		return list;
	}
	
	public void addMove(Move move, int idx) {
		switch(idx) {
		case 0:
			move1 = move;
		case 1:
			move2 = move;
		case 2:
			move3 = move;
		case 3:
			move4 = move;
		default: return;
		}
	}

	public Moveset(Move move1, Move move2, Move move3, Move move4) {
		super();
		this.move1 = move1;
		this.move2 = move2;
		this.move3 = move3;
		this.move4 = move4;
	}

}

package main.move;

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
			break;
		case 1:
			move2 = move;
			break;
		case 2:
			move3 = move;
			break;
		case 3:
			move4 = move;
			break;
		default: return;
		}
	}

	public Moveset(Move... moves) {
		super();
		int i = 0;
		for(Move m : moves) {
			if(i==4) return;
			this.addMove(m, i);
			i++;
		}
	}

}

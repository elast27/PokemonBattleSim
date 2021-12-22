package main;

public class AI {
	private Pokemon p;
	
	public AI(Pokemon p) {
		this.p = p;
	}
	
	public Pokemon getPokemon() {
		return p;
	}
	
	public Move pickMove(Pokemon opp) {
		return p.getMove(0);
	}
}

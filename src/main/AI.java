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
		//RANDOM APPROACH
//		int r = (int)((Math.random()*100)%4);
//		return p.getMove(r);
		
		//GREEDY APPROACH
		Move[] m = p.getMoves().getMoves();
		Type t1 = opp.getType1();
		Type t2 = opp.getType2();
		
		for(Move i : m) {
			if(t1.getWeak().contains(i.getType().getType())) {
				return i;
			} else if(t2!=null && t2.getWeak().contains(i.getType().getType())) {
				return i;
			}
		}
		Move max = m[0];
		for(Move i : m) {
			if(i.getPower() > max.getPower()) max = i;
		}
		return max;
	}
}

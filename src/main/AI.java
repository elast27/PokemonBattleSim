package main;

import java.util.Arrays;

import main.Move.DamageType;

public class AI {
	private Pokemon p;
	private Move lastUsed;
	public AI(Pokemon p) {
		this.p = p;
	}
	
	public Pokemon getPokemon() {
		return p;
	}
	
	public Move randomApproach(Pokemon opp) {
		//RANDOM APPROACH
		int r = (int)((Math.random()*100)%4);
		return p.getMove(r);
	}
	public Move greedyApproach(Pokemon opp) {
		//GREEDY APPROACH
		Move[] m = p.getMoves().getMoves();
		Move max = m[0];
		for(Move i : m) {
			if(i.getPower() > max.getPower()) max = i;
		}
		lastUsed = max;
		return max;
	}
	
	public Move informedApproach(Pokemon opp) {
		//INFORMED APPROACH
		double atkRatio = p.getStat(Stat.ATK)-opp.getStat(Stat.DEF);
		double spaRatio = p.getStat(Stat.SPA)-opp.getStat(Stat.SPD);
		if(atkRatio > spaRatio) {
			Object[] physMoves = Arrays.asList(p.getMoves().getMoves()).stream().filter(m->m.getDamageType()==DamageType.PHYSICAL).toArray();
			if(physMoves instanceof Move[]) {
				for(Move m : (Move[])physMoves) {
					if(opp.getType1().getWeak().contains(m.getType().getType())) return m;
					else if(opp.getType2()!=null && opp.getType2().getWeak().contains(m.getType().getType())) return m;
				}
			}
		} else if (spaRatio > atkRatio) {
			Object[] spaMoves = Arrays.asList(p.getMoves().getMoves()).stream().filter(m->m.getDamageType()==DamageType.SPECIAL).toArray();
			if(spaMoves instanceof Move[]) {
				for(Move m : (Move[])spaMoves) {
					if(opp.getType1().getWeak().contains(m.getType().getType())) return m;
					else if(opp.getType2()!=null && opp.getType2().getWeak().contains(m.getType().getType())) return m;
				}
			}
			
		} 
		return greedyApproach(opp);
	}
	public Move pickMove(Pokemon opp) {
		return informedApproach(opp);
	}
		
}

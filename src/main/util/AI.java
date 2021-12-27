package main.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import main.move.Move;
import main.move.Move.DamageType;
import main.pokemon.Pokemon;
import main.pokemon.Stat;

public class AI {
	private Pokemon p;
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
			if(i!=null) {
				if(i.getPower() > max.getPower()) max = i;
			}
		}
		return max;
	}
	
	public Move informedApproach(Pokemon opp) {
		//INFORMED APPROACH
		double atkRatio = p.getStat(Stat.ATK)-opp.getStat(Stat.DEF);
		double spaRatio = p.getStat(Stat.SPA)-opp.getStat(Stat.SPD);
		if(atkRatio > spaRatio) {
			ArrayList<Move> physMoves = new ArrayList<>();
			for(Move m : p.getMoves().getMoves()) {
				if(m!=null) {
					if(m.getDamageType()==DamageType.PHYSICAL)
						physMoves.add(m);
				}
			}
			for(Move m : physMoves) {
				if(opp.getType1().getWeak().contains(m.getType().getType())) return m;
				else if(opp.getType2()!=null && opp.getType2().getWeak().contains(m.getType().getType())) return m;
			}
		} else if (spaRatio > atkRatio) {
			ArrayList<Move> spaMoves = new ArrayList<>();
			for(Move m : p.getMoves().getMoves()) {
				if(m!=null) {
					if(m.getDamageType()==DamageType.SPECIAL)
						spaMoves.add(m);
				}
			}
			for(Move m : spaMoves) {
				if(opp.getType1().getWeak().contains(m.getType().getType())) return m;
				else if(opp.getType2()!=null && opp.getType2().getWeak().contains(m.getType().getType())) return m;
			}
			
		} 
		return greedyApproach(opp);
	}
	public Move pickMove(Pokemon opp) {
		return informedApproach(opp);
	}
		
}

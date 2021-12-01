package main;

public class Engine {
	
	public static double damageCalc(Pokemon attacker, Move move, Pokemon defender) {
		double A = 0;
		double B = 0;
		double random = Math.random() * (0.15)+0.85;
		double stab = (move.getType().equals(attacker.getType1()) || move.getType().equals(attacker.getType2())) ? 1.5 : 1;
		double typeEffect = 1;
		if(defender.getType2()!=null) {
			if(defender.getType1().getType().equals(move.getType().getNoEffect()) || defender.getType2().getType().equals(move.getType().getNoEffect())) return 0;
			if(defender.getType1().getWeak().contains(move.getType().getType())) typeEffect *= 2;
			if(defender.getType2().getWeak().contains(move.getType().getType())) typeEffect *= 2;
			if(defender.getType1().getResistant().contains(move.getType().getType())) typeEffect *= 0.5;
			if(defender.getType2().getResistant().contains(move.getType().getType())) typeEffect *= 0.5;
		}
		else {
			if(defender.getType1().getNoEffect().equals(move.getType().getNoEffect())) return 0;
			if(defender.getType1().getWeak().contains(move.getType().getType())) typeEffect *= 2;
			if(defender.getType1().getResistant().contains(move.getType().getType())) typeEffect *= 0.5;
		}
		if(move.getDamageType()==Move.DamageType.PHYSICAL) {
			A = attacker.getStat("atk");
			B = defender.getStat("def");
		} else if (move.getDamageType()==Move.DamageType.SPECIAL) {
			A = attacker.getStat("spa");
			B = defender.getStat("spd");
		}
		return ((((((2*attacker.getLvl()/5)+2)*move.getPower()*(A/B))/50)+2)* random * stab * typeEffect);
	}
	
	public static void main(String[] args) {
		Move[] moveset = new Move[4];
		
		moveset[0] = Move.THUNDER_SHOCK;
		moveset[1] = Move.DISCHARGE;
		moveset[2] = Move.QUICK_ATTACK;
		moveset[3] = Move.ICE_BEAM;
		final Ability STATIC = new Ability();
		Pokemon Manaphy = new Pokemon(25, "Manaphy", 60, new Stats(100,100,100,100,100,100), Type.WATER, null, moveset, STATIC);
		Manaphy.setEvs(new Stats(20,0,5,100,0,130));
		Manaphy.setIvs(new Stats(15,15,15,15,15,15));
		Manaphy.setNature(Nature.RASH);
//		Manaphy.setStageMult("def", 6);
		
		Move[] moveset2 = new Move[4];
		moveset2[0] = Move.EARTHQUAKE;
		final Ability KEEN_EYE = new Ability();
		Pokemon Talonflame = new Pokemon(16, "Talonflame", 45, new Stats(78,81,71,74,69,126), Type.FIRE, Type.FLYING, moveset2, KEEN_EYE);
		Talonflame.setEvs(new Stats(0,0,0,0,0,0));
		Talonflame.setIvs(new Stats(15,15,15,15,15,15));
		Talonflame.setNature(Nature.RELAXED);
		
		Pokemon Garchomp = new Pokemon(1, "Garchomp", 66, new Stats(108,130,95,80,85,102), Type.DRAGON, Type.GROUND, moveset2, KEEN_EYE);
		Garchomp.setNature(Nature.ADAMANT);
		Garchomp.setIvs(new Stats(24,12,30,16,23,5));
		Garchomp.setEvs(new Stats(74,190,91,48,84,23));
//		Garchomp.setStageMult("atk", 2);
		
		System.out.println(damageCalc(Garchomp, Garchomp.getMoves()[0], Manaphy));
		System.out.println(Garchomp.getStat("hp"));
		System.out.println(Manaphy.getStat("hp"));
	}
}

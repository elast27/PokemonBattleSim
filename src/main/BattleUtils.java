package main;

public class BattleUtils {
	public static double damageCalc(Pokemon attacker, Move move, Pokemon defender) {
		double A = 0;
		double B = 0;
		double extra = 1;
		double random = Math.random() * (0.15)+0.85;
		double stab = (move.getType().equals(attacker.getType1()) || move.getType().equals(attacker.getType2())) ? 1.5 : 1;
		double typeEffect = 1;
		if(defender.getType1().getType().equals(move.getType().getNoEffect()) && !move.getType().getNoEffect().equals("")) {
			System.out.println("It doesn't affect " + defender.getName());
			return 0;
		} 
		if(defender.getType1().getWeak().contains(move.getType().getType())) typeEffect *= 2;
		if(defender.getType1().getResistant().contains(move.getType().getType())) typeEffect *= 0.5;
		
		if(defender.getType2()!=null) {
			if(defender.getType2().getType().equals(move.getType().getNoEffect()) && !move.getType().getNoEffect().equals("")) {
				System.out.println("It doesn't affect " + defender.getName());
				return 0;
			}
			if(defender.getType2().getWeak().contains(move.getType().getType())) typeEffect *= 2;
			if(defender.getType2().getResistant().contains(move.getType().getType())) typeEffect *= 0.5;
		}
		if(typeEffect > 1) {
			if(defender.getHeldItem()!=null) {
				if(defender.getHeldItem() instanceof SuperEffectiveBerry) {
					SuperEffectiveBerry berry = (SuperEffectiveBerry)defender.getHeldItem();
					if(berry.getEffect().apply(move)) {
						System.out.println(defender.getName()+"'s "+defender.getHeldItem().getName()+" reduced the effect of "+move.getName());
						extra = 0.5;
						defender.setHeldItem(null);
					}
				}
			}
		}
		if(move.getDamageType()==Move.DamageType.PHYSICAL) {
			A = attacker.getStat(Stat.ATK);
			B = defender.getStat(Stat.DEF);
		} else if (move.getDamageType()==Move.DamageType.SPECIAL) {
			A = attacker.getStat(Stat.SPA);
			B = defender.getStat(Stat.SPD);
		}
		if(typeEffect > 1) System.out.println("It's super effective!");
		else if (typeEffect < 1) System.out.println("It's not very effective...");
		return ((((((2*attacker.getLvl()/5)+2)*move.getPower()*(A/B))/50)+2)* random * stab * typeEffect)*extra;
	}
	public static boolean moveHits(Pokemon attacker, Pokemon defender, Move move) {
		int stageMod = attacker.getStageMult(Stat.ACC) - defender.getStageMult(Stat.EVA);
		int mult = Math.abs(stageMod) + 3;
		double accMult;
		if(stageMod >= 0) accMult = mult/3.0;
		else accMult = 3.0/mult;
		double hitRandom = Math.random() * 100;
		if((double)move.getAcc()*accMult >= hitRandom) return true;
		return false;
	}
	public static void battleTurn(Pokemon p1, Move m1, Pokemon p2, Move m2) {
		if(m1.getPriority() > m2.getPriority()) {
			p1.attack(p2, m1);
			if(p2.getHp()>0) p2.attack(p1, m2);
		}
		else if(m2.getPriority() > m1.getPriority()) {
			p2.attack(p1, m2);
			if(p1.getHp()>0) p1.attack(p2, m1);
		}
		else {
			if(p1.getStat(Stat.SPE)>p2.getStat(Stat.SPE)) {
				p1.attack(p2, m1);
				if(p2.getHp()>0) p2.attack(p1, m2);
			} else {
				p2.attack(p1, m2);
				if(p1.getHp()>0) p1.attack(p2, m1);
			}
		}
		endOfTurn(p1,p2);
	}
	public static void endOfTurn(Pokemon a, Pokemon b) {
		a.isFlinched=false;
		b.isFlinched=false;
		if(a.getHp()>0) a.conditionCheck();
		if(b.getHp()>0) b.conditionCheck();
	}
}

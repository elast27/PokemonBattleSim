package main;

public class BattleUtils {
	public static double damageCalc(Pokemon attacker, Move move, Pokemon defender) {
		double A = 0;
		double B = 0;
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
		if(move.getDamageType()==Move.DamageType.PHYSICAL) {
			A = attacker.getStat("atk");
			B = defender.getStat("def");
		} else if (move.getDamageType()==Move.DamageType.SPECIAL) {
			A = attacker.getStat("spa");
			B = defender.getStat("spd");
		}
		if(typeEffect > 1) System.out.println("It's super effective!");
		else if (typeEffect < 1) System.out.println("It's not very effective...");
		return ((((((2*attacker.getLvl()/5)+2)*move.getPower()*(A/B))/50)+2)* random * stab * typeEffect);
	}
	public static boolean moveHits(Pokemon attacker, Pokemon defender, Move move) {
		int stageMod = attacker.getStageMult("acc") - defender.getStageMult("eva");
		int mult = Math.abs(stageMod) + 3;
		double accMult;
		if(stageMod >= 0) accMult = mult/3.0;
		else accMult = 3.0/mult;
		double hitRandom = Math.random() * 100;
		if((double)move.getAcc()*accMult >= hitRandom) return true;
		return false;
	}
	public static void battleTurn(Pokemon a, Move m, Pokemon b, Move n) {
		if(a.getStat("spd")>b.getStat("spd")) {
			a.attack(b, m);
			if(b.getHp()>0) b.attack(a, n);
		} else {
			b.attack(a, n);
			if(a.getHp()>0) a.attack(b, n);
		}
		endOfTurn(a,b);
	}
	public static void endOfTurn(Pokemon a, Pokemon b) {
		a.isFlinched=false;
		b.isFlinched=false;
		a.conditionCheck();
		b.conditionCheck();
	}
}

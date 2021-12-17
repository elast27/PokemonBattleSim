package main;

import main.Move.DamageType;

public class Engine {
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
	
	public static void attack(Pokemon attacker, Move move, Pokemon defender) {
		if(attacker.isFlinched) {
			System.out.println(attacker.getName()+ " flinched and couldn't move!");
			attacker.isFlinched = false;
			return;
		}
		if(attacker.isParalyzed) {
			double r = Math.random();
			if(r < .25) {
				System.out.println(attacker.getName()+" is paralyzed. It cannot move!");
				return;
			}
		}
		System.out.println(attacker.getName() + " used " + move.getName());
		if(moveHits(attacker, defender, move)) {
			if(move.getDamageType()!=DamageType.STATUS) {
				double damage = damageCalc(attacker, move, defender);
				defender.setHp((int)(defender.getHp()-damage));
				if(damage == 0) return;
				if(defender.getHp()<=0) {
					defender.setHp(0);
					System.out.println(defender.getName() + " fainted");
				}
			}
			if(move instanceof StatusMove) {
				if(((StatusMove)move).getTarget()) ((StatusMove) move).getEffect().apply(attacker);
				else ((StatusMove) move).getEffect().apply(defender);
			}
			if(move instanceof EffectMove) {
				((EffectMove)move).getEffect().apply(defender);
			}
		} else {
			System.out.println(attacker.getName() + "'s attack missed!");
		}
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
			attack(a,m,b);
			if(b.getHp()>0) attack(b,n,a);
		} else {
			attack(b,n,a);
			if(a.getHp()>0) attack(a,m,b);
		}
		endOfTurn(a,b);
	}
	public static void endOfTurn(Pokemon a, Pokemon b) {
		a.isFlinched=false;
		b.isFlinched=false;
		conditionCheck(a);
		conditionCheck(b);
	}
	
	public static void conditionCheck(Pokemon p) {
		if(p.isBurned || p.isPoisoned) {
			double value = p.getStat("hp")/16f;
			p.setHp((int)(p.getHp()-value));
		}
	}
	
	public static void main(String[] args) {
		Move[] moveset = new Move[4];
		moveset[0] = Move.ICE_BEAM;
		moveset[1] = Move.TAIL_GLOW;
		
		Pokemon Manaphy = new Pokemon(490, "Manaphy", 60, new Stats(100,100,100,100,100,100), Type.WATER, null, moveset, Ability.HYDRATION);
		Manaphy.setEvs(new Stats(20,0,5,100,0,130));
		Manaphy.setIvs(new Stats(15,15,15,15,15,15));
		Manaphy.setNature(Nature.RASH);
		
		Pokemon Talonflame = new Pokemon(663, "Talonflame", 45, new Stats(78,81,71,74,69,126), Type.FIRE, Type.FLYING, null, Ability.KEEN_EYE);
		Talonflame.setNature(Nature.RELAXED);
		
		Move[] moveset2 = new Move[4];
		moveset2[0] = Move.EARTHQUAKE;
		moveset2[1] = Move.SWORDS_DANCE;
		moveset2[2] = Move.BITE;
		moveset2[3] = Move.SCREECH;
		Pokemon Garchomp = new Pokemon(445, "Garchomp", 66, new Stats(108,130,95,80,85,102), Type.DRAGON, Type.GROUND, moveset2, Ability.SAND_VEIL);
		Garchomp.setNature(Nature.ADAMANT);
		Garchomp.setIvs(new Stats(24,12,30,16,23,5));
		Garchomp.setEvs(new Stats(74,190,91,48,84,23));
		
		Move[] moveset3 = new Move[4];
		moveset3[0] = Move.DISCHARGE;
		moveset3[1] = Move.QUICK_ATTACK;
		moveset3[2] = Move.THUNDER_SHOCK;
		moveset3[3] = Move.STUN_SPORE;
		
		Pokemon Pikachu = new Pokemon(25, "Pikachu", 80 ,new Stats(35,55,40,50,50,90), Type.ELECTRIC, null, moveset3, Ability.STATIC);
		Pikachu.setNature(Nature.HARDY);
		
		System.out.println("Garchomp Starting HP: "+Garchomp.getHp());
		System.out.println("Pikachu Starting HP: "+Pikachu.getHp());
		battleTurn(Garchomp, Garchomp.getMoves()[1], Pikachu, Pikachu.getMoves()[3]);		
		System.out.println("Garchomp Ending HP: "+Garchomp.getHp());
		System.out.println("Pikachu Ending HP: "+Pikachu.getHp());
		battleTurn(Garchomp, Garchomp.getMoves()[0], Pikachu, Pikachu.getMoves()[0]);
		System.out.println("Garchomp Ending HP: "+Garchomp.getHp());
		System.out.println("Pikachu Ending HP: "+Pikachu.getHp());
	}
}

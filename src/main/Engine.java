package main;

public class Engine {	
	public static void main(String[] args) {
		Move[] moveset = new Move[4];
		moveset[0] = Move.ICE_BEAM;
		moveset[1] = Move.TAIL_GLOW;
		moveset[2] = Move.ACID_ARMOR;
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
		System.out.println("Manaphy Starting HP: "+Manaphy.getHp());
		BattleUtils.battleTurn(Garchomp, Garchomp.getMoves()[1], Manaphy, Manaphy.getMoves()[2]);		
		System.out.println("Garchomp Ending HP: "+Garchomp.getHp());
		System.out.println("Manaphy Ending HP: "+Manaphy.getHp());
		BattleUtils.battleTurn(Garchomp, Garchomp.getMoves()[0], Manaphy, Manaphy.getMoves()[0]);
		System.out.println("Garchomp Ending HP: "+Garchomp.getHp());
		System.out.println("Manaphy Ending HP: "+Manaphy.getHp());
	}
}

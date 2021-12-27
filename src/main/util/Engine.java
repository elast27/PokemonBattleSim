package main.util;

import main.item.Berry;
import main.move.Move;
import main.move.Moveset;
import main.pokemon.Ability;
import main.pokemon.Nature;
import main.pokemon.Pokemon;
import main.pokemon.Stats;
import main.pokemon.Type;

public class Engine {	
	public static Pair<Pokemon,Pokemon> setup() {
		Pokemon Manaphy = new Pokemon(490, "Manaphy", 52, new Stats(100,100,100,100,100,100), Type.WATER, null, new Moveset(Move.ICE_BEAM, Move.TAIL_GLOW, Move.ACID_ARMOR, Move.BUBBLE_BEAM), Ability.HYDRATION);
		Manaphy.setEvs(new Stats(20,0,5,100,0,130));
		Manaphy.setIvs(new Stats(15,15,15,15,15,15));
		Manaphy.setNature(Nature.RASH);
		
		Pokemon Talonflame = new Pokemon(663, "Talonflame", 45, new Stats(78,81,71,74,69,126), Type.FIRE, Type.FLYING, null, Ability.KEEN_EYE);
		
		Pokemon Garchomp = new Pokemon(445, "Garchomp", 66, new Stats(108,130,95,80,85,102), Type.DRAGON, Type.GROUND, new Moveset(Move.BITE, Move.SWORDS_DANCE, Move.EARTHQUAKE, Move.SCREECH), Ability.SAND_VEIL);
		Garchomp.setNature(Nature.ADAMANT);
		Garchomp.setIvs(new Stats(24,12,30,16,23,5));
		Garchomp.setEvs(new Stats(74,190,91,48,84,23));
		Garchomp.setHeldItem(Berry.YACHE_BERRY);
		
		Pokemon Pikachu = new Pokemon(25, "Pikachu", 100 ,new Stats(35,55,40,50,50,90), Type.ELECTRIC, null, new Moveset(Move.GROWL, Move.QUICK_ATTACK), Ability.STATIC);
		
		Pokemon Toxicroak = new Pokemon(454, "Toxicroak", 80, new Stats(83,106,65,86,65,85), Type.POISON, Type.FIGHTING, new Moveset(Move.TOXIC, Move.QUICK_ATTACK, Move.EARTHQUAKE, Move.LEER), Ability.HYDRATION);
		return new Pair<>(Manaphy, Garchomp);
	}
}

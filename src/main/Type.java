package main;

import java.util.ArrayList;

public class Type {
	private String type;
	private ArrayList<String> resistant;
	private ArrayList<String> weak;
	private ArrayList<String> strong;
	private String noEffect;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<String> getResistant() {
		return resistant;
	}
	public void setResistant(ArrayList<String> resistant) {
		this.resistant = resistant;
	}
	public ArrayList<String> getWeak() {
		return weak;
	}
	public void setWeak(ArrayList<String> weak) {
		this.weak = weak;
	}
	public ArrayList<String> getStrong() {
		return strong;
	}
	public void setStrong(ArrayList<String> strong) {
		this.strong = strong;
	}
	public String getNoEffect() {
		return noEffect;
	}
	public void setNoEffect(String noEffect) {
		this.noEffect = noEffect;
	}
	
	public Type(String type) {
		super();
		this.type = type;
		this.noEffect = "";
	}
	
	public static ArrayList<Type> initTypes(){
		Type normal = new Type("Normal");
		Type flying = new Type("Flying");
		Type fighting = new Type("Fighting");
		Type electric = new Type("Electric");
		Type water = new Type("Water");
		Type fire = new Type("Fire");
		Type grass = new Type("Grass");
		Type rock = new Type("Rock");
		Type ground = new Type("Ground");
		Type steel = new Type("Steel");
		Type ice = new Type("Ice");
		Type psychic = new Type("Psychic");
		Type poison = new Type("Poison");
		Type dragon = new Type("Dragon");
		Type fairy = new Type("Fairy");
		Type bug = new Type("Bug");
		Type ghost = new Type("Ghost");
		Type dark = new Type("Dark");
		
		ArrayList<String> normalWeak = new ArrayList<>();
		normalWeak.add("Fighting");
		normal.setWeak(normalWeak);
		normal.setStrong(new ArrayList<>());
		normal.setResistant(new ArrayList<>());
		normal.setNoEffect("Ghost");
		
		ArrayList<String> flyingWeak = new ArrayList<>();
		flyingWeak.add("Electric");
		flyingWeak.add("Rock");
		flyingWeak.add("Ice");
		ArrayList<String> flyingStrong = new ArrayList<>();
		flyingStrong.add("Grass");
		flyingStrong.add("Bug");
		flyingStrong.add("Fighting");
		@SuppressWarnings("unchecked")
		ArrayList<String> flyingResist = (ArrayList<String>)flyingStrong.clone();
		flying.setResistant(flyingResist);
		flying.setStrong(flyingStrong);
		flying.setWeak(flyingWeak);
		
		ArrayList<String> fightingWeak = new ArrayList<>();
		fightingWeak.add("Flying");
		fightingWeak.add("Psychic");
		fightingWeak.add("Fairy");
		ArrayList<String> fightingStrong = new ArrayList<>();
		fightingStrong.add("Normal");
		fightingStrong.add("Ice");
		fightingStrong.add("Rock");
		fightingStrong.add("Dark");
		fightingStrong.add("Steel");
		ArrayList<String> fightingResist = new ArrayList<>();
		fightingResist.add("Bug");
		fightingResist.add("Dark");
		fightingResist.add("Rock");
		fighting.setResistant(fightingResist);
		fighting.setStrong(fightingStrong);
		fighting.setWeak(fightingWeak);
		fighting.setNoEffect("Ghost");
		
		ArrayList<String> elecWeak = new ArrayList<>();
		elecWeak.add("Ground");
		ArrayList<String> elecStrong = new ArrayList<>();
		elecStrong.add("Flying");
		elecStrong.add("Water");
		ArrayList<String> elecResist = new ArrayList<>();
		elecResist.add("Electric");
		elecResist.add("Flying");
		elecResist.add("Steel");
		electric.setWeak(elecWeak);
		electric.setStrong(elecStrong);
		electric.setResistant(elecResist);
		electric.setNoEffect("Ground");
		
		ArrayList<String> waterWeak = new ArrayList<>();
		ArrayList<String> waterStrong = new ArrayList<>();
		ArrayList<String> waterResist = new ArrayList<>();
		waterWeak.add("Grass");
		waterWeak.add("Electric");
		waterStrong.add("Fire");
		waterStrong.add("Ground");
		waterStrong.add("Rock");
		waterResist.add("Fire");
		waterResist.add("Water");
		waterResist.add("Ice");
		waterResist.add("Steel");
		water.setResistant(waterResist);
		water.setStrong(waterStrong);
		water.setWeak(waterWeak);
//		
//		Type[] fireWeak = {water, rock, ground};
//		Type[] fireStrong = {grass, bug, ice, steel};
//		Type[] fireResist = {fire, grass, ice, steel, fairy};
//		fire.setResistant(fireResist);
//		fire.setStrong(fireStrong);
//		fire.setWeak(fireWeak);
//		
//		Type[] grassWeak = {fire, poison, bug, flying, ice};
//		Type[] grassStrong = {water, ground, rock};
//		Type[] grassResist = {water, grass, electric, ground};
//		grass.setResistant(grassResist);
//		grass.setStrong(grassStrong);
//		grass.setWeak(grassWeak);
//		
//		Type[] rockWeak = {fighting, water, grass, ground, steel};
//		Type[] rockStrong = {flying, fire, ice, bug};
//		Type[] rockResist = {normal, fire, poison, flying};
//		rock.setResistant(rockResist);
//		rock.setStrong(rockStrong);
//		rock.setWeak(rockWeak);
		
		ArrayList<String> groundWeak = new ArrayList<>();
		groundWeak.add("Water");
		groundWeak.add("Grass");
		groundWeak.add("Ice");
		ArrayList<String> groundStrong = new ArrayList<>();
		groundStrong.add("Fire");
		groundStrong.add("Electric");
		groundStrong.add("Poison");
		groundStrong.add("Rock");
		groundStrong.add("Steel");
		ArrayList<String> groundResist = new ArrayList<>();
		groundResist.add("Poison");
		groundResist.add("Rock");
		ground.setNoEffect("Flying");
		ground.setResistant(groundResist);
		ground.setStrong(groundStrong);
		ground.setWeak(groundWeak);
		
//		Type[] iceWeak = {fighting, fire, rock, steel};
//		Type[] iceStrong = {flying, grass, ground, dragon};
//		Type[] iceResist = {ice};
//		ice.setResistant(iceResist);
//		ice.setStrong(iceStrong);
//		ice.setWeak(iceWeak);
//		
//		Type[] steelWeak = {ground, fire, fighting};
//		Type[] steelStrong = {ice, rock, fairy};
//		Type[] steelResist = {normal, grass, ice, flying, psychic, bug, rock, dragon, steel, fairy};
//		steel.setResistant(steelResist);
//		steel.setStrong(steelStrong);
//		steel.setWeak(steelWeak);
		
		ArrayList<String> dragonWeak = new ArrayList<>();
		ArrayList<String> dragonStrong = new ArrayList<>();
		ArrayList<String> dragonResist = new ArrayList<>();
		dragonWeak.add("Dragon");
		dragonWeak.add("Ice");
		dragonWeak.add("Fairy");
		dragonStrong.add("Dragon");
		dragonResist.add("Water");
		dragonResist.add("Fire");
		dragonResist.add("Grass");
		dragonResist.add("Electric");
		dragon.setNoEffect("Fairy");
		dragon.setResistant(dragonResist);
		dragon.setStrong(dragonStrong);
		dragon.setWeak(dragonWeak);
		
//		Type[] fairyWeak = {poison, steel};
//		Type[] fairyStrong = {dragon, fighting, dark};
//		Type[] fairyResist = {fighting, bug, dark};
//		fairy.setResistant(fairyResist);
//		fairy.setStrong(fairyStrong);
//		fairy.setWeak(fairyWeak);
//		
//		Type[] bugWeak = {fire, flying, rock};
//		Type[] bugStrong = {grass, psychic, dark};
//		Type[] bugResist = {grass, fighting, ground};
//		bug.setResistant(bugResist);
//		bug.setStrong(bugStrong);
//		bug.setWeak(bugWeak);
//		
//		Type[] darkWeak = {fighting, bug, fairy};
//		Type[] darkStrong = {psychic, ghost};
//		Type[] darkResist = {ghost, dark};
//		dark.setResistant(darkResist);
//		dark.setStrong(darkStrong);
//		dark.setWeak(darkWeak);
//		
//		Type[] ghostWeak = {ghost, dark};
//		Type[] ghostStrong = {ghost, psychic};
//		Type[] ghostResist = {poison, bug};
//		ghost.setNoEffect(normal);
//		ghost.setResistant(ghostResist);
//		ghost.setStrong(ghostStrong);
//		ghost.setWeak(ghostWeak);
//		
//		Type[] poisonWeak = {ground, psychic};
//		Type[] poisonStrong = {grass, fairy};
//		Type[] poisonResist = {grass, fighting, poison, bug, fairy};
//		poison.setNoEffect(steel);
//		poison.setResistant(poisonResist);
//		poison.setStrong(poisonStrong);
//		poison.setWeak(poisonWeak);
//		
//		Type[] psyWeak = {dark, bug, ghost};
//		Type[] psyStrong = {fighting, poison};
//		Type[] psyResist = {fighting, psychic};
//		psychic.setNoEffect(dark);
//		psychic.setResistant(psyResist);
//		psychic.setStrong(psyStrong);
//		psychic.setWeak(psyWeak);
		
		ArrayList<Type> types = new ArrayList<>();
		types.add(normal);
		types.add(fighting);
		types.add(flying);
		types.add(electric);
		types.add(fire);
		types.add(water);
		types.add(grass);
		types.add(ice);
		types.add(steel);
		types.add(psychic);
		types.add(ghost);
		types.add(dark);
		types.add(bug);
		types.add(dragon);
		types.add(fairy);
		types.add(poison);
		types.add(ground);
		types.add(rock);
		return types;
	}
	public static ArrayList<Type> types = initTypes();
	public static final Type NORMAL = types.get(0);
	public static final Type FIGHTING = types.get(1);
	public static final Type FLYING = types.get(2);
	public static final Type ELECTRIC = types.get(3);
	public static final Type FIRE = types.get(4);
	public static final Type WATER = types.get(5);
	public static final Type GRASS = types.get(6);
	public static final Type ICE = types.get(7);
	public static final Type STEEL = types.get(8);
	public static final Type PSYCHIC = types.get(9);
	public static final Type GHOST = types.get(10);
	public static final Type DARK = types.get(11);
	public static final Type BUG = types.get(12);
	public static final Type DRAGON = types.get(13);
	public static final Type FAIRY = types.get(14);
	public static final Type POISON = types.get(15);
	public static final Type GROUND = types.get(16);
	public static final Type ROCK = types.get(17);
	
}

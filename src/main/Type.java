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
		ArrayList<String> flyingResist = new ArrayList<>();
		flyingResist.addAll(flyingStrong);
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
		
		ArrayList<String> fireWeak = new ArrayList<>();
		ArrayList<String> fireStrong = new ArrayList<>();
		ArrayList<String> fireResist = new ArrayList<>();
		fireWeak.add("Water");
		fireWeak.add("Rock");
		fireWeak.add("Ground");
		fireStrong.add("Grass");
		fireStrong.add("Bug");
		fireStrong.add("Ice");
		fireStrong.add("Steel");
		fireResist.add("Fire");
		fireResist.add("Grass");
		fireResist.add("Ice");
		fireResist.add("Steel");
		fireResist.add("Fairy");
		fire.setResistant(fireResist);
		fire.setStrong(fireStrong);
		fire.setWeak(fireWeak);
		
		ArrayList<String> grassWeak = new ArrayList<>();
		ArrayList<String> grassStrong = new ArrayList<>();
		ArrayList<String> grassResist = new ArrayList<>();
		grassWeak.add("Fire");
		grassWeak.add("Poison");
		grassWeak.add("Bug");
		grassWeak.add("Flying");
		grassWeak.add("Ice");
		grassStrong.add("Water");
		grassStrong.add("Ground");
		grassStrong.add("Rock");
		grassResist.add("Water");
		grassResist.add("Grass");
		grassResist.add("Electric");
		grassResist.add("Ground");
		grass.setResistant(grassResist);
		grass.setStrong(grassStrong);
		grass.setWeak(grassWeak);
	
		ArrayList<String> rockWeak = new ArrayList<>();
		ArrayList<String> rockStrong = new ArrayList<>();
		ArrayList<String> rockResist = new ArrayList<>();
		rockWeak.add("Fighting");
		rockWeak.add("Water");
		rockWeak.add("Grass");
		rockWeak.add("Ground");
		rockWeak.add("Steel");
		rockStrong.add("Flying");
		rockStrong.add("Fire");
		rockStrong.add("Ice");
		rockStrong.add("Bug");
		rockResist.add("Normal");
		rockResist.add("Fire");
		rockResist.add("Poison");
		rockResist.add("Flying");
		rock.setResistant(rockResist);
		rock.setStrong(rockStrong);
		rock.setWeak(rockWeak);
		
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
		
		ArrayList<String> iceWeak = new ArrayList<>();
		ArrayList<String> iceStrong = new ArrayList<>();
		ArrayList<String> iceResist = new ArrayList<>();
		iceWeak.add("Fighting");
		iceWeak.add("Fire");
		iceWeak.add("Rock");
		iceWeak.add("Steel");
		iceStrong.add("Flying");
		iceStrong.add("Grass");
		iceStrong.add("Ground");
		iceStrong.add("Dragon");
		iceResist.add("Ice");
		ice.setResistant(iceResist);
		ice.setStrong(iceStrong);
		ice.setWeak(iceWeak);
		
		ArrayList<String> steelWeak = new ArrayList<>();
		ArrayList<String> steelStrong = new ArrayList<>();
		ArrayList<String> steelResist = new ArrayList<>();
		steelWeak.add("Ground");
		steelWeak.add("Fire");
		steelWeak.add("Fighting");
		steelStrong.add("Ice");
		steelStrong.add("Rock");
		steelStrong.add("Fairy");
		steelResist.addAll(steelStrong);
		steelResist.add("Normal");
		steelResist.add("Grass");
		steelResist.add("Flying");
		steelResist.add("Psychic");
		steelResist.add("Bug");
		steelResist.add("Dragon");
		steelResist.add("Steel");
		steel.setResistant(steelResist);
		steel.setStrong(steelStrong);
		steel.setWeak(steelWeak);
		
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
		
		ArrayList<String> fairyWeak = new ArrayList<>();
		ArrayList<String> fairyStrong = new ArrayList<>();
		ArrayList<String> fairyResist = new ArrayList<>();
		fairyWeak.add("Poison");
		fairyWeak.add("Steel");
		fairyStrong.add("Dragon");
		fairyStrong.add("Fighting");
		fairyStrong.add("Dark");
		fairyResist.add("Fighting");
		fairyResist.add("Bug");
		fairyResist.add("Dark");
		fairy.setResistant(fairyResist);
		fairy.setStrong(fairyStrong);
		fairy.setWeak(fairyWeak);

		ArrayList<String> bugWeak = new ArrayList<>();
		ArrayList<String> bugStrong = new ArrayList<>();
		ArrayList<String> bugResist = new ArrayList<>();
		bugWeak.add("Fire");
		bugWeak.add("Flying");
		bugWeak.add("Rock");
		bugStrong.add("Grass");
		bugStrong.add("Psychic");
		bugStrong.add("Dark");
		bugResist.add("Grass");
		bugResist.add("Fighting");
		bugResist.add("Ground");
		bug.setResistant(bugResist);
		bug.setStrong(bugStrong);
		bug.setWeak(bugWeak);
		
		ArrayList<String> darkWeak = new ArrayList<>();
		ArrayList<String> darkStrong = new ArrayList<>();
		ArrayList<String> darkResist = new ArrayList<>();
		darkWeak.add("Fighting");
		darkWeak.add("Bug");
		darkWeak.add("Fairy");
		darkStrong.add("Psychic");
		darkStrong.add("Ghost");
		darkResist.add("Ghost");
		darkResist.add("Dark");
		dark.setResistant(darkResist);
		dark.setStrong(darkStrong);
		dark.setWeak(darkWeak);
	
		ArrayList<String> ghostWeak = new ArrayList<>();
		ArrayList<String> ghostStrong = new ArrayList<>();
		ArrayList<String> ghostResist = new ArrayList<>();
		ghostWeak.add("Ghost");
		ghostWeak.add("Dark");
		ghostStrong.add("Ghost");
		ghostStrong.add("Psychic");
		ghostResist.add("Poison");
		ghostResist.add("Bug");
		ghost.setNoEffect("Normal");
		ghost.setResistant(ghostResist);
		ghost.setStrong(ghostStrong);
		ghost.setWeak(ghostWeak);
		
		ArrayList<String> poisonWeak = new ArrayList<>();
		ArrayList<String> poisonStrong = new ArrayList<>();
		ArrayList<String> poisonResist = new ArrayList<>();
		poisonWeak.add("Ground");
		poisonWeak.add("Psychic");
		poisonStrong.add("Grass");
		poisonStrong.add("Fairy");
		poisonResist.addAll(poisonStrong);
		poisonResist.add("Fighting");
		poisonResist.add("Poison");
		poisonResist.add("Bug");
		poison.setNoEffect("Steel");
		poison.setResistant(poisonResist);
		poison.setStrong(poisonStrong);
		poison.setWeak(poisonWeak);
		
		ArrayList<String> psyWeak = new ArrayList<>();
		ArrayList<String> psyStrong = new ArrayList<>();
		ArrayList<String> psyResist = new ArrayList<>();
		psyWeak.add("Dark");
		psyWeak.add("Bug");
		psyWeak.add("Ghost");
		psyStrong.add("Fighting");
		psyStrong.add("Poison");
		psyResist.add("Fighting");
		psyResist.add("Psychic");
		psychic.setNoEffect("Dark");
		psychic.setResistant(psyResist);
		psychic.setStrong(psyStrong);
		psychic.setWeak(psyWeak);
		
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

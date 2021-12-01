package main;

import java.util.HashMap;

public class Pokemon {
	private int id;
	private int hp;
	private String name;
	private Stats stats;
	private Stats ivs;
	private Stats evs;
	private Nature nature;
	private Type type1;
	private Type type2;
	private Move[] moves;
	private Ability ability;
	private int xp;
	private int xpToNext;
	private int lvl;
	private HashMap<String, Integer> stageMult = new HashMap<>();
	private Item heldItem;
		
	public Item getHeldItem() {
		return heldItem;
	}
	public void setHeldItem(Item heldItem) {
		this.heldItem = heldItem;
	}
	public HashMap<String, Integer> getStageMult() {
		return stageMult;
	}
	public int getStageMult(String stat) {
		return stageMult.get(stat);
	}
	public void setStageMult(String stat, int value) {
		stageMult.put(stat, value);
	}
	public void addStageMult(String stat, int value) {
		stageMult.put(stat, stageMult.get(stat)+value);
	}

	public Pokemon(int id) {
		super();
		this.id = id;
		this.name = "";
		this.stats = null;
		this.type1 = null;
		this.type2 = null;
		this.moves = new Move[4];
		this.ability = null;
		this.lvl = 1;
		this.xp = 0;
		this.xpToNext = (int)Math.floor(Math.pow(this.lvl, 3));
		this.stageMult.put("atk", 0);
		this.stageMult.put("def", 0);
		this.stageMult.put("spa", 0);
		this.stageMult.put("spd", 0);
		this.stageMult.put("spe", 0);
		this.hp = 1;
	}

	public Pokemon(int id, String name, int lvl, Stats stats, Type type1, Type type2, Move[] moves, Ability ability) {
		super();
		this.id = id;
		this.name = name;
		this.stats = stats;
		this.type1 = type1;
		this.type2 = type2;
		this.moves = moves;
		this.ability = ability;
		this.lvl = lvl;
		this.xp = 0;
		this.xpToNext = (int)Math.floor(Math.pow(this.lvl, 3));
		this.stageMult.put("atk", 0);
		this.stageMult.put("def", 0);
		this.stageMult.put("spa", 0);
		this.stageMult.put("spd", 0);
		this.stageMult.put("spe", 0);
		this.hp = 1;
	}
	
	public int getId() {
		return id;
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public Type getType1() {
		return type1;
	}

	public void setType1(Type type1) {
		this.type1 = type1;
	}

	public Type getType2() {
		return type2;
	}

	public void setType2(Type type2) {
		this.type2 = type2;
	}

	public Move[] getMoves() {
		return moves;
	}

	public void setMoves(Move[] moves) {
		this.moves = moves;
	}
	
	public void addMove(Move move, int idx) {
		this.moves[idx] = move;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	public Stats getIvs() {
		return ivs;
	}

	public void setIvs(Stats ivs) {
		this.ivs = ivs;
	}

	public Stats getEvs() {
		return evs;
	}

	public void setEvs(Stats evs) {
		this.evs = evs;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getXpToNext() {
		return xpToNext;
	}

	public void setXpToNext(int xpToNext) {
		this.xpToNext = xpToNext;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	
	public double getStat(String stat) {
		return Stats.getStat(this, stat);
	}
}

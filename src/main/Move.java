package main;

public class Move {
	private String name;
	private Type type;
	private int power;
	private int acc;
	private int pp;
	private DamageType damageType;
	private String desc;
	
	
	public enum DamageType{PHYSICAL, SPECIAL, STATUS}
	
	final static Move THUNDER_SHOCK = new EffectMove("Thunder Shock", Type.ELECTRIC, 40, 100, 20,DamageType.SPECIAL, "desc", p->p.setParalysis(0.1));
	final static Move DISCHARGE = new EffectMove("Discharge", Type.ELECTRIC, 80, 100, 15, DamageType.SPECIAL, "desc", p->p.setParalysis(0.3));
	final static Move STUN_SPORE = new EffectMove("Stun Spore", Type.GRASS, 0, 75, 30, DamageType.STATUS, "desc", p->p.setParalysis(1));
	final static Move QUICK_ATTACK = new Move("Quick Attack", Type.NORMAL, 40, 100, 30, DamageType.PHYSICAL, "desc");
	final static Move ICE_BEAM = new Move("Ice Beam", Type.ICE, 80, 100, 15, DamageType.SPECIAL, "desc");
	final static Move EARTHQUAKE = new Move("Earthquake", Type.GROUND, 100, 100, 15, DamageType.PHYSICAL, "desc");
	final static Move SWORDS_DANCE = new StatusMove("Swords Dance", Type.NORMAL, 0, 100, 10, DamageType.STATUS, "desc", p->p.addStageMult("atk", 2), true);
	final static Move TAIL_GLOW = new StatusMove("Tail Glow", Type.BUG, 0, 100, 10, DamageType.STATUS, "desc", p->p.addStageMult("spa", 3), true);
	final static Move LEER = new StatusMove("Leer", Type.NORMAL, 0, 100, 40, DamageType.STATUS, "desc", p->p.addStageMult("def", -1), false);
	final static Move SCREECH = new StatusMove("Screech", Type.NORMAL, 0, 100, 10, DamageType.STATUS, "desc", p->p.addStageMult("def", -2), false);
	final static Move BITE = new EffectMove("Bite", Type.DARK, 60,100,25,DamageType.PHYSICAL,"desc", p->p.setFlinched(0.3));
	
	public Move(String name, Type type, int power, int acc, int pp, DamageType damageType, String desc) {
		super();
		this.name = name;
		this.type = type;
		this.power = power;
		this.acc = acc;
		this.pp = pp;
		this.damageType = damageType;
		this.desc = desc;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getAcc() {
		return acc;
	}
	public void setAcc(int acc) {
		this.acc = acc;
	}
	public int getPP() {
		return pp;
	}
	public void setPP(int pp) {
		this.pp = pp;
	}	
	public DamageType getDamageType() {
		return damageType;
	}
	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}

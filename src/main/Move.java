package main;

public class Move {
	private String name;
	private Type type;
	private int power;
	private int acc;
	private DamageType damageType;
	private String desc;
	
	public enum DamageType{PHYSICAL, SPECIAL, STATUS}
	
	final static Move THUNDER_SHOCK = new Move("Thunder Shock", Type.ELECTRIC, 40, 100, DamageType.SPECIAL, "desc");
	final static Move DISCHARGE = new Move("Discharge", Type.ELECTRIC, 80, 100, DamageType.SPECIAL, "desc");
	final static Move QUICK_ATTACK = new Move("Quick Attack", Type.NORMAL, 40, 100, DamageType.PHYSICAL, "desc");
	final static Move ICE_BEAM = new Move("Ice Beam", Type.ICE, 80, 100, DamageType.SPECIAL, "desc");
	final static Move EARTHQUAKE = new Move("Earthquake", Type.GROUND, 100, 100, DamageType.PHYSICAL, "desc");
	
	public Move(String name, Type type, int power, int acc, DamageType damageType, String desc) {
		super();
		this.name = name;
		this.type = type;
		this.power = power;
		this.acc = acc;
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

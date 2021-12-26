package main;

public class Berry extends Item {
	BerryEffect effect;
	String desc;
	public Berry() {
		super();
	}
	public Berry(String name, String desc, BerryEffect e) {
		super(name, desc);
		this.effect = e;
	}
	public static final Berry YACHE_BERRY = new SuperEffectiveBerry("Yache Berry", "Reduces an Ice Move", m->{
		if(m.getType().getType().equals("Ice")) return true;
		else return false;
	});
	
	public BerryEffect getEffect() {
		return this.effect;
	}
}

package main.item;

import main.pokemon.Stat;

public class Berry extends Item {
	public Berry() {
		super();
	}
	public Berry(String name, String desc, ItemEffect e) {
		super(name, desc, e);
	}
	public static final Berry YACHE_BERRY = new SuperEffectiveBerry("Yache Berry", "Reduces an Ice Move", m->{
		if(m.getType().getType().equals("Ice")) return true;
		else return false;
	});
	
	public static final HealBerry SITRUS_BERRY = new HealBerry("Sitrus Berry", "Heals 25% once HP falls below 50%", p->{
		if(p.getHp() < p.getStat(Stat.HP)/2) return 0.25;
		else return 0;
	});
	public static final HealBerry ORAN_BERRY = new HealBerry("Oran Berry", "Heals 10HP once HP falls below 50%", p->{
		if(p.getHp() < p.getStat(Stat.HP)/2) return 10;
		else return 0;
	});
}

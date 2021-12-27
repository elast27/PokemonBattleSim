package main.item;

import lombok.Getter;
import main.pokemon.Pokemon;

@Getter
public class HealBerry extends Berry{
	HealBerryEffect berryeffect;
	@FunctionalInterface
	public interface HealBerryEffect{
		double apply(Pokemon p);
	}
	
	public HealBerry(String name, String desc, HealBerryEffect e) {
		super();
		this.name = name;
		this.desc = desc;
		this.berryeffect = e;
	}
}

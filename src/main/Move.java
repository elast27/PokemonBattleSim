package main;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Move {
	private @NonNull String name;
	private @NonNull Type type;
	private int power;
	private int acc;
	private int pp;
	private @NonNull DamageType damageType;
	private @NonNull String desc;
	private int priority;
	
	
	public enum DamageType{PHYSICAL, SPECIAL, STATUS}
	
	final static Move THUNDER_SHOCK = new EffectMove("Thunder Shock", Type.ELECTRIC, 40, 100, 30,DamageType.SPECIAL, "A jolt of electricity crashes down on the target to inflict damage. This may also leave the target with paralysis.", p->p.setParalysis(0.1));
	final static Move DISCHARGE = new EffectMove("Discharge", Type.ELECTRIC, 80, 100, 15, DamageType.SPECIAL, "The user strikes everything around it by letting loose a flare of electricity. This may also cause paralysis.", p->p.setParalysis(0.3));
	final static Move STUN_SPORE = new EffectMove("Stun Spore", Type.GRASS, 0, 75, 30, DamageType.STATUS, "The user scatters a cloud of numbing powder that paralyzes the target.", p->p.setParalysis(1));
	final static Move QUICK_ATTACK = new Move("Quick Attack", Type.NORMAL, 40, 100, 30, DamageType.PHYSICAL, "The user lunges at the target at a speed that makes it almost invisible. This move always goes first.", 1);
	final static Move ICE_BEAM = new EffectMove("Ice Beam", Type.ICE, 90, 100, 15, DamageType.SPECIAL, "The target is struck with an icy-cold beam of energy. This may also leave the target frozen.",p->p.setFrozen(0.1));
	final static Move EARTHQUAKE = new Move("Earthquake", Type.GROUND, 100, 100, 15, DamageType.PHYSICAL, "The user sets off an earthquake that strikes every Pokémon around it.");
	final static Move SWORDS_DANCE = new StatusMove("Swords Dance", Type.NORMAL, 0, 100, 10, DamageType.STATUS, "A frenetic dance to uplift the fighting spirit. This sharply raises the user's Attack stat.", p->p.addStageMult(Stat.ATK, 2), true);
	final static Move TAIL_GLOW = new StatusMove("Tail Glow", Type.BUG, 0, 100, 10, DamageType.STATUS, "The user stares at flashing lights to focus its mind, drastically raising its Sp. Atk stat.", p->p.addStageMult(Stat.SPA, 3), true);
	final static Move LEER = new StatusMove("Leer", Type.NORMAL, 0, 100, 40, DamageType.STATUS, "The user gives opposing Pokémon an intimidating leer that lowers the Defense stat.", p->p.addStageMult(Stat.DEF, -1), false);
	final static Move SCREECH = new StatusMove("Screech", Type.NORMAL, 0, 100, 10, DamageType.STATUS, "An earsplitting screech is emitted to sharply reduce the foe's Defense stat.", p->p.addStageMult(Stat.DEF, -2), false);
	final static Move BITE = new EffectMove("Bite", Type.DARK, 60,100,25,DamageType.PHYSICAL,"The target is bitten with viciously sharp fangs. This may also make the target flinch.", p->p.setFlinched(0.3));
	final static Move ACID_ARMOR = new StatusMove("Acid Armor", Type.POISON, 0, 100, 10, DamageType.STATUS, "The user alters its cellular structure to liquefy itself, sharply raising its Defense stat.", p->p.addStageMult(Stat.DEF, 2), true);
	final static Move GROWL = new StatusMove("Growl", Type.NORMAL, 0, 100, 40, DamageType.STATUS, "The user growls in an endearing way, making opposing Pokémon less wary. This lowers their Attack stats.", p->p.addStageMult(Stat.ATK, -1), false);
	final static Move BUBBLE_BEAM = new EffectMove("Bubble Beam", Type.WATER, 65, 100, 20, DamageType.SPECIAL, "A spray of bubbles is forcefully ejected at the target. This may also lower its Speed stat.", p->p.addStageMult(Stat.SPE, -1, 0.1));
	final static Move CHARGE = new StatusMove("Charge", Type.ELECTRIC, 0, 100, 20, DamageType.STATUS, "The user boosts the power of the Electric move it uses next. It also raises the user's Sp. Def stat.", p->p.addStageMult(Stat.SPA, 1), true);
	final static Move TOXIC = new EffectMove("Toxic", Type.POISON, 0, 90, 10, DamageType.STATUS, "A move that leaves the target badly poisoned. Its poison damage worsens every turn", p->p.setBadPoison(1));
	final static Move EMBER = new EffectMove("Ember", Type.FIRE, 40, 100, 20, DamageType.SPECIAL,"desc", p->p.setBurn(0.2));
	
	public Move(String name, Type type, int power, int acc, int pp, DamageType damageType, String desc) {
		super();
		this.name = name;
		this.type = type;
		this.power = power;
		this.acc = acc;
		this.pp = pp;
		this.damageType = damageType;
		this.desc = desc;
		this.priority = 0;
	}
	
	public Move(String name, Type type, int power, int acc, int pp, DamageType damageType, String desc, int priority) {
		this(name,type,power,acc,pp,damageType,desc);
		this.priority = priority;
	}
}

package main;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;
import main.Move.DamageType;

@Getter
@Setter
public class Pokemon {
	private enum Condition{FREEZE(0), BURN(0), SLEEP(0), PARALYZE(0), POISON(0), BAD_POISON(1);
		private int n;
		private Condition(int n) {
			this.n = n;
		}
		};
	private int id;
	private int hp;
	private String name;
	private Stats stats;
	private Stats ivs;
	private Stats evs;
	private Nature nature;
	private Type type1;
	private Type type2;
	private Moveset moves;
	private Ability ability;
	private int xp;
	private int xpToNext;
	private int lvl;
	private HashMap<Stat, Integer> stageMult = new HashMap<>();
	private Item heldItem;
	boolean isFlinched = false;
	Condition condition = null;
		
	public int getStageMult(Stat stat) {
		return stageMult.get(stat);
	}
	public void setStageMult(Stat stat, int value) {
		stageMult.put(stat, value);
	}
	public void addStageMult(Stat stat, int value, double r) {
		double p = Math.random();
		if(p<r) this.addStageMult(stat, value);
	}
	public void addStageMult(Stat stat, int value) {
		stageMult.put(stat, stageMult.get(stat)+value);
		String msg = this.getName()+"'s ";
		switch(stat) {
		case ATK:
			msg+="attack ";
			break;
		case DEF:
			msg+="defense ";
			break;
		case SPA:
			msg+="special attack ";
			break;
		case SPD:
			msg+="special defense ";
			break;
		case SPE:
			msg+="speed ";
			break;
		case ACC:
			msg+="accuracy ";
			break;
		case EVA:
			msg+="evasiveness ";
			break;
		case HP: break;
		}
		if (stageMult.get(stat)>6) {
			msg+="won't go any higher!";
			stageMult.put(stat, 6);
			System.out.println(msg);
			return;
		} else if (stageMult.get(stat)<-6) {
			msg+="won't go any lower!";
			stageMult.put(stat, -6);
			System.out.println(msg);
			return;
		}
		switch(value) {
		case(-3):
			msg+="drastically fell!";
			break;
		case(-2):
			msg+="harshly fell!";
			break;
		case(-1):
			msg+="fell.";
			break;
		case(1):
			msg+="rose.";
			break;
		case(2):
			msg+="sharply rose!";
			break;
		case(3):
			msg+="drastically rose!";
			break;
		}
		System.out.println(msg);
	}

	public Pokemon(int id) {
		this(id, "", 1, new Stats(0,0,0,0,0,0), null, null, null, null);
	}

	public Pokemon(int id, String name, int lvl, Stats stats, Type type1, Type type2, Moveset moves, Ability ability) {
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
		this.stageMult.put(Stat.ATK, 0);
		this.stageMult.put(Stat.DEF, 0);
		this.stageMult.put(Stat.SPA, 0);
		this.stageMult.put(Stat.SPD, 0);
		this.stageMult.put(Stat.SPE, 0);
		this.stageMult.put(Stat.ACC, 0);
		this.stageMult.put(Stat.EVA, 0);
		this.setEvs(new Stats(0,0,0,0,0,0));
		this.setIvs(new Stats(0,0,0,0,0,0));
		this.hp = (int)getStat(Stat.HP);
		this.nature = Nature.HARDY;
	}
	
	public Move getMove(int idx) {
		return this.moves.getMove(idx);
	}

	public void setIvs(Stats ivs) {
		this.ivs = ivs;
		if(this.evs!=null) this.hp=(int)this.getStat(Stat.HP);
	}

	public void setEvs(Stats evs) {
		this.evs = evs;
		if(this.ivs!=null) this.hp=(int)this.getStat(Stat.HP);
	}
	
	public double getStat(Stat stat) {
		return Stats.getStat(this, stat);
	}
	
	public void setStat(Stat stat, int value) {
		Stats s = this.getStats();
		switch(stat) {
		case HP:
			s.setHp(value);
			break;
		case ATK:
			s.setAtk(value);
			break;
		case DEF:
			s.setDef(value);
			break;
		case SPA:
			s.setSpa(value);
			break;
		case SPD:
			s.setSpd(value);
			break;
		case SPE:
			s.setSpe(value);
			break;
		}
	}
	
	public void addEv(Stat stat, int value) {
		Stats s = this.getEvs();
		int v;
		switch(stat) {
		case HP:
			v = s.getHp();
			s.setHp(v + value);
			break;
		case ATK:
			v = s.getAtk();
			s.setAtk(v + value);
			break;
		case DEF:
			v = s.getDef();
			s.setDef(v + value);
			break;
		case SPA:
			v = s.getSpa();
			s.setSpa(v + value);
			break;
		case SPD:
			v = s.getSpd();
			s.setSpd(v + value);
			break;
		case SPE:
			v = s.getSpe();
			s.setSpe(v + value);
			break;
		}
	}
	
	public void setFlinched(double prob) {
		double r = Math.random();
		if(r < prob) this.isFlinched=true;
	}
	
	public void setParalysis(double prob) {
		double r = Math.random();
		if(r < prob && this.condition==null) {
			this.condition=Condition.PARALYZE;
			System.out.println(this.getName()+" was paralyzed! It may be unable to move.");
			this.setStat(Stat.SPE, (int)this.getStat(Stat.SPE)/2);
		}
		else if (r < prob) System.out.println(this.getName()+" is already paralyzed.");
	}
	
	public void setBurn(double prob) {
		double r = Math.random();
		if(r < prob && this.condition==null) {
			this.condition=Condition.BURN;
			System.out.println(this.getName()+" has been burned!");
			this.setStat(Stat.ATK, (int)this.getStat(Stat.ATK)/2);
		}
	}
	
	public void setFrozen(double prob) {
		if(this.getType1().getType().equals("Ice") || this.getType2().getType().equals("Ice")) return;
		double r = Math.random();
		if(r < prob && this.condition==null) {
			this.condition=Condition.FREEZE;
			System.out.println(this.getName()+" has been frozen solid!");
		}
	}
	
	public void setPoison(double prob) {
		
	}
	public void setBadPoison(double prob) {
		double r = Math.random();
		if(r < prob && this.condition==null) {
			this.condition=Condition.BAD_POISON;
			System.out.println(this.getName()+" was badly poisoned!");
		}
	}
	
	public void attack(Pokemon defender, Move move) {
		if(this.getHp()==0) return;
		if(this.isFlinched) {
			System.out.println(this.getName()+ " flinched and couldn't move!");
			this.isFlinched = false;
			return;
		}
		if(this.condition==Condition.PARALYZE) {
			double r = Math.random();
			if(r < .25) {
				System.out.println(this.getName()+" is paralyzed. It cannot move!");
				return;
			}
		}
		if(this.condition==Condition.FREEZE) {
			double r = Math.random();
			if(r < .20) {
				System.out.println(this.getName()+" thawed out!");
				this.condition = null;
			} else {
				System.out.println(this.getName()+" is frozen solid!");
				return;
			}
		}
		System.out.println(this.getName() + " used " + move.getName());
		if(BattleUtils.moveHits(this, defender, move)) {
			if(move.getDamageType()!=DamageType.STATUS) {
				double damage = BattleUtils.damageCalc(this, move, defender);
				defender.setHp((int)(defender.getHp()-damage));
				if(damage == 0) return;
				if(defender.getHp()<=0) {
					defender.setHp(0);
					System.out.println(defender.getName() + " fainted");
					defender.condition=null;
					return;
				}
				if(move.getType().equals(Type.FIRE) && defender.condition == Condition.FREEZE) {
					defender.condition = null;
					System.out.println(defender.getName()+" thawed out!");
				}
			}
			if(move instanceof StatusMove) {
				if(((StatusMove)move).getTarget()) ((StatusMove) move).getEffect().apply(this);
				else ((StatusMove) move).getEffect().apply(defender);
			}
			if(move instanceof EffectMove) {
				((EffectMove)move).getEffect().apply(defender);
			}
		} else {
			System.out.println(this.getName() + "'s attack missed!");
		}
	}
	
	public void conditionCheck() {
		if(this.condition == Condition.BURN) {
			double value = this.getStat(Stat.HP)/16f;
			this.setHp((int)(this.getHp()-value));
			System.out.println(this.getName()+" was hurt by its burn.");
		}
		if(this.condition == Condition.POISON) {
			double value = this.getStat(Stat.HP)/16f;
			this.setHp((int)(this.getHp()-value));
			System.out.println(this.getName()+" was damaged by poison.");
		}
		else if(this.condition == Condition.BAD_POISON) {
			double value = (this.getStat(Stat.HP) * this.condition.n++)/16f;
			this.setHp((int)(this.getHp()-value));
			System.out.println(this.getName()+" was damaged by poison.");
		}
		if(this.getHp()<=0) {
			this.setHp(0);
			System.out.println(this.getName()+" fainted.");
			this.condition=null;
		}
	}
}

package main;

public class Stats {
	private int hp;
	private int atk;
	private int def;
	private int spa;
	private int spd;
	private int spe;
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getSpa() {
		return spa;
	}
	public void setSpa(int spa) {
		this.spa = spa;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public int getSpe() {
		return spe;
	}
	public void setSpe(int spe) {
		this.spe = spe;
	}
	public Stats(int hp, int atk, int def, int spa, int spd, int spe) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.spa = spa;
		this.spd = spd;
		this.spe = spe;
	}
	
	public static double getStat(Pokemon p, Stat stat) {
		switch(stat) {
		case HP:
			return calculateHP(p, p.getStats().getHp(), p.getEvs().getHp(), p.getIvs().getHp());
		case ATK:
			return calculateStat(p, p.getStats().getAtk(), p.getEvs().getAtk(), p.getIvs().getAtk(), stat);
		case DEF:
			return calculateStat(p, p.getStats().getDef(), p.getEvs().getDef(), p.getIvs().getDef(), stat);
		case SPA:
			return calculateStat(p, p.getStats().getSpa(), p.getEvs().getSpa(), p.getIvs().getSpa(), stat);
		case SPD:
			return calculateStat(p, p.getStats().getSpd(), p.getEvs().getSpd(), p.getIvs().getSpd(), stat);
		case SPE:
			return calculateStat(p, p.getStats().getSpe(), p.getEvs().getSpe(), p.getIvs().getSpe(), stat);
		default:
			return 1;
		}
	}
	
	public static double calculateStat(Pokemon p, int base, int ev, int iv, Stat stat) {
		double num = ((2*base+iv+(ev/4))*p.getLvl());
		return (((num/100)+5)*p.getNature().getMod(stat))*calculateStageMult(p, stat);
	}
	public static double calculateHP(Pokemon p, int base, int ev, int iv) {
		double num = ((2*base+iv+(ev/4))*p.getLvl());
		return (num/100)+p.getLvl()+10;
	}
	
	public static double calculateStageMult(Pokemon p, Stat stat) {
		switch(p.getStageMult().get(stat)) {
		case(-6): return (2.0/8.0);
		case(-5): return (2.0/7.0);
		case(-4): return (2.0/6.0);
		case(-3): return (2.0/5.0);
		case(-2): return (2.0/4.0);
		case(-1): return (2.0/3.0);
		case(0): return (2.0/2.0);
		case(1): return (3.0/2.0);
		case(2): return (4.0/2.0);
		case(3): return (5.0/2.0);
		case(4): return (6.0/2.0);
		case(5): return (7.0/2.0);
		case(6): return (8.0/2.0);
		default: return 1;
		}
	}
}

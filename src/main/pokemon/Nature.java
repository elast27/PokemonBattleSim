package main.pokemon;

import java.util.Arrays;
import java.util.List;

public class Nature {
	private int id;
	private String name;
	private Stat positive;
	private Stat negative;
	
	private static List<Nature> natures = initNatures();
	
	public Nature(int id, String name, Stat positive, Stat negative) {
		super();
		this.id = id;
		this.name = name;
		this.positive = positive;
		this.negative = negative;
	}
	public static List<Nature> initNatures() {
		final Nature HARDY = new Nature(0, "Hardy", null, null);
		final Nature LONELY = new Nature(1, "Lonely", Stat.ATK, Stat.DEF);
		final Nature BRAVE = new Nature(2, "Brave", Stat.ATK, Stat.SPE);
		final Nature ADAMANT = new Nature(3, "Adamant", Stat.ATK, Stat.SPA);
		final Nature NAUGHTY = new Nature(4, "Naughty", Stat.ATK, Stat.SPD);
		final Nature BOLD = new Nature(5, "Bold", Stat.DEF, Stat.ATK);
		final Nature DOCILE = new Nature(6, "Docile", null, null);
		final Nature RELAXED = new Nature(7, "Relaxed", Stat.DEF,Stat.SPE);
		final Nature IMPISH = new Nature(8, "Impish", Stat.DEF, Stat.SPA);
		final Nature LAX = new Nature(9, "Lax", Stat.DEF, Stat.SPD);
		final Nature TIMID = new Nature(10, "Timid", Stat.SPE, Stat.ATK);
		final Nature HASTY = new Nature(11,"Hasty", Stat.SPE, Stat.DEF);
		final Nature SERIOUS = new Nature(12,"Serious", null, null);
		final Nature JOLLY = new Nature(13,"Jolly", Stat.SPE, Stat.SPA);
		final Nature NAIVE = new Nature(14,"Naive", Stat.SPE, Stat.SPD);
		final Nature MODEST = new Nature(15,"Modest", Stat.SPA, Stat.ATK);
		final Nature MILD = new Nature(16,"Mild", Stat.SPA, Stat.DEF);
		final Nature QUIET = new Nature(17,"Quiet", Stat.SPA, Stat.SPE);
		final Nature BASHFUL = new Nature(18, "Bashful", null, null);
		final Nature RASH = new Nature(19, "Rash", Stat.SPA, Stat.SPD);
		final Nature CALM = new Nature(20, "Calm", Stat.SPD, Stat.ATK);
		final Nature GENTLE = new Nature(21,"Gentle", Stat.SPD, Stat.DEF);
		final Nature SASSY = new Nature(22,"Sassy",Stat.SPD,Stat.SPE);
		final Nature CAREFUL = new Nature(23,"Careful",Stat.SPD,Stat.SPA);
		final Nature QUIRKY = new Nature(24,"Quirky",null,null);
		Nature[] ns = {HARDY, LONELY, BRAVE, ADAMANT, NAUGHTY, BOLD, DOCILE, RELAXED, IMPISH, LAX, TIMID, HASTY, SERIOUS, JOLLY, NAIVE, MODEST, MILD, QUIET, BASHFUL, RASH, CALM, GENTLE, SASSY, CAREFUL, QUIRKY};
		return Arrays.asList(ns);
	}
	public static final Nature HARDY = natures.get(0);
	public static final Nature LONELY = natures.get(1);
	public static final Nature BRAVE = natures.get(2);
	public static final Nature ADAMANT = natures.get(3);
	public static final Nature NAUGHTY = natures.get(4);
	public static final Nature BOLD = natures.get(5);
	public static final Nature DOCILE = natures.get(6);
	public static final Nature RELAXED = natures.get(7);
	public static final Nature IMPISH = natures.get(8);
	public static final Nature LAX = natures.get(9);
	public static final Nature TIMID = natures.get(10);
	public static final Nature HASTY = natures.get(11);
	public static final Nature SERIOUS = natures.get(12);
	public static final Nature JOLLY = natures.get(13);
	public static final Nature NAIVE = natures.get(14);
	public static final Nature MODEST = natures.get(15);
	public static final Nature MILD = natures.get(16);
	public static final Nature QUIET = natures.get(17);
	public static final Nature BASHFUL = natures.get(18);
	public static final Nature RASH = natures.get(19);
	public static final Nature CALM = natures.get(20);
	public static final Nature GENTLE = natures.get(21);
	public static final Nature SASSY = natures.get(22);
	public static final Nature CAREFUL = natures.get(23);
	public static final Nature QUIRKY = natures.get(24);
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Stat getPositive() {
		return positive;
	}


	public void setPositive(Stat positive) {
		this.positive = positive;
	}


	public Stat getNegative() {
		return negative;
	}


	public void setNegative(Stat negative) {
		this.negative = negative;
	}


	public double getMod(Stat nature) {
		if(nature.equals(this.positive)) return 1.1;
		else if(nature.equals(this.negative)) return 0.9;
		else return 1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Nature getNature(int id) {
		return natures.get(id);
	}
}

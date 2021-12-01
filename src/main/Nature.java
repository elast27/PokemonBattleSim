package main;

import java.util.Arrays;
import java.util.List;

public class Nature {
	private int id;
	private String name;
	private String positive;
	private String negative;
	
	private static List<Nature> natures = initNatures();
	
	public Nature(int id, String name, String positive, String negative) {
		super();
		this.id = id;
		this.name = name;
		this.positive = positive;
		this.negative = negative;
	}
	public static List<Nature> initNatures() {
		final Nature HARDY = new Nature(0, "Hardy", null, null);
		final Nature LONELY = new Nature(1, "Lonely", "atk", "def");
		final Nature BRAVE = new Nature(2, "Brave", "atk", "spe");
		final Nature ADAMANT = new Nature(3, "Adamant", "atk", "spa");
		final Nature NAUGHTY = new Nature(4, "Naughty", "atk", "spd");
		final Nature BOLD = new Nature(5, "Bold", "def", "atk");
		final Nature DOCILE = new Nature(6, "Docile", null, null);
		final Nature RELAXED = new Nature(7, "Relaxed", "def","spe");
		final Nature IMPISH = new Nature(8, "Impish", "def", "spa");
		final Nature LAX = new Nature(9, "Lax", "def", "spd");
		final Nature TIMID = new Nature(10, "Timid", "spe", "atk");
		final Nature HASTY = new Nature(11,"Hasty", "spe", "def");
		final Nature SERIOUS = new Nature(12,"Serious", null, null);
		final Nature JOLLY = new Nature(13,"Jolly", "spe", "spa");
		final Nature NAIVE = new Nature(14,"Naive", "spe", "spd");
		final Nature MODEST = new Nature(15,"Modest", "spa", "atk");
		final Nature MILD = new Nature(16,"Mild", "spa", "def");
		final Nature QUIET = new Nature(17,"Quiet", "spa", "spe");
		final Nature BASHFUL = new Nature(18, "Bashful", null, null);
		final Nature RASH = new Nature(19, "Rash", "spa", "spd");
		final Nature CALM = new Nature(20, "Calm", "spd", "atk");
		final Nature GENTLE = new Nature(21,"Gentle", "spd", "def");
		final Nature SASSY = new Nature(22,"Sassy","spd","spe");
		final Nature CAREFUL = new Nature(23,"Careful","spd","spa");
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


	public String getPositive() {
		return positive;
	}


	public void setPositive(String positive) {
		this.positive = positive;
	}


	public String getNegative() {
		return negative;
	}


	public void setNegative(String negative) {
		this.negative = negative;
	}


	public double getMod(String nature) {
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

package main.item;

public class Plate extends Item {
	public static final Plate ICICLE_PLATE = new Plate("Icicle Plate","Increases Ice move",m->{
		if(m.getType().getType().equals("Ice")) return true;
		return false;
	});
	public Plate(String name, String desc, ItemEffect e) {
		super(name, desc, e);
	}
}

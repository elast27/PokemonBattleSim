package main.move;

import main.pokemon.Type;

public class EffectMove extends Move {
	StatusMoveEffect e;
	EffectMove(String name, Type type, int power, int acc, int pp, DamageType damageType, String desc){
		super(name,type,power,acc,pp,damageType,desc);
	}
	
	EffectMove(String name, Type type, int power, int acc, int pp, DamageType damageType, String desc, StatusMoveEffect e){
		super(name,type,power,acc,pp,damageType,desc);
		this.e = e;
	}
	
	public void setEffect(StatusMoveEffect e) {
		this.e = e;
	}
	
	public StatusMoveEffect getEffect() {
		return e;
	}
}

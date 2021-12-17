package main;

import main.Move.DamageType;

public class FlinchingMove extends Move {
	StatusMoveEffect e;
	FlinchingMove(String name, Type type, int power, int acc, int pp, DamageType damageType, String desc){
		super(name,type,power,acc,pp,damageType,desc);
	}
	
	FlinchingMove(String name, Type type, int power, int acc, int pp, DamageType damageType, String desc, StatusMoveEffect e){
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

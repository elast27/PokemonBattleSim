package main;

import main.Move.DamageType;

public class StatusMove extends Move {
	StatusMoveEffect e;
	boolean isSelf;
	
	StatusMove(String name, Type type, int power, int acc, int pp, DamageType damageType, String desc){
		super(name,type,power,acc,pp,damageType,desc);
	}
	
	StatusMove(String name, Type type, int power, int acc, int pp, DamageType damageType, String desc, StatusMoveEffect e, boolean target){
		super(name,type,power,acc,pp,damageType,desc);
		this.e = e;
		this.isSelf = target;
	}
	
	public void setEffect(StatusMoveEffect e) {
		this.e = e;
	}
	
	public StatusMoveEffect getEffect() {
		return e;
	}
	
	public void setTarget(boolean b) {
		isSelf = b;
	}
	public boolean getTarget() {
		return isSelf;
	}
}

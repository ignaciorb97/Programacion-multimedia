package ej2;

import java.io.Serializable;

public class Pokemon implements Serializable {

	public String pkName;
	public int pkVida;
	public int pkAtk;
	public int pkDef;

	public Pokemon(String pkName, int pkVida, int pkAtk, int pkDef) {
		this.pkName = pkName;
		this.pkVida = pkVida;
		this.pkAtk = pkAtk;
		this.pkDef = pkDef;
	}
}

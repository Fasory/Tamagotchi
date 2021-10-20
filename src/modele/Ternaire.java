package modele;

import javax.management.InvalidAttributeValueException;

public class Ternaire {
	
	/* var peut prendre que trois valeurs possibles :
	 * -1,		0,		1
	 */
	short var;
	
	public Ternaire(short var) {
		if (var == -1 || var == 0 || var == 1) this.var = var;
		else throw new InvalidAttributeValueException​("");
	}
}

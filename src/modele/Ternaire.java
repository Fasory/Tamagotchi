package modele;

/**
 * Objet représentant qu'un état parmis		<br/>
 * 3 possibles :							<br/>
 * 											<br/>
 * -1,		0,		1						<br/>
 */
public class Ternaire {
	
	/* var peut prendre que trois valeurs possibles :		<br/>
	 * -1,		0,		1									<br/>
	 */
	private int var;
	
	/**
	 * Constructeur														<br/>
	 * 																	<br/>
	 * Si la valeur est invalide, -1 est affecté à var					<br/>
	 * 																	<br/>
	 * @param var - valeur affecter à l'objet Ternaire (-1, 0 ou 1)		<br/>
	 */
	public Ternaire(int var) {
		if (var == -1 || var == 0 || var == 1) this.var = var;
		else this.var = -1;
	}
	
	/**
	 * Constructeur					<br/>
	 * 								<br/>
	 * Par défaut, var vaut -1		<br/>
	 */
	public Ternaire() {
		this(-1);
	}
	
	/**
	 * Getteur
	 * 
	 * @return retourne la valeur de var
	 */
	public int getVar() {
		return var;
	}
	
	/**
	 * Setteur
	 * 
	 * @param var - change la valeur de var entre -1, 0 et 1
	 * si la valeur est différente, par défaut var vaut -1
	 */
	public void setVar(int var) {
		if (var == -1 || var == 0 || var == 1) this.var = var;
		else this.var = -1;
	}
}

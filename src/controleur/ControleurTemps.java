package controleur;

public class ControleurTemps extends ControleurGeneral {
	
	private static int estCree = 0;					// Repère de création d'une unique instance par type de controleur


	public ControleurTemps() {
		super(estCree);
		estCree++;
	}
}

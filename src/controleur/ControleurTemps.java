package controleur;

public class ControleurTemps extends Controleur {
	
	private static boolean estCree = false;					// Repère de création d'une unique instance par type de controleur


	public ControleurTemps() {
		super(estCree);
		estCree = true;
	}
	
	@Override
	public void delControleur() {
		estCree = false;
	}
}

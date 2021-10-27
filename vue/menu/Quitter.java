package menu;

import controleur.ControleurGeneral;

public class Quitter extends MenuDeConfirmation {
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public Quitter(ControleurGeneral controleur) {
		this(controleur, "Êtes-vous sûr de vouloir fermer l'application ?");
	}
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param msg - String afficher pour demander la	<br/>
	 * confirmation de quitter							<br/>
	 */
	public Quitter(ControleurGeneral controleur, String msg) {
		super(controleur, msg, "Oui", "Annuler");
	}
	
	/**
	 * Demande de fermeture de l'application			<br/>
	 */
	@Override
	public void cmdConfirmation() {
		controleur.ctrlDeBouton.rqtQuitter();
	}
}

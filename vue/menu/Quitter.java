package menu;

import controleur.Controleur;

public class Quitter extends MenuDeConfirmation {
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public Quitter(Controleur controleur) {
		this(controleur, "Êtes-vous sûr de vouloir fermer l'application ?");
	}
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param msg - String afficher pour demander la	<br/>
	 * confirmation de quitter							<br/>
	 */
	public Quitter(Controleur controleur, String msg) {
		super(controleur, msg, "Oui", "Annuler");
	}
	
	/**
	 * Demande de fermeture de l'application			<br/>
	 */
	@Override
	public void cmdConfirmation() {
		controleur.rqtQuitter();
	}
}

package menu;

import controleur.ControleurGeneral;

public class QuitterConfirm extends MenuConfirmation {
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public QuitterConfirm(ControleurGeneral controleur) {
		this(controleur, "Êtes-vous sûr de vouloir fermer l'application ?");
	}
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param msg - String afficher pour demander la	<br/>
	 * confirmation de quitter							<br/>
	 */
	public QuitterConfirm(ControleurGeneral controleur, String msg) {
		super(controleur, msg, "Oui", "Annuler");
	}
	
	/**
	 * Demande de fermeture de l'application			<br/>
	 */
	@Override
	public void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtQuitter();
	}
}

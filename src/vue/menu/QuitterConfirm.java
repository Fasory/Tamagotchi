package vue.menu;

import controleur.ControleurGeneral;

public class QuitterConfirm extends MenuConfirmation {
	
	/**
	 * Contructeur de la classe QuitterConfirm sans paramètre
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public QuitterConfirm() {
		this("Êtes-vous sûr de vouloir fermer l'application ?");
	}
	
	/**
	 * Contructeur de la classe QuitterConfirm avec parmètre
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param msg - String afficher pour demander la	<br/>
	 * confirmation de quitter							<br/>
	 */
	public QuitterConfirm(String msg) {
		super(msg, "Oui", "Annuler");
	}
	
	/**
	 * Demande de fermeture de l'application			<br/>
	 */
	@Override
	protected void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtQuitter();
	}
}

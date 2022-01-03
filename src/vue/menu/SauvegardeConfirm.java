package vue.menu;

import controleur.ControleurGeneral;

/**
 * La classe SauvegardeConfirm gère le menu "Confirmation de sauvegarde", 
 * menu accessible après le menu "Pause",
 * lorsqu'on clique sur le bouton "Sauvegarde"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class SauvegardeConfirm extends MenuConfirmation {
	
	/**
	 * Contructeur de la classe SauvegardeConfirm sans paramètre
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public SauvegardeConfirm() {
		this("Sauvegarder la partie ?");
	}
	
	/**
	 * Contructeur de la classe SauvegardeConfirm avec parmètre
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param msg - String afficher pour demander la	<br/>
	 * confirmation de sauvegarde						<br/>
	 */
	public SauvegardeConfirm(String msg) {
		// Appel au constructeur de la super classe MenuConfirmation
		super(msg, "Oui", "Annuler", false, true);
	}
	
	/**
	 * Demande de sauvegarde de la partie		<br/>
	 */
	@Override
	protected void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtSauvegarde();
	}
}
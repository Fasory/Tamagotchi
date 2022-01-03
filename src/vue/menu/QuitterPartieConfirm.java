package vue.menu;

import controleur.ControleurGeneral;

/**
 * La classe QuitterPartieConfirm gère le menu "Confirmation pour quitter une partie", 
 * menu accessible après le menu "Pause",
 * lorsqu'on clique sur le bouton "Quitter"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class QuitterPartieConfirm extends MenuConfirmation {
	
	/**
	 * Contructeur de la classe QuitterPartieConfirm sans paramètre
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public QuitterPartieConfirm() {
		this("Voulez-vous quitter la partie ?");
	}
	
	/**
	 * Contructeur de la classe QuitterPartieConfirm avec parmètre
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param msg - String afficher pour demander la	<br/>
	 * confirmation pour quitter la partie						<br/>
	 */
	public QuitterPartieConfirm(String msg) {
		// Appel au constructeur de la super classe MenuConfirmation
		super(msg, "Oui", "Annuler", false, true);
		setAlerte("confirmAlerte", "La sauvegarde d'une partie n'est pas automatique");
	}
	
	/**
	 * Demande pour quitter la partie		<br/>
	 */
	@Override
	protected void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtRevenirMenuPrincipal();
		ControleurGeneral.ctrlBouton.rqtRetourConfirmation();
	}
}

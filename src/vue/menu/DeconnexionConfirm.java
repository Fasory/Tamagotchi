package vue.menu;

import controleur.ControleurGeneral;

/**
 * La classe DeconnexionConfirm gère le menu 
 * "Confirmation de déconnexion", ce menu se lance
 * à chaque demande de déconnexion afin de 
 * la confirmer ou de l'annuler.
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class DeconnexionConfirm extends MenuConfirmation {
	
	/**
	 * Contructeur de la classe DeconnexionConfirm sans paramètre
	 *
	 */
	public DeconnexionConfirm() {
		this("Êtes-vous sûr de vouloir vous déconnecter ?");
	}
	
	/**
	 * Contructeur de la classe DeconnexionConfirm avec paramètres
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param msg - String afficher pour demander la	<br/>
	 * confirmation de quitter							<br/>
	 */
	public DeconnexionConfirm(String msg) {
		// Appel au constructeur de la super classe MenuConfirmation
		super(msg, "Oui", "Annuler", false, false);
	} 
	
	/**
	 * Demande de fermeture de l'application			<br/>
	 */
	@Override
	protected void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtDeconnexion();
		ControleurGeneral.ctrlBouton.rqtRetourConfirmation();
	}
}
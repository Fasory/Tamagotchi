package menu;

import controleur.ControleurGeneral;

public class DeconnexionConfirm extends MenuConfirmation {
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public DeconnexionConfirm(ControleurGeneral controleur) {
		this(controleur, "Êtes-vous sûr de vouloir vous déconnecter ?");
	}
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param msg - String afficher pour demander la	<br/>
	 * confirmation de quitter							<br/>
	 */
	public DeconnexionConfirm(ControleurGeneral controleur, String msg) {
		super(controleur, msg, "Oui", "Annuler");
	}
	
	/**
	 * Demande de fermeture de l'application			<br/>
	 */
	@Override
	public void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtDeconnexion();
		ControleurGeneral.ctrlBouton.rqtRetourConfirmation();
	}
}
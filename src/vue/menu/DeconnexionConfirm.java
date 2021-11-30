package vue.menu;

import controleur.ControleurGeneral;

public class DeconnexionConfirm extends MenuConfirmation {
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 */
	public DeconnexionConfirm() {
		this("Êtes-vous sûr de vouloir vous déconnecter ?");
	}
	
	/**
	 * Contructeur
	 * 
	 * @param controleur - Contoleur de l'application	<br/>
	 * @param msg - String afficher pour demander la	<br/>
	 * confirmation de quitter							<br/>
	 */
	public DeconnexionConfirm(String msg) {
		super(msg, "Oui", "Annuler");
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
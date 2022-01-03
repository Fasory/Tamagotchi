package vue.menu;

import controleur.ControleurGeneral;

/**
 * La classe ReinitialiserMdpConfirm gère le menu 
 * "Confimation de réinitialisation du mot de passe", 
 * menu accessible après le menu "Réinitialiser mot de passe"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class ReinitialiserMdpConfirm extends MenuConfirmation {
	
	/**
	 * Constructeur de la classe ReinitialiserMdpConfirm 
	 */
	
	public ReinitialiserMdpConfirm() {
		// Appel au constructeur de la super classe Menu Confirmation 
		super("Veuillez entrer le code de validation\nenvoyé par mail.", "Confirmer", "Annuler", true);
	}

	/**
	 * Demande de confirmation de l'inscription
	 */
	@Override
	protected void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtConfirmeCodeMdp(txtSaisie.getText());
	}

}

package vue.menu;

import controleur.ControleurGeneral;

public class ReinitialiserMdpConfirm extends MenuConfirmation {
	
	/**
	 * Constructeur de la classe ReinitialiserMdpConfirm 
	 */
	
	public ReinitialiserMdpConfirm() {
		// Appel au constructeur de la super classe Menu Confirmation 
		super("Veuillez entrer le code de validation envoyé par mail.", "Confirmer", "Annuler", true);
	}

	/**
	 * Demande de confirmation de l'inscription
	 */
	@Override
	protected void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtConfirmeCodeMdp(txtSaisie.getText());
	}

}

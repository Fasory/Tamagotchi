package vue.menu;

import controleur.ControleurGeneral;

public class InscriptionConfirm extends MenuConfirmation {
	
	/**
	 * Constructeur
	 */
	public InscriptionConfirm() {
		super("Veuillez entrer le code de validation envoyé par mail.", "Confirmer", "Annuler", true);
	}

	/**
	 * Demande de confirmation de l'inscription
	 */
	@Override
	protected void cmdConfirmation() { 
		ControleurGeneral.ctrlBouton.rqtConfirmeCodeInscri(txtSaisie.getText());
	}
}
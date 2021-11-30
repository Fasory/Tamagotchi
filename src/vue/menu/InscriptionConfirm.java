package vue.menu;

import controleur.ControleurGeneral;

public class InscriptionConfirm extends MenuConfirmation {

	public InscriptionConfirm() {
		super("Veuillez entrer le code de validation envoyé par mail.", "Confirmer", "Annuler", true);
	}


	@Override
	protected void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtConfirmeCode(txtSaisie.getText());
	}
}
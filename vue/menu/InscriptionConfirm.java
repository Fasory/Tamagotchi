package menu;

import controleur.ControleurGeneral;

public class InscriptionConfirm extends MenuConfirmation {

	public InscriptionConfirm(ControleurGeneral controleur) {
		super(controleur, "Veuillez entrer le code de validation envoyé par mail.", "Confirmer", "Annuler", true);
	}


	@Override
	public void cmdConfirmation() {
		ControleurGeneral.ctrlBouton.rqtConfirmeCode(txtSaisie.getText());
	}
}
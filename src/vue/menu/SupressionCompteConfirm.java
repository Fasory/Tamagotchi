package vue.menu;

import controleur.ControleurGeneral;

public class SupressionCompteConfirm extends MenuConfirmation{
	
	public SupressionCompteConfirm() {
		super("Voulez-vous vraiment supprimer votre compte ?", "Oui", "Annuler");
		setAlerte("confirmAlerte", "Les données liées à votre compte seront toutes supprimées.");
	}

	@Override
	protected void cmdConfirmation() {
		ControleurGeneral.ctrlConnexion.confirmationSuppressionCompte();
	}

}

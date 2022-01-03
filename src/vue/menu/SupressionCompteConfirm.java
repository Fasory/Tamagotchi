package vue.menu;

import controleur.ControleurGeneral;

/**
 * La classe SupressionCompteConfirm gère le menu 
 * "Confirmation de supression du compte", 
 * menu accessible après le menu "Option",
 * lorsqu'on clique sur le bouton "Supprimer le compte"
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class SupressionCompteConfirm extends MenuConfirmation{
	
	/**
	 * Constructeur de la classe SupressionCompteConfirm 
	 */
	
	public SupressionCompteConfirm() {
		// Appel au constructeur de la super classe MenuConfirm
		super("Voulez-vous vraiment supprimer votre compte ?", "Oui", "Annuler");
		setAlerte("confirmAlerte", "Les données liées à votre compte seront toutes supprimées.");
	}

	@Override
	protected void cmdConfirmation() {
		ControleurGeneral.ctrlConnexion.confirmationSuppressionCompte();
	}

}

package vue.menu;

import controleur.ControleurGeneral;

/**
 * La classe InscriptionConfirm gère le menu "Confirmation d'inscription", 
 * menu accessible après le menu "Inscription",
 * lorsqu'on clique sur le bouton "S'inscrire" 
 * 
 * @author BIDAULT, BOUQUET, HAGUET, CASANOVA, BRZUSTOWSKI
 *
 */

public class InscriptionConfirm extends MenuConfirmation {
	
	/**
	 * Constructeur de la classe InscriptionConfirm 
	 */
	public InscriptionConfirm() {
		// Appel au constructeur de la super classe MenuConfirmation
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
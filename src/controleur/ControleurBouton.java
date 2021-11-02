package controleur;

import menu.Credits;
import menu.Option;
import menu.OubliMdp;
import menu.Quitter;

/**
 * Sous contrôleur qui a pour objectif de gérer les		<br/>
 * requêtes créées par l'actionnement des boutons		<br/>
 * de l'application										<br/>
 * 														<br/>
 * Le bouton de fermeture de la fenêtre est				<br/>
 * également pris en charge ici							<br/>
 */
public class ControleurBouton extends ControleurGeneral {
	
	private static int estCree = 0;					// Repère de création d'une unique instance par type de controleur
	
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur des boutons de l'application	<br/>
	 */
	public ControleurBouton() {
		super(estCree);
		estCree++;
	}
	
	
	////////////////////////////////////////
	//          REQUETES VERS LE          //
	//            CONTROLEUR DE           //
	//               BOUTON               //
	////////////////////////////////////////
	
	/**
	* Demande de changement de menu : MenuCreerPartie		<br/>
	*/
	public void rqtMenuCreerPartie() {
		System.out.println("Clic");
	}
	
	/**
	* Demande de changement de menu : MenuSelecPartie		<br/>
	*/
	public void rqtMenuSelecPartie() {
	
	}
	
	/**
	* Demande de changement de menu : MenuOption			<br/>
	*/
	public void rqtMenuOption() {
		pileMenu.push(new Option(this));
		fenetrePrincipale.changePanel(pileMenu.peek());
		fenetrePrincipale.mettreEnAvant(true);
	}
	
	/**
	* Demande de changement de menu : MenuScore				<br/>
	*/
	public void rqtMenuScore() {
	
	}
	
	/**
	* Demande une confirmation pour fermer l'application					<br/>
	*/
	public void rqtDemandeQuitter() {
		fenetrePrincipale.mettreEnPause(true);
		fenetreDeConfirmation.changePanel(new Quitter(this));
		fenetreDeConfirmation.mettreEnPause(false);
		fenetreDeConfirmation.mettreEnAvant(true);
	}
	
	/**
	* Ferme l'application													<br/>
	*/
	public void rqtQuitter() {
		fenetrePrincipale.mettreEnPause(true);
		fenetrePrincipale.mettreEnAvant(false);
		fenetrePrincipale.dispose();
		fenetreDeConfirmation.dispose();
		ctrlFichier.delControleurDeFichier();
		System.exit(0);
	}
	
	/**
	 * Recentre l'activité de l'application sur le fenêtre principale		<br/>
	 * dans l'état qu'elle été restée avant la demande de confirmation		<br/>
	 */
	public void rqtAnnuleConfirmation() {
		fenetreDeConfirmation.mettreEnPause(true);
		fenetreDeConfirmation.mettreEnAvant(false);
		fenetrePrincipale.mettreEnPause(false);
		fenetrePrincipale.mettreEnAvant(true);
	}
	
	/**
	 * Redirige l'utilisateur vers le menu d'oublie de mot de passe			<br/>
	 */
	public void rqtOublieDeMdp() {
		pileMenu.push(new OubliMdp(this));
		fenetrePrincipale.changePanel(pileMenu.peek());
		fenetrePrincipale.mettreEnAvant(true);
	}
	
	/**
	 * Redirige l'utilisateur vers le menu des crédits
	 */
	public void rqtAffichageCredits() {
		pileMenu.push(new Credits(this));
		fenetrePrincipale.changePanel(pileMenu.peek());
		fenetrePrincipale.mettreEnAvant(true);
	}
	
	/**
	 * Redirige l'utilisateur vers le menu précédent
	 */
	public void rqtRetour() {
		pileMenu.pop();
		fenetrePrincipale.changePanel(pileMenu.peek());
		fenetrePrincipale.mettreEnAvant(true);
	}
}

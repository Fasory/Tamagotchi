package controleur;

import menu.Quitter;

/**
 * Sous contrôleur qui a pour objectif de gérer les		<br/>
 * requêtes créées par l'actionnement des boutons		<br/>
 * de l'application										<br/>
 * 														<br/>
 * Le bouton de fermeture de la fenêtre est				<br/>
 * également pris en charge ici							<br/>
 */
public class ControleurDeBouton extends ControleurGeneral {
	
	private static int estCree = 0;					// Repère de création d'une unique instance par type de controleur
	
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur des boutons de l'application	<br/>
	 */
	public ControleurDeBouton() {
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
		ctrlDeFichier.delControleurDeFichier();
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
		
	}
}

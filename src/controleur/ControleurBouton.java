package controleur;

import menu.Credits;
import menu.Deconnexion;
import menu.Inscription;
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
	
	
	////////////////////////////////////////
	//         REQUETES CHANGEMENT        //
	//               DE MENU              //
	////////////////////////////////////////
	
	/**
	* Demande de changement de menu : MenuCreerPartie		<br/>
	*/
	public void rqtMenuCreerPartie() {
		
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
		ctrlAffichage.ouvrirMenu(new Option(this));
		
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
		ctrlAffichage.ouvrirMenuConfirmation(new Quitter(this));
	}
	
	/**
	 * Redirige l'utilisateur vers le menu d'oublie de mot de passe			<br/>
	 */
	public void rqtOublieDeMdp() {
		ctrlAffichage.ouvrirMenu(new OubliMdp(this));
	}
	
	/**
	 * Redirige l'utilisateur vers le menu des crédits						<br/>
	 */
	public void rqtAffichageCredits() {
		ctrlAffichage.ouvrirMenu(new Credits(this));
	}
	
	/**
	 * Redirige l'utilisateur vers le menu d'inscription					<br/>
	 */
	public void rqtInscription() {
		ctrlAffichage.ouvrirMenu(new Inscription(this));
	}
	
	/**
	 * Redirige l'utilisateur vers le menu précédent						<br/>
	 */
	public void rqtRetour() {
		ctrlAffichage.menuPrecedent();
	}
	
	
	////////////////////////////////////////
	//           REQUETES DEMANDE         //
	//             CONFIRMATION           //
	////////////////////////////////////////
	
	/**
	* Demande une confirmation pour déconnecte l'utilisateur				<br/>
	*/
	public void rqtDemandeDeconnexion() {
		ctrlAffichage.ouvrirMenuConfirmation(new Deconnexion(this));
	}
	
	/**
	 * Recentre l'activité de l'application sur le fenêtre principale		<br/>
	 * dans l'état qu'elle été restée avant la demande de confirmation		<br/>
	 */
	public void rqtRetourConfirmation() {
		ctrlAffichage.fermerMenuConfirmation();
	}
	
	
	////////////////////////////////////////
	//         REQUETES CONNEXION         //
	//           / INSCRIPTION            //
	////////////////////////////////////////
	
	/**
	* Déconnecte l'utilisateur												<br/>
	*/
	public void rqtDeconnexion() {
		ctrlConnexion.deconnexion();
		ctrlAffichage.menuPrecedent();
	}
	
	/**
	 * Tentative de connexion												<br/>
	 * 																		<br/>
	 * @param utilisateur - String représentant le nom du joueur			<br/>
	 * @param mdp - char[] représentant le mot de passe						<br/>
	 */
	public void rqtConnexion(String utilisateur, char[] mdp) {
		String strMdp = new String(mdp);
		if (utilisateur.equals("")) {
			if (strMdp.equals("")) ctrlAffichage.afficherAlerte("Veuillez saisir votre identifiant et votre mot de passe.");
			else ctrlAffichage.afficherAlerte("Veuillez saisir votre identifiant.");
		} else if (strMdp.equals("") && !utilisateur.equals(NOM_ANONYME)) ctrlAffichage.afficherAlerte("Veuillez saisir votre mot de passe.");
		else if (!ctrlConnexion.connexion(utilisateur, strMdp)) ctrlAffichage.afficherAlerte("Votre identifiant ou votre mot de passe est incorret.");
	}
	
	
	////////////////////////////////////////
	//          REQUETES AUTRES           //
	////////////////////////////////////////
	
	/**
	* Ferme l'application													<br/>
	*/
	public void rqtQuitter() {
		quitter();
	}
	
}

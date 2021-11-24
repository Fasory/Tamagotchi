package controleur;

import vue.menu.Credits;
import vue.menu.CreerPartie;
import vue.menu.DeconnexionConfirm;
import vue.menu.Inscription;
import vue.menu.Option;
import vue.menu.OubliMdp;
import vue.menu.Politique;
import vue.menu.QuitterConfirm;
import vue.menu.Score;
import vue.menu.SelecPartie;

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
		ctrlAffichage.ouvrirMenu(new CreerPartie(this));
	}
	
	/**
	* Demande de changement de menu : MenuSelecPartie		<br/>
	*/
	public void rqtMenuSelecPartie() {
		ctrlAffichage.ouvrirMenu(new SelecPartie(this));
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
		ctrlAffichage.ouvrirMenu(new Score(this));
	}
	
	/**
	* Demande une confirmation pour fermer l'application					<br/>
	*/
	public void rqtDemandeQuitter() {
		if (BY_PASS) rqtQuitter();
		else ctrlAffichage.ouvrirMenuConfirmation(new QuitterConfirm(this));
	}
	
	/**
	 * Redirige l'utilisateur vers le menu d'oublie de mot de passe			<br/>
	 */
	public void rqtOublieDeMdp() {
		ctrlAffichage.ouvrirMenu(new OubliMdp(this));
	}
	
	/**
	 * Redirige l'utilisateur vers le menu de la  politique de				<br/>
	 * confidentialité														<br/>
	 */
	public void rqtAffichagePolitique() {
		ctrlAffichage.ouvrirMenu(new Politique(this));
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
		if (BY_PASS) rqtDeconnexion();
		else ctrlAffichage.ouvrirMenuConfirmation(new DeconnexionConfirm(this));
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
	}
	
	/**
	 * Tentative de connexion												<br/>
	 * 																		<br/>
	 * @param utilisateur - String représentant le nom du joueur			<br/>
	 * @param mdp - char[] représentant le mot de passe						<br/>
	 */
	public void rqtConnexion(String utilisateur, char[] mdp) {
		ctrlConnexion.connexion(utilisateur, new String(mdp));
	}
	
	/**
	 * Tentative d'inscription												<br/>
	 * 																		<br/>
	 * @param utilisateur - String représentant le nom du joueur			<br/>
	 * @param mail - String représentant l'adresse mail du joueur			<br/>
	 * @param mdp - char[] représentant le mot de passe						<br/>
	 * @param mdpConfirme - char[] représentant la confirmation du			<br/>
	 * mot de passe															<br/>
	 */
	public void rqtTentativeInscription(String utilisateur, String mail, char[] mdp, char[] mdpConfirme, boolean verifMail) {
		ctrlConnexion.inscription(utilisateur, mail, new String(mdp), new String(mdpConfirme), verifMail);
	}
	
	/**
	 * Vérification du code pour valider l'inscription						<br/>
	 * 																		<br/>
	 * @param code - String représentant le code à vérifier					<br/>
	 */
	public void rqtConfirmeCode(String code) {
		ctrlConnexion.verificationCode(code);
	}
	
	
	////////////////////////////////////////
	//              REQUETES              //
	//               OPTION               //
	////////////////////////////////////////
	
	/**
	 * Demande de changement de volume au controleur Audio
	 * @param volume
	 */
	public void rqtChangeVolume(int volume) {
		ControleurGeneral.ctrlAudio.changeVolume(volume);
	}
	
	/**
	 * Demande de changement du volume de la musique au controleur audio
	 * @param musique
	 */
	public void rqtChangeMusique(int musique) {
		ControleurGeneral.ctrlAudio.changeMusique(musique);
	}
	
	
	////////////////////////////////////////
	//          REQUETES AUTRES           //
	////////////////////////////////////////
	
	/**
	* Ferme l'application													<br/>
	*/
	public void rqtQuitter() {
		if (compte != null) ctrlConnexion.deconnexion();
		quitter();
	}
	
}

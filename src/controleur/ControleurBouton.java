package controleur;

import java.util.Random;

import javax.swing.JPanel;

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
import vue.menu.SupressionCompteConfirm;

/**
 * Sous contrôleur qui a pour objectif de gérer les		<br/>
 * requêtes créées par l'actionnement des boutons		<br/>
 * de l'application										<br/>
 * 														<br/>
 * Le bouton de fermeture de la fenêtre est				<br/>
 * également pris en charge ici							<br/>
 */
public class ControleurBouton extends Controleur {
	
	private static boolean estCree = false;					// Repère de création d'une unique instance par type de controleur
	
	/**
	 * Constructeur													<br/>
	 * 																<br/>
	 * Initialisation du controleur des boutons de l'application	<br/>
	 */
	public ControleurBouton() {
		super(estCree);
		estCree = true;
	}
	
	@Override
	public void delControleur() {
		estCree = false;
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
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new CreerPartie());
	}
	
	/**
	* Demande de changement de menu : MenuSelecPartie		<br/>
	*/
	public void rqtMenuSelecPartie() {
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new SelecPartie());
	}
	
	/**
	* Demande de changement de menu : MenuOption			<br/>
	*/
	public void rqtMenuOption() {
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new Option(ControleurGeneral.ctrlConnexion.isAnonyme()));
		
	}
	
	/**
	* Demande de changement de menu : MenuScore				<br/>
	*/
	public void rqtMenuScore() {
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new Score());
	}
	
	/**
	* Demande une confirmation pour fermer l'application					<br/>
	*/
	public void rqtDemandeQuitter() {
		if (ControleurGeneral.BY_PASS) rqtQuitter();
		else ControleurGeneral.ctrlAffichage.ouvrirMenuConfirmation(new QuitterConfirm());
	}
	
	/**
	 * Redirige l'utilisateur vers le menu d'oublie de mot de passe			<br/>
	 */
	public void rqtOublieDeMdp() {
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new OubliMdp());
	}
	
	/**
	 * Redirige l'utilisateur vers le menu de la  politique de				<br/>
	 * confidentialité														<br/>
	 */
	public void rqtAffichagePolitique() {
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new Politique());
	}
	
	/**
	 * Redirige l'utilisateur vers le menu des crédits						<br/>
	 */
	public void rqtAffichageCredits() {
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new Credits());
	}
	
	/**
	 * Redirige l'utilisateur vers le menu d'inscription					<br/>
	 */
	public void rqtInscription() {
		ControleurGeneral.ctrlAffichage.ouvrirMenu(new Inscription());
	}
	
	/**
	 * Redirige l'utilisateur vers le menu précédent						<br/>
	 */
	public void rqtRetour() {
		ControleurGeneral.ctrlAffichage.menuPrecedent();
	}
	
	
	
	
	////////////////////////////////////////
	//           REQUETES DEMANDE         //
	//             CONFIRMATION           //
	////////////////////////////////////////
	
	/**
	* Demande une confirmation pour déconnecte l'utilisateur				<br/>
	*/
	public void rqtDemandeDeconnexion() {
		if (ControleurGeneral.BY_PASS) rqtDeconnexion();
		else ControleurGeneral.ctrlAffichage.ouvrirMenuConfirmation(new DeconnexionConfirm());
	}
	
	/**
	 * Recentre l'activité de l'application sur le fenêtre principale		<br/>
	 * dans l'état qu'elle été restée avant la demande de confirmation		<br/>
	 */
	public void rqtRetourConfirmation() {
		ControleurGeneral.ctrlAffichage.fermerMenuConfirmation();
	}
	
	
	////////////////////////////////////////
	//         REQUETES CONNEXION         //
	//           / INSCRIPTION            //
	////////////////////////////////////////
	
	/**
	* Déconnecte l'utilisateur												<br/>
	*/
	public void rqtDeconnexion() {
		ControleurGeneral.ctrlConnexion.deconnexion();
	}
	
	/**
	 * Tentative de connexion												<br/>
	 * 																		<br/>
	 * @param utilisateur - String représentant le nom du joueur			<br/>
	 * @param mdp - char[] représentant le mot de passe						<br/>
	 */
	public void rqtConnexion(String utilisateur, char[] mdp) {
		ControleurGeneral.ctrlConnexion.connexion(utilisateur, new String(mdp));
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
		ControleurGeneral.ctrlConnexion.inscription(utilisateur, mail, new String(mdp), new String(mdpConfirme), verifMail);
	}
	
	/**
	 * Vérification du code pour valider l'inscription						<br/>
	 * 																		<br/>
	 * @param code - String représentant le code à vérifier					<br/>
	 */
	public void rqtConfirmeCodeInscri(String code) {
		ControleurGeneral.ctrlConnexion.verificationCodeInscri(code);
	}
	
	
	public void rqtReinitialiser(String utilisateur, String mail) {
		ControleurGeneral.ctrlConnexion.reinitialiserMdp(utilisateur, mail);
	}
	
	
	public void rqtConfirmeCodeMdp(String code) {
		ControleurGeneral.ctrlConnexion.verificationCodeMdp(code);
	}
	
	
	public void rqtChangeMdp(char[] mdp, char[] mdpConfirm) {
		ControleurGeneral.ctrlConnexion.verificationChangeMdp(new String(mdp), new String(mdpConfirm));
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
	 * Demande de supprimer le compte connecté
	 */
	public void rqtSuppressionCompte() {
		ControleurGeneral.ctrlAffichage.ouvrirMenuConfirmation(new SupressionCompteConfirm());
	}
	
	/**
	 * Demande de changement du volume de la musique au controleur audio
	 * @param musique
	 */
	public void rqtChangeMusique(int musique) {
		ControleurGeneral.ctrlAudio.changeMusique(musique);
	}
	
	//////////////////////////////////////////
	//         	 REQUETES CREATION			//
	//	             DE PARTIE				//
	//////////////////////////////////////////
	
	public void rqtChangeAffichagePanel(JPanel panel, CreerPartie menu, boolean affiche) {
		ControleurGeneral.ctrlAffichage.modifPanel(panel, menu, affiche);
	}
	
	public void rqtRandomType() {
		Random rng = new Random();
		ControleurGeneral.ctrlAffichage.changeType(rng.nextInt(ControleurGeneral.TYPE.length));
	}
	
	/**
	 * Redirige l'utilisateur vers le menu de jeu
	 */
	public void rqtJouer(String type, String nom, boolean triche) {
		ControleurGeneral.ctrlJeu.lancePartie(type, nom, triche);
	}
	
	////////////////////////////////////////
	//          REQUETES AUTRES           //
	////////////////////////////////////////
	
	/**
	* Ferme l'application													<br/>
	*/
	public void rqtQuitter() {
		ControleurGeneral.quitter();
	}
	
}

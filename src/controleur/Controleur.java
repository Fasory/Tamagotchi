package controleur;



import fenetre.FenetreDeConfirmation;
import fenetre.FenetrePrincipale;
import menu.Connexion;
import menu.Menu;
import menu.Quitter;

public class Controleur {
	
	public ControleurDeFichier ctrlDeFichier;								// Controleur assistant pour la gestion de fichiers
	private FenetrePrincipale fenetrePrincipale;							// Fenêtre principale qui contient les menus et le jeu
	private FenetreDeConfirmation fenetreDeConfirmation;					// Fenêtre destinée à demander la confirmation d'une action
	private Menu panelCourrant;

	/**
	 * Racine de l'application Tamagotchi									<br/>
	 * 																		<br/>
	 * @param args - liste de paramètres au lancement de l'application 		<br/>
	 */
	public static void main(String[] args) {
		new Controleur();
	}
	
	
	/**
	 * Constructeur							<br/>
	 * 										<br/>
	 * Initialisation de l'application		<br/>
	 */
	public Controleur() {
		// Création des controleurs assistants
		ctrlDeFichier = new ControleurDeFichier();
		ctrlDeFichier.addLogs("Satut	-	Lancement de l'application");
		// Création du menu courrant
		panelCourrant = new Connexion(this);
		// Ajustement secondaire
		// ...
		// Création des fenêtres primaires
		ctrlDeFichier.addLogs("		-	Création des fenêtres");
		fenetrePrincipale = new FenetrePrincipale(this, panelCourrant);
		fenetreDeConfirmation = new FenetreDeConfirmation(this);
		// Initialisation des attributs complémentaires
		// ...
		// Fin de la construction de l'application
		ctrlDeFichier.addLogs("Satut	-	Application opérationnelle");
	}
	
	
	////////////////////////////////////////
	//          REQUETES VERS LE          //
	//             CONTROLEUR             //        
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
	 * Change le curseur de l'application									<br/>
	 * 																		<br/>
	 * @param type - String corespondant au nom de fichier du curseur		<br/>
	 * sans l'extension (chemin du fichier : 'assets/cursor/')				<br/>
	 */
	public void rqtChangeCurseur(String type) {
		if (type.equals("default")) panelCourrant.curseurDefault();
		else if (type.equals("hand")) panelCourrant.curseurHand();
		else ctrlDeFichier.addLogs("Erreur		- le curseur de type '" + type + "' n'existe pas", true);
	}
	
	/**
	 * Change la couleur du texte d'oublie de mot de passe					<br/>
	 * 																		<br/>
	 * @param menu - Connexion du menu actuel pour changer					<br/>
	 * les couleurs															<br/>
	 */
	public void rqtCouleurOublieMdp(Connexion menu) {
		if (menu.getCouleurTxtOublieMdp().equals(menu.couleurEnSelec)) menu.setCouleurTxtOublieMdp(menu.couleurEnNonSelec);
		else menu.setCouleurTxtOublieMdp(menu.couleurEnSelec);
	}
	
	/**
	 * 
	 */
	public void rqtOublieDeMdp() {
		
	}
}
